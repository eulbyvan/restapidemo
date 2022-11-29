package com.enigmacamp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 29/11/22
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	private String id;
	private String title;
	private String description;
	private String link;
}
