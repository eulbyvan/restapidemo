package com.enigmacamp.service;

import com.enigmacamp.model.Course;
import com.enigmacamp.repo.CourseRepo;
import com.enigmacamp.repo.ICourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 29/11/22
 */

@Service
public class CourseService implements ICourseService{
	@Autowired
	private ICourseRepo courseRepo;

	@Override
	public Course addCourse(Course course) {
		try {
			return courseRepo.createCourse(course);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Course> findCourses() {
		try {
			return courseRepo.getAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Optional<Course> findCourseById(String id) {
		try {
			return courseRepo.findById(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void editCourse(Course course, String id) {
		try {
			courseRepo.update(course, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void removeCourse(String id) {
		try {
			courseRepo.delete(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
