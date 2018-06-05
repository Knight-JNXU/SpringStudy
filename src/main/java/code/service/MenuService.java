package code.service;

/**
 * @author liuwen
 * @version 1.0
 * @date 2018年6月5日
 */
public interface MenuService extends BaseService{

    /**
     * 使用RequestContextHolder获取请求参数
     * @return
     */
    public String getUrlParam();

}
