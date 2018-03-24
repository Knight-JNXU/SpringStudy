package test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.feilong.json.jsonlib.JsonUtil;

import code.service.JokeService;

/**
 * @author liuwen
 * @version 1.0
 * @date 2018年1月18日
 * @function : 
 */
public class JokeServiceTest extends BaseJUnit4SpringContextTests{
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(JokeServiceTest.class);
    
    
    @Autowired
    private JokeService jokeService;
    

    @Test
    public void getJokesByPageTest(){
        Object result = jokeService.getJokesByPage("1");
        if (LOGGER.isInfoEnabled()){
            LOGGER.info("getJokesByPageTest:{}",JsonUtil.format(result));
        }
    }

}
