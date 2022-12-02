package com.enigmacamp.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 02/12/22
 */

@Data
@Entity
@Table(name = "tbl_course_info")
public class CourseInfo {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	private String duration;
	private String level;
}
