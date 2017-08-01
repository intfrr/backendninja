package com.udemy.backendninja.converter;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.model.CourseModel;
import org.springframework.stereotype.Component;

@Component("courseConverter")
public class CourseConverter {
    public CourseModel entity2Model(Course course){
        CourseModel courseModel = new CourseModel();
        courseModel.setName(course.getName());
        courseModel.setDescription(course.getDescription());
        courseModel.setPrice(course.getPrice());
        courseModel.setHours(course.getHours());
        return courseModel;
    }

    public Course model2Entity(CourseModel courseModel){
        Course course = new Course();
        course.setName(courseModel.getName());
        course.setDescription(courseModel.getDescription());
        course.setPrice(courseModel.getPrice());
        course.setHours(courseModel.getHours());
        return course;
    }
}
