package lts.exam1.controllers;


import lts.exam1.models.Course;
import lts.exam1.services.CourseService;
import lts.exam1.utilities.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @RequestMapping(value = "all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> allCourses(@RequestParam Integer page, @RequestParam Integer pageSize){
        return courseService.getAllCourses(Utility.pageable(page, pageSize));
    }
    @RequestMapping(value = "add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Course addCourse(@RequestBody String courseJson){
        Course newCourse = Utility.gson().fromJson(courseJson, Course.class);
        return courseService.addCourse(newCourse);
    }
    @RequestMapping(value = "edit", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Course editCourse(@RequestBody String courseJson){
        Course newCourse = Utility.gson().fromJson(courseJson, Course.class);
        return courseService.editCourse(newCourse);
    }
    @RequestMapping(value = "remove", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Course removeCourse(@RequestParam Integer courseId){
        return courseService.removeCourse(courseId);
    }
    @RequestMapping(value = "findbyname", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> findByName(@RequestParam String name, @RequestParam Integer page, @RequestParam Integer pageSize){
        return courseService.findByName(name, Utility.pageable(page, pageSize));
    }
}
