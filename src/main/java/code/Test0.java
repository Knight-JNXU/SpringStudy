package code;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Knight_JXNU on 2017/1/5.
 */
@Component
public class Test0 {
    @Scheduled(cron = "${NOW}")
    public void test(){
        System.out.println("**********************************targetMethod start!*********************************");
        System.out.println("time:" + new Date());
    }
}
