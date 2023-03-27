package org.example;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.*;

public class Java7AndJava8Dif {

    // Lambda表达式
    @Test
    public void test8_0(){
        List<String> names = Arrays.asList("Alice", "Charlie", "Bob");
        Collections.sort(names, (String a, String b) -> a.compareTo(b));
        System.out.println(names);
    }
    @Test
    public void test7_0(){
        List<String> names = Arrays.asList("Alice", "Charlie", "Bob");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
        System.out.println(names);
    }

    // 方法引用
    @Test
    public void test8_1(){
        List<String> names = Arrays.asList("Alice", "Charlie", "Bob");
        Collections.sort(names, String::compareTo);
        System.out.println(names);
    }
    @Test
    public void test7_1(){
        List<String> names = Arrays.asList("Alice", "Charlie", "Bob");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
        System.out.println(names);
    }

    // 方法引用
    @Test
    public void test8_2(){
        MyClass myClass = new MyClass();
        myClass.myMethod();
        System.out.println(myClass.getName());
    }
    interface MyInterface {
        default void myMethod() {
            System.out.println("Hello World");
        }
        default String getName(){
            return "lw";
        }
    }
    class MyClass implements MyInterface{
    }

    // 函数式接口
    @Test
    public void test8_3(){
        YourInterface obj = () -> System.out.println("your method");
        obj.yourMethod();
    }
    interface YourInterface {
        void yourMethod();
    }
    class YourClass implements YourInterface{
        @Override
        public void yourMethod() {
            System.out.println("yourMethod");
        }
    }
    // Java 7 中没有函数式接口，使用的是匿名内部类
    @Test
    public void test7_3(){
        YourInterface yourInterface = new YourInterface() {
            @Override
            public void yourMethod() {
                System.out.println("hi");
            }
        };
        yourInterface.yourMethod();
    }


    // Stream API
    @Test
    public void test8_4(){
        List<String> names = Arrays.asList("Alice", "Charlie", "Bob");
        names.stream().filter(name -> name.startsWith("A")).forEach(System.out::println);
    }
    @Test
    public void test7_4(){
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        for (String name : names) {
            if (name.startsWith("A")) {
                System.out.println(name);
            }
        }
    }

    // 时间日期 API
    @Test
    public void test8_5(){
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plusWeeks(1);
        System.out.println(today);
        System.out.println(nextWeek);
    }
    // Java 7 中不含这些 API
    @Test
    public void test7_5(){
        Date today = new Date();
        Date nextWeek = DateUtils.addWeeks(today, 1);
        System.out.println(nextWeek);
    }

    // CompletableFuture
    @Test
    public void test8_6(){
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            // do some long-running task
            return 42;
        });
        future.thenAccept(result -> System.out.println("Result: " + result));
    }
    @Test
    public void test7_6() throws ExecutionException, InterruptedException {
        Executor executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = ((ExecutorService) executor).submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                // do some long-running task
                return 42;
            }
        });
        System.out.println(future.get()); // blocking call to get the result
    }

    // Nashorn JavaScript引擎
    @Test
    public void test8_7() throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval("print('hello world!')");
    }
    // Java7没有JavaScript引擎
    @Test
    public void test7_7() {
    }

}
