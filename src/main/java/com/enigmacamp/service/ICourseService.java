package com.enigmacamp.service;

import com.enigmacamp.model.Course;

import java.util.List;
import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 29/11/22
 */

public interface ICourseService {
	Course addCourse(Course course);

	List<Course> findCourses();

	Optional<Course> findCourseById(String id);

	List<Course> findByKeyword(String keyword, String value);

	void editCourse(Course course, String id);

	void removeCourse(String id);
}
