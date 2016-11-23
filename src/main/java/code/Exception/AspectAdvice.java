package code.Exception;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.concurrent.CancellationException;

/**
 * Created by Knight_JXNU on 2016/9/27.
 */
@Aspect
@Component
public class AspectAdvice {

    /**
     * 切点
     * @Pointcut语法规则
     * execution()是最常用的切点函数，其语法如下所示：
        整个表达式可以分为五个部分：
        1、execution(): 表达式主体。
        2、第一个*号：表示返回类型，*号表示所有的类型。
        3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，code包、子孙包下所有类的方法。
        4、第二个*号：表示类名，*号表示所有的类。
        5、*(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数。
        可以查看 印象笔记 spring笔记 Aspectj 切入点（Pointcut）语法定义
     */
    @Pointcut("execution (* code..*.*(..))")
    public void advicePointcut(){}

    /**
     * before 在核心业务执行前执行，不能阻止核心业务的调用
     * @param joinPoint
     * @throws Exception
     */
    @Before(value = "advicePointcut()")
    public void before(JoinPoint joinPoint) throws Exception{
        String methodDes = getMethodDescription(joinPoint);
        Logger log = Logger.getLogger(joinPoint.getTarget().getClass());
        if(!methodDes.equals("")){
            log.info("method---" + methodDes + "---start!");
        }
        log.info(getMethodNameAndArgs(joinPoint));
    }

    /**
     * after 核心业务逻辑退出后（包括正常执行结束和异常退出），执行此advice
     * @param joinPoint
     * @throws Exception
     */
    @After(value = "advicePointcut()")
    public void after(JoinPoint joinPoint) throws Exception{
        String methodDes = getMethodDescription(joinPoint);
        if(!methodDes.equals("")){
            Logger log = Logger.getLogger(joinPoint.getTarget().getClass());
            log.info("method---" + methodDes + "---over!");
        }
    }

    /**
     * around 手动控制调用核心业务逻辑，以及调用前和调用后的处理
     * 注：当核心业务抛异常后，立即退出，转向 AfterAdvice 执行完 AfterAdvice，再转到 ThrowingAdvice
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "advicePointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        //调用核心逻辑
        Object retVal = proceedingJoinPoint.proceed();
        return retVal;
    }

    /**
     * afterreturning 核心业务逻辑调用正常退出后，不管是否有返回值，正常退出后，均执行此 advice
     * @param joinPoint
     * @param retVal
     */
    @AfterReturning(value = "advicePointcut()", returning = "retVal")
    public void afterReturning(JoinPoint joinPoint, String retVal){
    }

