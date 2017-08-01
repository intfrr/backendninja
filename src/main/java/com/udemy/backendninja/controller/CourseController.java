package com.udemy.backendninja.controller;

import com.udemy.backendninja.converter.CourseConverter;
import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.model.CourseModel;
import com.udemy.backendninja.service.impl.CourseServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private static final String COURSES_VIEW = "courses";
    private static final Log LOG = LogFactory.getLog(CourseController.class);

    @Autowired
    @Qualifier("courseServiceImpl")
    private CourseServiceImpl courseService;

    @Autowired
    @Qualifier("courseConverter")
    private CourseConverter courseConverter;

    @RequestMapping("/listcourse")
    public ModelAndView listAllCourses(){
        LOG.info("Call: listAllCourses()");
        ModelAndView modelAndView = new ModelAndView(COURSES_VIEW);
        modelAndView.addObject("course", new Course());
        modelAndView.addObject("courses", courseService.listAllCourses());
        return modelAndView;
    }

    @PostMapping("/addcourse")
    public String addCourse(@ModelAttribute("course") CourseModel courseModel){
        LOG.info("Call: listAllCourses() " + " -- Param: " + courseModel.toString());
        courseService.addCourse(courseConverter.model2Entity(courseModel));
        return "redirect:/courses/listcourse";
    }

    @PutMapping("/updatecourse")
    public String updateCourse(@ModelAttribute("course") CourseModel courseModel){
        LOG.info("Updating the Model " + courseModel.toString());
        courseService.updateCourse(courseConverter.model2Entity(courseModel));
        return "redirect:/courses/listcourse";
    }

    @DeleteMapping("/deletecourse")
    public String deleteCourse(@ModelAttribute("course") CourseModel courseModel){
        courseService.removeCourse(courseConverter.model2Entity(courseModel).getId());
        return "redirect:/courses/listcourse";
    }

}
