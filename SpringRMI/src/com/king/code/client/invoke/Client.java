package com.king.code.client.invoke;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.king.code.service.invoke.Fruit;
import com.king.code.service.invoke.IPerson;
/**
 * 客户端调用类
 * @author King
 *
 */
public class Client  {
	//读取配置文件
	static ApplicationContext context = new ClassPathXmlApplicationContext("remote-client-local.xml");
	
	public static void main(String[] args) {
		eatFruit1();
		eatFruit2();
	}
	
	public static void eatFruit1()  {
		IPerson service = (IPerson) context.getBean("person");
		String  response = service.eat("苹果");
		System.out.println(response);
	}
	
	public static void eatFruit2()  {
		IPerson service = (IPerson) context.getBean("person");
		Fruit fruit = new Fruit(1,"西瓜",2.2d,"green",new Date());
		String  response = service.eat(fruit);
		System.out.println(response);
	}
	
}
