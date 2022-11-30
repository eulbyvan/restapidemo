package com.enigmacamp.controller;

import com.enigmacamp.model.Course;
import com.enigmacamp.model.request.CourseReq;
import com.enigmacamp.model.response.SuccessRes;
import com.enigmacamp.service.ICourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@Autowired
	private ModelMapper modelMapper;

	private SuccessRes<Object> res = new SuccessRes<>();

	@GetMapping
	public ResponseEntity findCourses() {
		List<Course> data = courseService.findCourses();

		res.setCode("00");
		res.setMsg("success get all courses");
		res.setStatus("ok");
		res.setData(data);

		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	@GetMapping("/{id}")
	public ResponseEntity findCourseById(@PathVariable("id") String id) {
		Optional<Course> data = courseService.findCourseById(id);

		res.setCode("00");
		res.setMsg("course found");
		res.setStatus("ok");
		res.setData(data);

		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	@PostMapping
	public ResponseEntity addCourse(@RequestBody CourseReq req) {
		Course course = modelMapper.map(req, Course.class);
		Course data = courseService.addCourse(course);

		res.setCode("00");
		res.setMsg("new course added");
		res.setStatus("ok");
		res.setData(data);

		return ResponseEntity.status(HttpStatus.CREATED).body(res);
	}

	@PutMapping("/{id}")
	public ResponseEntity editCourse(@RequestBody Course course, @PathVariable("id") String id) {
		courseService.editCourse(course, id);

		res.setCode("00");
		res.setMsg("course updated");
		res.setStatus("ok");

		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity removeCourse(@PathVariable("id") String id) {
		courseService.removeCourse(id);

		res.setCode("00");
		res.setMsg("course updated");
		res.setStatus("ok");

		return ResponseEntity.status(HttpStatus.OK).body(res);
	}
}
