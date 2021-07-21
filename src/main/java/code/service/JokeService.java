package code.service;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月11日
 * @function : 
 */
public interface JokeService extends BaseService{
    
    /**
     * 根据页码获取笑话
     * @author knightjxnu
     * @param page
     * @return
     */
    public String getJokesByPage(String page);

}
