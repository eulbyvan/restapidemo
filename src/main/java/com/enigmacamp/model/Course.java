package com.enigmacamp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 29/11/22
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_course")
public class Course {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	@Column(name = "title", nullable = false, length = 150, unique = true)
	private String title;
	@Column(name = "description", nullable = false, length = 250)
	private String description;
	@Column(name = "link", nullable = false, length = 200)
	private String link;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_type_id", nullable = false)
	private CourseType courseType;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_info_id", nullable = false)
	private CourseInfo courseInfo;
}
