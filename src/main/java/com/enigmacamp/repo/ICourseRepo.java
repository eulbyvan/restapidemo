package com.enigmacamp.repo;

import com.enigmacamp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/12/22
 */

public interface ICourseRepo extends JpaRepository<Course, String> {
	@Query("SELECT c FROM Course c WHERE c.title LIKE %?1%")
	List<Course> findByTitleContains(String title);

	@Query("SELECT c FROM Course c WHERE c.description LIKE %?1%")
	List<Course> findByDescriptionContains(String description);

	@Query(value = "SELECT * FROM tbl_course c ORDER BY c.title LIMIT ?2 OFFSET ((?1 - 1) * ?2)", nativeQuery = true)
	List<Course> findSome(int page, int pageSize);
}
