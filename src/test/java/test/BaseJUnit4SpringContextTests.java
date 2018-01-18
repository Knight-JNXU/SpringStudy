package test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月18日
 * @function :
 */
@ContextConfiguration(locations = { "classpath*:spring/spring-conf.xml", "classpath*:spring/spring-service-conf.xml" })
public class BaseJUnit4SpringContextTests extends AbstractJUnit4SpringContextTests{
    

}
