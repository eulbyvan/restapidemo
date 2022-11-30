package com.enigmacamp.model.response;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 30/11/22
 */

public class ErrorRes extends CommonRes {
	public ErrorRes(String code, String msg) {
		super.setCode(code);
		super.setMsg(msg);
		super.setStatus("ERROR");
	}
}
