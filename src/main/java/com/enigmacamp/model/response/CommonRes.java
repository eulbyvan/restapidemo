package com.enigmacamp.model.response;

import lombok.Data;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 30/11/22
 */

@Data
public abstract class CommonRes {
	private String code;
	private String msg;
	private String status;
}
