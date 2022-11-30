package com.enigmacamp.repo;

import com.enigmacamp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 29/11/22
 */

public interface ICourseRepo {
	List<Course> getAll();

	Course createCourse(Course course);

	Optional<Course> findById(String id);

	List<Course> findByKeyword(String keyword, String value);

	void update(Course course, String id);

	void delete(String id);
}
