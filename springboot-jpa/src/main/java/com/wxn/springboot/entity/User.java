package com.wxn.springboot.entity;
/*
 * Created by wxn
 * 2018/12/15 18:52
 */

import javax.persistence.*;

//配置映射关系_使用JPA注解
@Entity	//告诉jpa这是一个实体类 和数据表映射
@Table(name = "tb_user")
public class User {

	@Id//这是一个主键
	@GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
	private Integer id;
	@Column(name = "name" , length = 50)
	private String name;
	@Column //省略默认列名就是属性名
	private String email;
	private String location;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
