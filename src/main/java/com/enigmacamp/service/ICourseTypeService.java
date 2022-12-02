package com.enigmacamp.service;

import com.enigmacamp.model.CourseType;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 02/12/22
 */

public interface ICourseTypeService {
	CourseType addCourseType(CourseType courseType);

	void addCourseTypes(List<CourseType> courseTypes);

	List<CourseType> findCourseTypes() throws Exception;

	Optional<CourseType> findCourseTypeById(String id);


	List<CourseType> findByName(String description);


	void editCourseType(CourseType courseType, String id);

	void removeCourseType(String id);

	Page<CourseType> list(int page, int size, String direction, String sortBy);
}
