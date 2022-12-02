package com.enigmacamp.repo;

import com.enigmacamp.model.CourseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 02/12/22
 */

public interface ICourseInfoRepo extends JpaRepository<CourseInfo, String> {
	@Query("SELECT ci FROM CourseInfo ci WHERE ci.duration LIKE %?1%")
	List<CourseInfo> findByDuration(String duration);

	@Query("SELECT ci FROM CourseInfo ci WHERE ci.level LIKE %?1%")
	List<CourseInfo> findByLevel(String level);

	@Query(value = "SELECT * FROM tbl_course_info ci ORDER BY ci.level LIMIT ?2 OFFSET ((?1 - 1) * ?2)", nativeQuery = true)
	List<CourseInfo> findSome(int page, int pageSize);
}
