package code;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Knight_JXNU on 2017/1/5.
 */
@Component
public class Test2 {
//    @Value("#{mysettings['s4']}")
    @Value("#{mysettings.s4}")
    private String s4;

    public String getS4() {
        return s4;
    }

    public void setS4(String s4) {
        this.s4 = s4;
    }
}
