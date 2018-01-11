package code.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import code.dto.BaseResult;

/**
 * @author knight
 *
 */
@Component
@Aspect
public class BindingResultAop {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* code.controller..*.*(..))")
    public void aopMethod(){}

    @Around("aopMethod()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        LOG.info(joinPoint.getSignature() + " method is invoking!");
        BindingResult bindingResult = null;
        for(Object arg:joinPoint.getArgs()){
            if(arg instanceof BindingResult){
                bindingResult = (BindingResult) arg;
            }
        }
        if(bindingResult != null){
            if(bindingResult.hasErrors()){
                String errorInfo="["+bindingResult.getFieldError().getField()+"]"+bindingResult.getFieldError().getDefaultMessage();
                return new BaseResult<Object>(false, errorInfo);
            }
        }
        return joinPoint.proceed();
    }
}
