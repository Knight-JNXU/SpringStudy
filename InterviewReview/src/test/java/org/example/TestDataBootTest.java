package org.example;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.bean.TestDataBean;
import org.dao.TestDataDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("org.dao")
@ComponentScan(basePackages = {"org.controller"})
public class TestDataBootTest {

    //使用 mockbean 做测试时，并不会真正去持久化
//    @MockBean
    @Autowired
    private TestDataDao testDataDao;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void test0(){
        TestDataBean testDataBean = new TestDataBean("test0",0, "sjdfkljalksdjf");
        int i = testDataDao.addTestData(testDataBean);
        System.out.println(i);
    }

    @Test
    public void test1(){
        RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('0','z').filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS).build();
        for(int i=0; i<5; i++){
            String generate = generator.generate(10);
            String domain = "@example.com";
            String email = generate+domain;
            System.out.println(email);
            int age = ThreadLocalRandom.current().nextInt(80);
            String name = generator.generate(12);
            System.out.println(age);
            System.out.println(name);
            TestDataBean testDataBean = new TestDataBean(name,age, email);
            int rslt = testDataDao.addTestData(testDataBean);
            System.out.println(rslt);
        }
    }

    @Test
    public void test2(){
        RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('0','z').filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS).build();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        TestDataDao mapper = sqlSession.getMapper(TestDataDao.class);
        for(int i=0; i<=30000; i++){
            String generate = generator.generate(10);
            int age = ThreadLocalRandom.current().nextInt(80);
            String name = generator.generate(12);
            String domain = "@example.com";
            String email = generate+domain;
            TestDataBean testDataBean = new TestDataBean(name,age, email);
            mapper.addTestData(testDataBean);
            if(0 == i%100){
                sqlSession.commit();
            }
        }
        sqlSession.close();
    }

    @Test
    public void test3() throws InterruptedException {
        // 创建一个CachedThreadPool线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        final int threadNum = 30;
        final int loopTimes = 30000/threadNum;
        final CountDownLatch latch = new CountDownLatch(threadNum);
        RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('0','z').filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS).build();

        // 提交10个任务到线程池中
        for (int j = 0; j < threadNum; j++) {
            executor.submit(() -> {
                SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
                TestDataDao mapper = sqlSession.getMapper(TestDataDao.class);
                for(int i=0; i<loopTimes; i++){
                    String generate = generator.generate(10);
                    int age = ThreadLocalRandom.current().nextInt(80);
                    String name = generator.generate(12);
                    String domain = "@example.com";
                    String email = generate+domain;
                    TestDataBean testDataBean = new TestDataBean(name,age, email);
                    mapper.addTestData(testDataBean);
                    sqlSession.commit();
                }
                sqlSession.close();
                latch.countDown();
            });
        }

        latch.await(2, TimeUnit.HOURS);
        System.out.println("over!");
    }



}
