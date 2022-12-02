package com.enigmacamp.controller;

import com.enigmacamp.model.Course;
import com.enigmacamp.model.request.CourseReq;
import com.enigmacamp.model.response.ErrorRes;
import com.enigmacamp.model.response.PagingResponse;
import com.enigmacamp.model.response.SuccessRes;
import com.enigmacamp.service.ICourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 29/11/22
 */

@RestController
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	ICourseService courseService;

	@Autowired
	private ModelMapper modelMapper;

	private SuccessRes<Object> res = new SuccessRes<>();

	@GetMapping("/")
	public ResponseEntity findCourses(
			@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "5") Integer size,
			@RequestParam(defaultValue = "DESC") String direction,
			@RequestParam(defaultValue = "id") String sortBy
	) {
		try {
			Page<Course> courses = courseService.list(page, size, direction, sortBy);

			return ResponseEntity.status(HttpStatus.OK).body(new PagingResponse<>("success", courses));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorRes("X01", e.getMessage()));
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity findCourseById(@PathVariable("id") String id) {
		try {
			Optional<Course> data = courseService.findCourseById(id);

			res.setCode("00");
			res.setMsg("success");
			res.setStatus("ok");
			res.setData(data);

			return ResponseEntity.status(HttpStatus.OK).body(res);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorRes("X01", e.getMessage()));
		}
	}

//	@PostMapping("/")
//	public ResponseEntity addCourse(@RequestBody CourseReq req) {
//		try {
//			Course course = modelMapper.map(req, Course.class);
//			Course data = courseService.addCourse(course);
//
//			res.setCode("00");
//			res.setMsg("success");
//			res.setStatus("ok");
//			res.setData(data);
//
//			return ResponseEntity.status(HttpStatus.CREATED).body(res);
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorRes("X01", e.getMessage()));
//		}
//	}

	@PutMapping("/{id}")
	public ResponseEntity editCourse(@RequestBody Course course, @PathVariable("id") String id) {
		try {
			courseService.editCourse(course, id);

			res.setCode("00");
			res.setMsg("success");
			res.setStatus("ok");

			return ResponseEntity.status(HttpStatus.OK).body(res);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorRes("X01", e.getMessage()));
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity removeCourse(@PathVariable("id") String id) {
		try {
			courseService.removeCourse(id);

			res.setCode("00");
			res.setMsg("success");
			res.setStatus("ok");

			return ResponseEntity.status(HttpStatus.OK).body(res);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorRes("X01", e.getMessage()));
		}
	}

	@GetMapping(params = {"value"}, path = "/title")
	public ResponseEntity findByTitleContains(@RequestParam String value) {
		try {
			List<Course> data = courseService.findByTitleContains(value);

			res.setCode("00");
			res.setMsg("success");
			res.setStatus("ok");
			res.setData(data);

			return ResponseEntity.status(HttpStatus.OK).body(res);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorRes("X01", e.getMessage()));
		}
	}

	@GetMapping(params = {"value"}, path = "/description")
	public ResponseEntity findByDescriptionContains(@RequestParam String value) {
		try {
			List<Course> data = courseService.findByDescriptionContains(value);

			res.setCode("00");
			res.setMsg("success");
			res.setStatus("ok");
			res.setData(data);

			return ResponseEntity.status(HttpStatus.OK).body(res);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorRes("X01", e.getMessage()));
		}
	}

	@PostMapping("/")
	public ResponseEntity saveCourses(@RequestBody List<CourseReq> req) {


		try {
			CourseReq courseReq = null;

			List<Course> courses = req.stream()
					.map(element -> modelMapper.map(courseReq, Course.class))
					.collect(Collectors.toList());

			courseService.addCourses(courses);
			res.setCode("00");
			res.setMsg("success");
			res.setStatus("ok");

			return ResponseEntity.status(HttpStatus.OK).body(res);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorRes("X01", e.getMessage()));
		}
	}
}
