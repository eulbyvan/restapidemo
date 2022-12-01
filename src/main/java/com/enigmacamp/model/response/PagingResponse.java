package com.enigmacamp.model.response;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/12/22
 */

@Data
public class PagingResponse<T> extends CommonRes {
	private List<T> data;
	private long count;
	private int totalPages;
	private int page;
	private int size;

	public PagingResponse(String msg, Page<T> page) {
		super.setCode("00");
		super.setMsg(msg);
		super.setStatus(HttpStatus.OK.name());
		this.data = page.getContent();
		this.count = page.getTotalElements();
		this.totalPages = page.getTotalPages();
		this.page = page.getNumber() + 1;
		this.size = page.getSize();
	}
}
