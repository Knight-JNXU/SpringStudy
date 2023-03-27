package org.example;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.junit.Test;

import java.lang.instrument.ClassDefinition;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarFile;

public class CalculateListMapSize {

    @Test
    public void test0(){
        System.setProperty("java.vm.name","Java HotSpot(TM) ");
        // 单位字节
        System.out.println(ObjectSizeCalculator.getObjectSize(102L));
    }

    @Test
    public void test1(){
        AccountInfo accountInfo0 = new AccountInfo("1990785022","欧阳国平","17621191855","341400","456789123","002","江西省赣州市章贡区于都路瑞安家园一区","1","1548379.25","124512","河南村镇银行");
        AccountInfo accountInfo1 = new AccountInfo("1995465022","李婷","17625871855","341400","456789123","002","中华人民共和国新疆维吾尔自治区伊犁哈萨克自治州塔城地区和布克赛尔蒙古自治县和什托洛盖镇西特木恩哈布其克村","1","1454218379.25","1735512","蒙古银行");
        List<AccountInfo> accountInfoList = new ArrayList<>();
        accountInfoList.add(accountInfo0);
        accountInfoList.add(accountInfo1);
        String key = "124876@82";
        Map<String, List> hashMap = new HashMap<>();
        hashMap.put(key, accountInfoList);
        System.setProperty("java.vm.name","Java HotSpot(TM) ");
        // 单位字节
        System.out.println(ObjectSizeCalculator.getObjectSize(hashMap));
    }

    class AccountInfo{
        String no;
        String name;
        String phone;
        String postalCode;
        String customerNo;
        String currency;
        String address;
        String type;
        String balance;
        String organNo;
        String organName;

        public AccountInfo(String no, String name, String phone, String postalCode, String customerNo, String currency, String address, String type, String balance, String organNo, String organName) {
            this.no = no;
            this.name = name;
            this.phone = phone;
            this.postalCode = postalCode;
            this.customerNo = customerNo;
            this.currency = currency;
            this.address = address;
            this.type = type;
            this.balance = balance;
            this.organNo = organNo;
            this.organName = organName;
        }
    }

}
