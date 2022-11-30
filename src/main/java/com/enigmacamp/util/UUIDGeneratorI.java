package com.enigmacamp.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 30/11/22
 */

@Component
public class UUIDGeneratorI implements IRandomStringGenerator {
	@Override
	public String random() {
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}
}
