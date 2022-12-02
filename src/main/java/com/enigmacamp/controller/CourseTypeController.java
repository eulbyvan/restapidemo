package com.enigmacamp.controller;

import com.enigmacamp.model.CourseType;
import com.enigmacamp.model.request.CourseTypeReq;
import com.enigmacamp.model.response.ErrorRes;
import com.enigmacamp.model.response.PagingResponse;
import com.enigmacamp.model.response.SuccessRes;
import com.enigmacamp.service.ICourseTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 02/12/22
 */

@RestController
@RequestMapping("/courseTypes")
public class CourseTypeController {
	@Autowired
	ICourseTypeService courseTypeService;

	@Autowired
	private ModelMapper modelMapper;

	private SuccessRes<Object> res = new SuccessRes<>();

	@GetMapping("/")
	public ResponseEntity findCourseTypes(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer size, @RequestParam(defaultValue = "DESC") String direction, @RequestParam(defaultValue = "id") String sortBy) {
		try {
			Page<CourseType> courseTypes = courseTypeService.list(page, size, direction, sortBy);

			return ResponseEntity.status(HttpStatus.OK).body(new PagingResponse<>("success", courseTypes));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorRes("X01", e.getMessage()));
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity findCourseTypeById(@PathVariable("id") String id) {
		try {
			Optional<CourseType> data = courseTypeService.findCourseTypeById(id);

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
	public ResponseEntity addCourseType(@RequestBody CourseTypeReq req) {
		try {
			CourseType courseType = modelMapper.map(req, CourseType.class);
			CourseType data = courseTypeService.addCourseType(courseType);

			res.setCode("00");
			res.setMsg("success");
			res.setStatus("ok");
			res.setData(data);

			return ResponseEntity.status(HttpStatus.CREATED).body(res);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorRes("X01", e.getMessage()));
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity editCourseType(@RequestBody CourseType courseType, @PathVariable("id") String id) {
		try {
			courseTypeService.editCourseType(courseType, id);

			res.setCode("00");
			res.setMsg("success");
			res.setStatus("ok");

			return ResponseEntity.status(HttpStatus.OK).body(res);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorRes("X01", e.getMessage()));
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity removeCourseType(@PathVariable("id") String id) {
		try {
			courseTypeService.removeCourseType(id);

			res.setCode("00");
			res.setMsg("success");
			res.setStatus("ok");

			return ResponseEntity.status(HttpStatus.OK).body(res);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorRes("X01", e.getMessage()));
		}
	}

	@GetMapping(params = {"value"}, path = "/name")
	public ResponseEntity findByName(@RequestParam String name) {
		try {
			List<CourseType> data = courseTypeService.findByName(name);

			res.setCode("00");
			res.setMsg("success");
			res.setStatus("ok");
			res.setData(data);

			return ResponseEntity.status(HttpStatus.OK).body(res);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorRes("X01", e.getMessage()));
		}
	}
}