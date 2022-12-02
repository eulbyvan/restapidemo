package com.enigmacamp.controller;

import com.enigmacamp.model.Course;
import com.enigmacamp.model.CourseInfo;
import com.enigmacamp.model.request.CourseInfoReq;
import com.enigmacamp.model.request.CourseReq;
import com.enigmacamp.model.response.ErrorRes;
import com.enigmacamp.model.response.PagingResponse;
import com.enigmacamp.model.response.SuccessRes;
import com.enigmacamp.service.ICourseInfoService;
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
 * @since 02/12/22
 */

@RestController
@RequestMapping("/courseInfos")
public class CourseInfoController {
	@Autowired
	ICourseInfoService courseInfoService;

	@Autowired
	private ModelMapper modelMapper;

	private SuccessRes<Object> res = new SuccessRes<>();

	@GetMapping("/")
	public ResponseEntity findCourseInfos(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer size, @RequestParam(defaultValue = "DESC") String direction, @RequestParam(defaultValue = "id") String sortBy) {
		try {
			Page<CourseInfo> courseInfos = courseInfoService.list(page, size, direction, sortBy);

			return ResponseEntity.status(HttpStatus.OK).body(new PagingResponse<>("success", courseInfos));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorRes("X01", e.getMessage()));
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity findCourseInfoById(@PathVariable("id") String id) {
		try {
			Optional<CourseInfo> data = courseInfoService.findCourseInfoById(id);

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
//	public ResponseEntity addCourseInfo(@RequestBody CourseInfoReq req) {
//		try {
//			CourseInfo courseInfo = modelMapper.map(req, CourseInfo.class);
//			CourseInfo data = courseInfoService.addCourseInfo(courseInfo);
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

	@PostMapping("/")
	public ResponseEntity saveCourseInfos(@RequestBody List<CourseInfoReq> req) {
		try {
			List<CourseInfo> courseInfos = req
					.stream()
					.map(e -> modelMapper.map(e, CourseInfo.class))
					.collect(Collectors.toList());

			courseInfoService.addCourseInfos(courseInfos);
			res.setCode("00");
			res.setMsg("success");
			res.setStatus("ok");
			res.setData(courseInfos);

			return ResponseEntity.status(HttpStatus.OK).body(res);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorRes("X01", e.getMessage()));
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity editCourseInfo(@RequestBody CourseInfo courseInfo, @PathVariable("id") String id) {
		try {
			courseInfoService.editCourseInfo(courseInfo, id);

			res.setCode("00");
			res.setMsg("success");
			res.setStatus("ok");

			return ResponseEntity.status(HttpStatus.OK).body(res);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorRes("X01", e.getMessage()));
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity removeCourseInfo(@PathVariable("id") String id) {
		try {
			courseInfoService.removeCourseInfo(id);

			res.setCode("00");
			res.setMsg("success");
			res.setStatus("ok");

			return ResponseEntity.status(HttpStatus.OK).body(res);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorRes("X01", e.getMessage()));
		}
	}

	@GetMapping(params = {"value"}, path = "/duration")
	public ResponseEntity findByDuration(@RequestParam String duration) {
		try {
			List<CourseInfo> data = courseInfoService.findByDuration(duration);

			res.setCode("00");
			res.setMsg("success");
			res.setStatus("ok");
			res.setData(data);

			return ResponseEntity.status(HttpStatus.OK).body(res);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorRes("X01", e.getMessage()));
		}
	}

	@GetMapping(params = {"value"}, path = "/level")
	public ResponseEntity findByLevel(@RequestParam String level) {
		try {
			List<CourseInfo> data = courseInfoService.findByDuration(level);

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