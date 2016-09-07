package com.king.code.service.invoke;
/**
 * 人实现类
 * @author King
 *
 */
public class Person implements IPerson {
	@Override	
	public String eat(String fruitName){
		System.out.println("begin------");
		System.out.println("i'm eating "+ fruitName );
		System.out.println("end------");
		return "service ha eaten " + fruitName;
	}
	
	@Override	
	public String eat(Fruit fruit){
		System.out.println("begin------");
		System.out.println("i'm eating "+fruit);
		System.out.println("end------");
		return "service has eaten "+ fruit;
	}
}
