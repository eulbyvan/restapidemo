package com.enigmacamp.controller;

import com.enigmacamp.model.Course;
import com.enigmacamp.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 29/11/22
 */

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	ICourseService courseService;

	@GetMapping
	public List<Course> findCourses() {
		return courseService.findCourses();
	}

	@GetMapping
	public Optional<Course> findCourseById(String id) {
		return courseService.findCourseById(id);
	}

	@PostMapping
	public Course addCourse(Course course) {
		return courseService.addCourse(course);
	}

	@PutMapping
	public void editCourse(Course course, String id) {
		courseService.editCourse(course, id);
	}

	@DeleteMapping
	public void removeCourse(String id) {
		courseService.removeCourse(id);
	}
}