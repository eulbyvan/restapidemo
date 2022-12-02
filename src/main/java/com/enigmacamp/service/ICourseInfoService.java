package com.enigmacamp.service;

import com.enigmacamp.model.CourseInfo;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 02/12/22
 */

public interface ICourseInfoService {
	CourseInfo addCourseInfo(CourseInfo courseInfo);

	void addCourseInfos(List<CourseInfo> courseInfos);

	List<CourseInfo> findCourseInfos() throws Exception;

	Optional<CourseInfo> findCourseInfoById(String id);


	List<CourseInfo> findByDuration(String duration);

	List<CourseInfo> findByLevel(String level);

	void editCourseInfo(CourseInfo courseInfo, String id);

	void removeCourseInfo(String id);

	Page<CourseInfo> list(int page, int size, String direction, String sortBy);
}
