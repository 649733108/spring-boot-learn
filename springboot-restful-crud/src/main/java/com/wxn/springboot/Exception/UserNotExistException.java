package com.wxn.springboot.Exception;
/*
 * Created by wxn
 * 2018/12/12 23:00
 */


public class UserNotExistException extends RuntimeException {

	public UserNotExistException(){
		super("用户不存在~");
	}
}
