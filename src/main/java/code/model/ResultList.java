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
import java.util.HashMap;
import java.util.List;

/**
 * @author liuwen
 * @version 1.0
 * @date 2021/7/21
 */
public class ResultList implements Serializable {

    private static final long serialVersionUID = 6849758231201105100L;

    private List<TestResult> results;

    private HashMap<String, String> map;

    public ResultList(List<TestResult> results, HashMap<String, String> map) {
        this.results = results;
        this.map = map;
    }

    public List<TestResult> getResults() {
        return results;
    }

    public void setResults(List<TestResult> results) {
        this.results = results;
    }

    public HashMap<String, String> getMap() {
        return map;
    }

    public void setMap(HashMap<String, String> map) {
        this.map = map;
    }
}
