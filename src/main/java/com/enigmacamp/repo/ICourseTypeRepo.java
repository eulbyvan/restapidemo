package com.enigmacamp.repo;

import com.enigmacamp.model.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 02/12/22
 */

public interface ICourseTypeRepo extends JpaRepository<CourseType, String> {
	List<CourseType> findByName(String name);

	@Query(value = "SELECT * FROM tbl_course_type ct ORDER BY ct.name LIMIT ?2 OFFSET ((?1 - 1) * ?2)", nativeQuery = true)
	List<CourseType> findSome(int page, int pageSize);
}
