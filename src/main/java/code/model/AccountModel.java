package code.model;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年2月19日
 * @function : 
 */
public class AccountModel extends BaseModel{
    
    /**
     * 
     */
    private static final long serialVersionUID = 3147660834708008147L;

    private int loginid;
    
    private String name;
    
    private String pwd;
    
    @Value("#{database['data.mail']}")
    private String mail;
    
    @Value("#{database['data.mobile']}")
    private String mobile;
    
    @Value("#{database['data.superpwd']}")
    private String superpwd;
    
    @Value("#{database['data.IdCardNo']}")
    private String IdCardNo;
    
    @Value("#{database['data.RealName']}")
    private String RealName;
    
    @Value("#{database['data.btIsActivate']}")
    private int btIsActivate;
    
    @Value("#{database['data.szAcode']}")
    private String szAcode;
    
    @Value("#{database['data.btGmLvl']}")
    private int btGmLvl;
    
    @Value("#{database['data.btSex']}")
    private int btSex;
    
    @Value("#{database['data.btIsAdult']}")
    private int btIsAdult;
    
    @Value("#{database['data.dwActivateTime']}")
    private int dwActivateTime;
    
    @Value("#{database['data.btPrizeType']}")
    private int btPrizeType;
    
    @Value("#{database['data.guildid']}")
    private int guildid;
    
    @Value("#{database['data.yuanbao']}")
    private int yuanbao;
    
    @Value("#{database['data.emailVerifyKey']}")
    private int emailVerifyKey;
    
    @Value("#{database['data.emailverify']}")
    private int emailverify;
    
    @Value("#{database['data.usercode']}")
    private String usercode;
    
    @Value("#{database['data.cellphone']}")
    private String cellphone;

    
    public int getLoginid(){
        return loginid;
    }

    
    public String getName(){
        return name;
    }

    
    public String getPwd(){
        return pwd;
    }

    
    public String getMail(){
        return mail;
    }

    
    public String getMobile(){
        return mobile;
    }

    
    public String getSuperpwd(){
        return superpwd;
    }

    
    public String getIdCardNo(){
        return IdCardNo;
    }

    
    public String getRealName(){
        return RealName;
    }

    
    public int getBtIsActivate(){
        return btIsActivate;
    }

    
    public String getSzAcode(){
        return szAcode;
    }

    
    public int getBtGmLvl(){
        return btGmLvl;
    }

    
    public int getBtSex(){
        return btSex;
    }

    
    public int getBtIsAdult(){
        return btIsAdult;
    }

    
    public int getDwActivateTime(){
        return dwActivateTime;
    }

    
    public int getBtPrizeType(){
        return btPrizeType;
    }

    
    public int getGuildid(){
        return guildid;
    }

    
    public int getYuanbao(){
        return yuanbao;
    }

    
    public int getEmailVerifyKey(){
        return emailVerifyKey;
    }

    
    public int getEmailverify(){
        return emailverify;
    }

    
    public String getUsercode(){
        return usercode;
    }

    
    public String getCellphone(){
        return cellphone;
    }

    
    public void setLoginid(int loginid){
        this.loginid = loginid;
    }

    
    public void setName(String name){
        this.name = name;
    }

    
    public void setPwd(String pwd){
        this.pwd = pwd;
    }

    
    public void setMail(String mail){
        this.mail = mail;
    }

    
    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    
    public void setSuperpwd(String superpwd){
        this.superpwd = superpwd;
    }

    
    public void setIdCardNo(String idCardNo){
        IdCardNo = idCardNo;
    }

    
    public void setRealName(String realName){
        RealName = realName;
    }

    
    public void setBtIsActivate(int btIsActivate){
        this.btIsActivate = btIsActivate;
    }

    
    public void setSzAcode(String szAcode){
        this.szAcode = szAcode;
    }

    
    public void setBtGmLvl(int btGmLvl){
        this.btGmLvl = btGmLvl;
    }

    
    public void setBtSex(int btSex){
        this.btSex = btSex;
    }

    
    public void setBtIsAdult(int btIsAdult){
        this.btIsAdult = btIsAdult;
    }

    
    public void setDwActivateTime(int dwActivateTime){
        this.dwActivateTime = dwActivateTime;
    }

    
    public void setBtPrizeType(int btPrizeType){
        this.btPrizeType = btPrizeType;
    }

    
    public void setGuildid(int guildid){
        this.guildid = guildid;
    }

    
    public void setYuanbao(int yuanbao){
        this.yuanbao = yuanbao;
    }

    
    public void setEmailVerifyKey(int emailVerifyKey){
        this.emailVerifyKey = emailVerifyKey;
    }

    
    public void setEmailverify(int emailverify){
        this.emailverify = emailverify;
    }

    
    public void setUsercode(String usercode){
        this.usercode = usercode;
    }

    
    public void setCellphone(String cellphone){
        this.cellphone = cellphone;
    }
    
    
    
}
