package lts.exam1.controllers;

import lts.exam1.models.CourseType;
import lts.exam1.services.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/coursetypes")
public class CourseTypeController {
    @Autowired
    private CourseTypeService courseTypeService;
    @RequestMapping(value = "all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CourseType> allCourseType(){
        return courseTypeService.allCourseType();
    }
    @RequestMapping(value = "add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public CourseType addCourseType(@RequestParam String name){
        return courseTypeService.addCourseType(name);
    }
    @RequestMapping(value = "edit", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public CourseType editCourseType(@RequestParam Integer typeId, @RequestParam String name){
        return courseTypeService.editCourseType(typeId, name);
    }
    @RequestMapping(value = "remove", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CourseType removeCourseType(@RequestParam Integer typeId){
        return courseTypeService.removeCourseType(typeId);
    }
}
