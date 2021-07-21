package code.service;

import code.dto.BaseResult;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年2月20日
 * @function : 
 */
public interface AccountService extends BaseService{
    
    /**
     * 插入账号
     * @author knightjxnu
     * @param userName
     * @param userPwd
     * @return
     */
    BaseResult<String> saveAccount(String userName, String userPwd);
    
}
