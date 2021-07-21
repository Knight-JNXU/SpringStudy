/**
 * Copyright (c) 2010 Jumbomart All Rights Reserved.
 * <p>
 * This software is the confidential and proprietary information of Jumbomart.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jumbo.
 * <p>
 * JUMBOMART MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
 * SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, OR NON-INFRINGEMENT. JUMBOMART SHALL NOT BE LIABLE FOR ANY DAMAGES
 * SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 * THIS SOFTWARE OR ITS DERIVATIVES.
 */

package code.controller;

import code.model.ResultList;
import code.model.TestDetail;
import code.model.TestResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author liuwen
 * @version 1.0
 * @date 2021/7/21
 */
@Controller
public class TestController extends BaseController {

    @ResponseBody
    @RequestMapping("/testController/test")
    public ResultList test(){
        List<TestDetail> testDetailList0 = new ArrayList<>();
        TestDetail testDetail0 = new TestDetail("gz", "g");
        TestDetail testDetail1 = new TestDetail("江西", "江");
        testDetailList0.add(testDetail0);
        testDetailList0.add(testDetail1);
        TestResult testResult0 = new TestResult("1", "1", testDetailList0);

        List<TestDetail> testDetailList1 = new ArrayList<>();
        TestDetail testDetail2 = new TestDetail("gl", "l");
        TestDetail testDetail3 = new TestDetail("bj", "江");
        testDetailList1.add(testDetail2);
        testDetailList1.add(testDetail3);
        TestResult testResult1 = new TestResult("2", "2", testDetailList1);

        List<TestResult> testResultList = new ArrayList<>();
        testResultList.add(testResult0);
        testResultList.add(testResult1);
        HashMap<String, String> map = new HashMap<>();
        map.put("lw", "l");
        map.put("sw", "s");
        map.put("qy", "q");
        ResultList resultList = new ResultList(testResultList, map);

        return resultList;

    }

}
