package com.king.code.service.invoke;

import java.io.Serializable;
import java.util.Date;
//水果
public class Fruit implements Serializable{
	private static final long serialVersionUID = 1883838732853579826L;
	
	Integer id;//编号
	String name;//名称
	Double weight;//重量
	String color;//颜色
	Date pickDay;//采摘日期
	
	public Fruit() {
		super();
	}
	
	public Fruit(Integer id, String name, Double weight, String color, Date pickDay) {
		super();
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.color = color;
		this.pickDay = pickDay;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getPickDay() {
		return pickDay;
	}

	public void setPickDay(Date pickDay) {
		this.pickDay = pickDay;
	}

	@Override
	public String toString() {
		return "Fruit [id=" + id + ", name=" + name + ", weight=" + weight + ", color=" + color + ", pickDay=" + pickDay + "]";
	}
	
	
}
