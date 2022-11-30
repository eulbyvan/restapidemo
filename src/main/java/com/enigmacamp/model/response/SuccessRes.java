package com.enigmacamp.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 30/11/22
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuccessRes<T> extends CommonRes {
	T data;

	public SuccessRes(String code, String msg, String status, T data) {
		super.setCode(code);
		super.setMsg(msg);
		super.setStatus(status);
		this.data = data;
	}
}
