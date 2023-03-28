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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;
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


    @Test
    public void test4(){
        TestDataBean testDataBean0 = new TestDataBean("00000",19, "jhskdhfkahsdf");
        int rslt = testDataDao.addTestData(testDataBean0);
        test5();
    }

    @Transactional
    public void test5(){
        TestDataBean testDataBean1 = new TestDataBean(null,19, "jhskdhfkahsdf");
        int rslt = testDataDao.addTestData(testDataBean1);
    }



    // 事务的手动回滚

    @Autowired
    private PlatformTransactionManager transactionManager;
    @Test
    public void test6(){
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            TestDataBean testDataBean = new TestDataBean("jskdlfioweur",-5, "jhskdhfkahsdf");
            testDataDao.addTestData(testDataBean); // 插入用户信息
            if (testDataBean.getAge() < 0) {
                transactionManager.rollback(status); // 手动回滚事务
            }
            transactionManager.commit(status); // 提交事务
        } catch (Exception e) {
            transactionManager.rollback(status); // 手动回滚事务
        }
    }

    @Autowired
    @Qualifier("myStringRedisTemplate")
    private RedisTemplate<Object, Object> redisTemplate;
    @Test
    public void test7(){
//        redisTemplate.opsForValue().set("name", "knight");
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    @Test
    public void test8(){
        List<Object> result = redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.openPipeline();
                Boolean set1 = redisConnection.set("key1".getBytes(), "value1".getBytes());
                Boolean set2 = redisConnection.set("key2".getBytes(), "value2".getBytes());
                Boolean set3 = redisConnection.set("key3".getBytes(), "value3".getBytes());
                System.out.println(set1+":"+set2+":"+set3);
                return null;
            }
        });
        System.out.println(result);
    }

}
