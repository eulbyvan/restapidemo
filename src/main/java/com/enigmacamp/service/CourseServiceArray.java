//package com.enigmacamp.service;
//
//import com.enigmacamp.exception.NotFoundException;
//import com.enigmacamp.model.Course;
//import com.enigmacamp.repo.ICourseRepoArray;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
///**
// * @author stu (https://www.eulbyvan.com/)
// * @version 1.0
// * @since 29/11/22
// */
//
//@Service
//public class CourseServiceArray implements ICourseServiceArray {
//	@Autowired
//	private ICourseRepoArray courseRepo;
//
//	@Override
//	public Course addCourse(Course course) {
//		try {
//			return courseRepo.createCourse(course);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	@Override
//	public List<Course> findCourses() throws Exception {
//		List<Course> data = courseRepo.getAll();
//
//		if (data.isEmpty()) throw new NotFoundException();
//
//		return data;
//	}
//
//	@Override
//	public Optional<Course> findCourseById(String id) {
//		try {
//			return courseRepo.findById(id);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	@Override
//	public List<Course> findByKeyword(String keyword, String value) {
//		Optional<List<Course>> coursesFoundByTitle = Optional.ofNullable(courseRepo.findByKeyword(keyword, value));
//		return coursesFoundByTitle.get();
//	}
//
//	@Override
//	public void editCourse(Course course, String id) {
//		try {
//			courseRepo.update(course, id);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	@Override
//	public void removeCourse(String id) {
//		try {
//			courseRepo.delete(id);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//}
