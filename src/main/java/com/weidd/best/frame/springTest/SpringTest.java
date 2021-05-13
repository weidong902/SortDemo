package com.weidd.best.spring.springtest;

import org.springframework.beans.factory.annotation.Value;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-03-11 16:57
 **/
//@Component
public class SpringTest {

    private static String ip;

    @Value("${test.ip}")
    public void setIp(String ip) {
        this.ip = ip;
    }

//    public static void main(String[] args) {
//
////        ApplicationContext app = new ClassPathXmlApplicationContext("spring.xml");
////        PropertiesConfig propertiesConfig = (PropertiesConfig) app.getBean("propertiesConfig");
////        String ip = propertiesConfig.getIp();
//
//        System.out.println("=========" + ip);
//    }

//    @Test
//    public void test(){
//        ApplicationContext app = new ClassPathXmlApplicationContext("spring.xml");
//        app.getBean()
//        System.out.println("========="+ip);
//    }



}
