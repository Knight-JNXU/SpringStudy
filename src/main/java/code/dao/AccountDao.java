package code.dao;

import java.util.List;

import code.model.AccountModel;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年2月20日
 * @function : 
 */
public interface AccountDao extends BaseDao{
    
    int insert(AccountModel accountModel);
    
    List<Integer> selectAccountIdByName(String name);
    
}
