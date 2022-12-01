package com.enigmacamp.repo;

import com.enigmacamp.model.Course;
import com.enigmacamp.util.IRandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 29/11/22
 */

@Repository
public class CourseRepoArray implements ICourseRepoArray {

	@Autowired
	IRandomStringGenerator randomStringGenerator;
	private List<Course> courses = new ArrayList<>();

	@Override
	public List<Course> getAll() {
		return courses;
	}

	@Override
	public Course createCourse(Course course) {
		course.setId(randomStringGenerator.random());
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
	public List<Course> findByKeyword(String keyword, String value) {

		if (keyword.equalsIgnoreCase("title")) {
			return courses.stream().filter(c -> c.getTitle().equals(value)).collect(Collectors.toList());
		} else if (keyword.equalsIgnoreCase("description")) {
			return courses.stream().filter(c -> c.getDescription().equals(value)).collect(Collectors.toList());
		} else if (keyword.equalsIgnoreCase("link")) {
			return courses.stream().filter(c -> c.getLink().equals(value)).collect(Collectors.toList());
		}

		return null;
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
