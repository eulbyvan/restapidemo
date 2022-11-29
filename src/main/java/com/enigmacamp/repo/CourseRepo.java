package com.enigmacamp.repo;

import com.enigmacamp.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 29/11/22
 */

@Repository
public class CourseRepo implements ICourseRepo {
	private List<Course> courses = new ArrayList<>();

	@Override
	public List<Course> getAll() {
		return courses;
	}

	@Override
	public Course createCourse(Course course) {
		courses.add(course);
		return course;
	}

	@Override
	public Optional<Course> findById(String id) {
		for (Course course : courses) {
			if (course.getId().equals(id)) {
				return Optional.of(course);
			}
		}

		return Optional.empty();
	}

	@Override
	public void update(Course course, String id) {
		for (Course existingCourse : courses) {
			if (existingCourse.getId().equals(id)) {
				existingCourse.setTitle(course.getTitle());
				existingCourse.setDescription(course.getDescription());
				existingCourse.setLink(course.getLink());
				break;
			}
		}
	}

	@Override
	public void delete(String id) {
		for (Course course : courses) {
			if (course.getId().equals(id)) {
				courses.remove(course);
				break;
			}
		}
	}
}
