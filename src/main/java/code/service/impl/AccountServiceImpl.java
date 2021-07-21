package code.service.impl;

import java.util.List;

import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feilong.core.Validator;

import code.dao.AccountDao;
import code.dto.BaseResult;
import code.model.AccountModel;
import code.service.AccountService;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年2月20日
 * @function : 
 */
@Service
public class AccountServiceImpl extends BaseServiceImpl implements AccountService{
    
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
    
    @Autowired
    private AccountDao accountDao;
    
    @Autowired
    private AccountModel accountModel;
    
    /**
     * 插入账号
     * @author knightjxnu
     * @param userName
     * @param userPwd
     * @return
     */
    public BaseResult<String> saveAccount(String userName, String userPwd) {
        BaseResult<String> result = new BaseResult<>(true, "注册成功！");
        List<Integer> accountIdList = accountDao.selectAccountIdByName(userName);
        if(Validator.isNullOrEmpty(accountIdList)) {
            AccountModel account = SerializationUtils.clone(accountModel);
            userPwd = encryptPwd(userPwd);
            account.setName(userName);
            account.setPwd(userPwd);
            int insertResult = accountDao.insert(account);
            if(1 != insertResult) {
                result = new BaseResult<>(false, "注册失败！");
            }
        }else {
            result = new BaseResult<>(false, "注册失败！账号"+userName+"已存在!") ;
        }
        
        return result;
    }
    
    /**
     * 加密密码
     * 规则：每两位为一组，每组互换位置，并转化为大写
     * 例子：
     * 原：1F5F5B265100DAAD35B3A491E1C55351
     * 后：F1F5B5621500ADDA533B4A191E5C3515
     * @author knightjxnu
     * @param userPwd
     * @return
     */
    private String encryptPwd(String userPwd){
        char[] oldPwdCharArray = userPwd.toCharArray();
        char[] newPwdCharArray = new char[oldPwdCharArray.length];
        for(int i=0; i<oldPwdCharArray.length; i+=2) {
            newPwdCharArray[i+1] = oldPwdCharArray[i];
        }
        for(int i=1; i<oldPwdCharArray.length; i+=2) {
            newPwdCharArray[i-1] = oldPwdCharArray[i];
        }
        String newPwd = String.valueOf(newPwdCharArray).toUpperCase();
        return newPwd;
    }
    
}
