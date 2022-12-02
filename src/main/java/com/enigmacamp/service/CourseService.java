package com.enigmacamp.service;

import com.enigmacamp.exception.NotFoundException;
import com.enigmacamp.model.Course;
import com.enigmacamp.repo.ICourseRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/12/22
 */

@Service
public class CourseService implements ICourseService {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ICourseRepo courseRepo;

	@Override
	public Course addCourse(Course course) {
		return courseRepo.save(course);
	}

	@Override
	public void addCourses(List<Course> courses) {
		courseRepo.saveAll(courses);
	}

	@Override
	public List<Course> findCourses() throws Exception {
		return courseRepo.findAll();
	}

	@Override
	public Optional<Course> findCourseById(String id) {
		return courseRepo.findById(id);
	}

	@Override
	public List<Course> findByTitleContains(String value) {
		List<Course> courses = courseRepo.findByTitleContains(value);

		if (courses.isEmpty()) throw new NotFoundException("Course with " + value + " title is not found");

		return courses;
	}

	@Override
	public List<Course> findByDescriptionContains(String value) {
		List<Course> courses = courseRepo.findByDescriptionContains(value);

		if (courses.isEmpty()) throw new NotFoundException("Course with " + value + " description is not found");

		return courses;
	}

	@Override
	public void editCourse(Course course, String id) {
		Optional<Course> existingCourse = findCourseById(id);
		existingCourse.ifPresent(c -> {
			course.setId(c.getId());
			courseRepo.save(course);
		});
	}

	@Override
	public void removeCourse(String id) {
		courseRepo.deleteById(id);
	}

	@Override
	public Page<Course> list(int page, int size, String direction, String sortBy) {
		Sort sort = Sort.by(Sort.Direction.valueOf(direction), sortBy);
		Pageable pageable = PageRequest.of((page - 1), size, sort);
		Page<Course> res = courseRepo.findAll(pageable);
		return res;
	}
}
