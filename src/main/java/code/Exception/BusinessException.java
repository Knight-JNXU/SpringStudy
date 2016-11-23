package code.Exception;

import org.apache.log4j.Logger;

/**
 * Created by Knight_JXNU on 2016/9/27.
 */
public class BusinessException extends RuntimeException{
    private static final long serialVersionUID = 3152616724785436891L;
    private static final Logger log = Logger.getLogger(BusinessException.class);

    public static String json;

    public BusinessException(String errorMsg, Number errorCode){
        super();
    }

    private static String createFriendlyErrMsg(String msgBody, Number errorCode){
        json = msgBody.substring(msgBody.indexOf("{"), msgBody.indexOf("}")+1);
        log.info(json);
        return json;
    }
}