    /**
     * 核心业务逻辑调用异常退出后，执行此 advice，处理错误信息
     * 注：执行顺序在 around 之后
     * @param joinPoint
     * @param exception
     * @throws Exception
     */
    @AfterThrowing(value = "advicePointcut()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Throwable exception) throws Exception{
        String methodDes = getMethodDescription(joinPoint);
        Logger log = Logger.getLogger(joinPoint.getTarget().getClass());
        log.error("-------------------afterThrowing.handler.start-------------------");
        if(methodDes.equals("")){
            log.error("method:" + methodDes);
        }
        log.error(getMethodNameAndArgs(joinPoint));
        log.error("ConstantUtil.getTrace(e):" + getTrace(exception));
        log.error("exception name:" + exception.getClass().toString());
        log.error("exception message:" + exception.getMessage());
        log.error("-------------------afterThrowing.handler.end-------------------");

        if (exception.getClass().equals(DataAccessException.class)) {
            throw new BusinessException(ErrorCode.DataAccessException.des, ErrorCode.DataAccessException.code);
        } else if (exception.getClass().toString().equals(DataIntegrityViolationException.class.toString())) {
            throw new BusinessException(ErrorCode.DataIntegrityViolationException.des, ErrorCode.DataIntegrityViolationException.code);
        } else if (exception.getClass().toString().equals(NullPointerException.class.toString())) {
            throw new BusinessException(ErrorCode.NullPointerException.des, ErrorCode.NullPointerException.code);
        } else if (exception.getClass().equals(IOException.class)) {
            throw new BusinessException(ErrorCode.IOException.des, ErrorCode.IOException.code);
        } else if (exception.getClass().equals(ClassNotFoundException.class)) {
            throw new BusinessException(ErrorCode.ClassNotFoundException.des, ErrorCode.ClassNotFoundException.code);
        } else if (exception.getClass().equals(ArithmeticException.class)) {
            throw new BusinessException(ErrorCode.ArithmeticException.des, ErrorCode.ArithmeticException.code);
        } else if (exception.getClass().equals(ArrayIndexOutOfBoundsException.class)) {
            throw new BusinessException(ErrorCode.ArrayIndexOutOfBoundsException.des, ErrorCode.ArrayIndexOutOfBoundsException.code);
        } else if (exception.getClass().equals(IllegalArgumentException.class)) {
            throw new BusinessException(ErrorCode.IllegalArgumentException.des, ErrorCode.IllegalArgumentException.code);
        } else if (exception.getClass().equals(ClassCastException.class)) {
            throw new BusinessException( ErrorCode.ClassCastException.des, ErrorCode.ClassCastException.code);
        } else if (exception.getClass().equals(SecurityException.class)) {
            throw new BusinessException(ErrorCode.SecurityException.des, ErrorCode.SecurityException.code);
        } else if (exception.getClass().equals(SQLException.class)) {
            throw new BusinessException(ErrorCode.SQLException.des, ErrorCode.SQLException.code);
        } else if (exception.getClass().equals(NoSuchMethodError.class)) {
            throw new BusinessException(ErrorCode.NoSuchMethodError.des, ErrorCode.NoSuchMethodError.code);
        } else if (exception.getClass().equals(InternalError.class)) {
            throw new BusinessException( ErrorCode.InternalError.des, ErrorCode.InternalError.code);
        } else if(exception.getClass().equals(ConnectException.class)){
            throw new BusinessException( ErrorCode.ConnectException.des, ErrorCode.ConnectException.code);
        } else if(exception.getClass().equals(CancellationException.class)){
            throw new BusinessException( ErrorCode.CancellationException.des, ErrorCode.CancellationException.code);
        } else if (exception.getClass().equals(ParseException.class)) {
            throw new BusinessException( ErrorCode.ParseException.des, ErrorCode.ParseException.code);
        } else {
            throw new BusinessException(ErrorCode.INTERNAL_PROGRAM_ERROR.des + exception.getMessage(), ErrorCode.INTERNAL_PROGRAM_ERROR.code);
        }

    }

    /**
     * 将异常信息输出到 log 文件
     * @param throwable
     * @return
     */
    private String getTrace(Throwable throwable){
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace();
        StringBuffer stringBuffer = stringWriter.getBuffer();
        return stringBuffer.toString();
    }

    /**
     * 获取方法名和参数
     * @param joinPoint
     * @return
     */
    private String getMethodNameAndArgs(JoinPoint joinPoint){
        Object objects[] = joinPoint.getArgs();
        StringBuffer stringBuffer = new StringBuffer("method:");
        stringBuffer.append(joinPoint.getTarget().getClass().getName()+"."
                            + joinPoint.getSignature().getName()+"(");
        for(int i=0; i<objects.length; i++){
            stringBuffer.append("arg[" + i + "]:" + objects[i] + ",");
        }
        if(objects.length > 0){
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    /**
     * 获取方法描述
     * @param joinPoint
     * @return
     * @throws Exception
     */
    private String getMethodDescription(JoinPoint joinPoint) throws Exception{
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method methods[] = targetClass.getMethods();
        String description = "";
        for (Method method : methods){
            String name = method.getName();
            if(method.getName().equals(methodName)
                    && method.isAnnotationPresent(AdviceLog.class)){
                AdviceLog adviceLog = method.getAnnotation(AdviceLog.class);
                description = adviceLog.description();
                break;
            }
        }
        return description;
    }
}
