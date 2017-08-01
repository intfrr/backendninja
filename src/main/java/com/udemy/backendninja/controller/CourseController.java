package com.udemy.backendninja.controller;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.service.impl.CourseServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private static final String COURSES_VIEW = "courses";
    private static final Log LOG = LogFactory.getLog(CourseController.class);

    @Autowired
    @Qualifier("courseServiceImpl")
    CourseServiceImpl courseService;

    @RequestMapping("/listcourse")
    public ModelAndView listAllCourses(){
        LOG.info("Call: listAllCourses()");
        ModelAndView modelAndView = new ModelAndView(COURSES_VIEW);
        modelAndView.addObject("course", new Course());
        modelAndView.addObject("courses", courseService.listAllCourses());
        return modelAndView;
    }

    @PostMapping("/addcourse")
    public String addCourse(@ModelAttribute("course") Course course){
        LOG.info("Call: listAllCourses() " + " -- Param: " + course.toString());
        courseService.addCourse(course);
        return "redirect:/courses/listcourse";
    }

}
