package com.enigmacamp.service;

import com.enigmacamp.exception.NotFoundException;
import com.enigmacamp.model.CourseInfo;
import com.enigmacamp.repo.ICourseInfoRepo;
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
public class CourseInfoService implements ICourseInfoService {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ICourseInfoRepo courseInfoRepo;

	@Override
	public CourseInfo addCourseInfo(CourseInfo courseInfo) {
		return courseInfoRepo.save(courseInfo);
	}

	@Override
	public void addCourseInfos(List<CourseInfo> courseInfos) {
		courseInfoRepo.saveAll(courseInfos);
	}

	@Override
	public List<CourseInfo> findCourseInfos() throws Exception {
		return courseInfoRepo.findAll();
	}

	@Override
	public Optional<CourseInfo> findCourseInfoById(String id) {
		return courseInfoRepo.findById(id);
	}

	@Override
	public List<CourseInfo> findByDuration(String duration) {
		List<CourseInfo> courseInfos = courseInfoRepo.findByDuration(duration);

		if (courseInfos.isEmpty())
			throw new NotFoundException("CourseInfo with " + duration + " duration is not found");

		return courseInfos;
	}

	@Override
	public List<CourseInfo> findByLevel(String level) {
		List<CourseInfo> courseInfos = courseInfoRepo.findByDuration(level);

		if (courseInfos.isEmpty())
			throw new NotFoundException("CourseInfo with " + level + " level is not found");

		return courseInfos;
	}

	@Override
	public void editCourseInfo(CourseInfo courseInfo, String id) {
		Optional<CourseInfo> existingCourseInfo = findCourseInfoById(id);
		existingCourseInfo.ifPresent(c -> {
			courseInfo.setId(c.getId());
			courseInfoRepo.save(courseInfo);
		});
	}

	@Override
	public void removeCourseInfo(String id) {
		courseInfoRepo.deleteById(id);
	}

	@Override
	public Page<CourseInfo> list(int page, int size, String direction, String sortBy) {
		Sort sort = Sort.by(Sort.Direction.valueOf(direction), sortBy);
		Pageable pageable = PageRequest.of((page - 1), size, sort);
		Page<CourseInfo> res = courseInfoRepo.findAll(pageable);
		return res;
	}
}

