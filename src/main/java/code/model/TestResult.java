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

package code.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author liuwen
 * @version 1.0
 * @date 2021/7/21
 */
public class TestResult implements Serializable {

    private static final long serialVersionUID = 6323104454650947620L;

    private String acct;

    private String state;

    private List<TestDetail> details;

    public TestResult(String acct, String state, List<TestDetail> details) {
        this.acct = acct;
        this.state = state;
        this.details = details;
    }

    public String getAcct() {
        return acct;
    }

    public void setAcct(String acct) {
        this.acct = acct;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<TestDetail> getDetails() {
        return details;
    }

    public void setDetails(List<TestDetail> details) {
        this.details = details;
    }
}
