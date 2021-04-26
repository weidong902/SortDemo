package com.weidd.best.frame.springTest.circular3.circular2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-04-24 18:24
 * Spring 循环注入问题
 **/
public class SpringCyclicTest {
    public static void main(String[] args) {
        /*Requested bean is currently in creation: Is there an unresolvable circular reference?*/
        ApplicationContext context = new ClassPathXmlApplicationContext("spring2.xml");
        AA a = (AA) context.getBean("a");
    }
}
