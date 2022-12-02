package com.enigmacamp.service;

import com.enigmacamp.exception.NotFoundException;
import com.enigmacamp.model.CourseType;
import com.enigmacamp.repo.ICourseTypeRepo;
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
 * @since 02/12/22
 */

@Service
public class CourseTypeService implements ICourseTypeService {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ICourseTypeRepo courseTypeRepo;

	@Override
	public CourseType addCourseType(CourseType courseType) {
		return courseTypeRepo.save(courseType);
	}

	@Override
	public void addCourseTypes(List<CourseType> courseTypes) {
		courseTypeRepo.saveAll(courseTypes);
	}

	@Override
	public List<CourseType> findCourseTypes() throws Exception {
		return courseTypeRepo.findAll();
	}

	@Override
	public Optional<CourseType> findCourseTypeById(String id) {
		return courseTypeRepo.findById(id);
	}

	@Override
	public List<CourseType> findByName(String name) {
		List<CourseType> courseTypes = courseTypeRepo.findByName(name);

		if (courseTypes.isEmpty())
			throw new NotFoundException("CourseType with " + name + " name is not found");

		return courseTypes;
	}

	@Override
	public void editCourseType(CourseType courseType, String id) {
		Optional<CourseType> existingCourseType = findCourseTypeById(id);
		existingCourseType.ifPresent(c -> {
			courseType.setId(c.getId());
			courseTypeRepo.save(courseType);
		});
	}

	@Override
	public void removeCourseType(String id) {
		courseTypeRepo.deleteById(id);
	}

	@Override
	public Page<CourseType> list(int page, int size, String direction, String sortBy) {
		Sort sort = Sort.by(Sort.Direction.valueOf(direction), sortBy);
		Pageable pageable = PageRequest.of((page - 1), size, sort);
		Page<CourseType> res = courseTypeRepo.findAll(pageable);
		return res;
	}
}

