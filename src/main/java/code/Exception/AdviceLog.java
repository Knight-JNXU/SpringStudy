package code.Exception;

/**
 * Created by Knight_JXNU on 2016/9/27.
 */

import java.lang.annotation.*;

/**
 * 自定义注解 拦截方法名称描述
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AdviceLog {
    String description() default "";
}
