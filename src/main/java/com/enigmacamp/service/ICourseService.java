package com.enigmacamp.service;

import com.enigmacamp.model.Course;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 29/11/22
 */

public interface ICourseService {
	Course addCourse(Course course);

	void addCourses(List<Course> courses);

	List<Course> findCourses() throws Exception;

	Optional<Course> findCourseById(String id);

	List<Course> findByTitleContains(String value);

	List<Course> findByDescriptionContains(String description);


	List<Course> findSomeCourses(Pageable pageable);

	void editCourse(Course course, String id);

	void removeCourse(String id);
}
