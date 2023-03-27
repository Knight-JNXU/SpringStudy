package org.dao;

import org.apache.ibatis.annotations.Mapper;
import org.bean.TestDataBean;

@Mapper
public interface TestDataDao {

    int addTestData(TestDataBean bean);

}
