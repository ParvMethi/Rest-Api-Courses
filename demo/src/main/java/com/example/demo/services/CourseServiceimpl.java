package com.example.demo.services;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseDao;
import com.example.demo.entities.Course;

@Service
public class CourseServiceimpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;

//	List<Course> list;
	
	
	public CourseServiceimpl() {
		
//		list = new ArrayList<>();
//		list.add(new Course(1450, "Java", "This is Java Course"));
//		list.add(new Course(1451, "C", "This is C Course"));
//		list.add(new Course(1452, "C++", "This is C++ Course"));

	}
	
	@Override
	public List<Course> getCourses() {
		
//		return list;
	
		return courseDao.findAll();
	}


	@Override
	public Course getCourse(long courseId) {
//		Course c = null;
//		for(Course x:list) {
//			if(x.getId() == courseId) {
//			c = x;
//				break;
//			}
//		}
		
	    //return courseDao.getById(courseId);
		return courseDao.findById(courseId).orElse(null);
	}

	@Override
	public Course addCourse(Course course) {
//		list.add(course);
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
//		list.forEach(e->{
//			if(e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
		courseDao.save(course);
		return course;
	}

	@Override
	public String deleteCourse(long courseId) {
		//list = this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
		
		//1. Course entity = courseDao.findById(courseId).orElse(null);
		//   courseDao.delete(entity);
		//2.
		courseDao.deleteById(courseId);
		return "Course removed!!!";
		
	}
	
	

}
