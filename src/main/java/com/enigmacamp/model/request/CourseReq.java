package com.enigmacamp.model.request;

import com.enigmacamp.model.CourseInfo;
import com.enigmacamp.model.CourseType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 30/11/22
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CourseReq {
	private String title;
	private String description;
	private String link;
	private CourseTypeReq courseType;
	private CourseInfoReq courseInfo;
}
