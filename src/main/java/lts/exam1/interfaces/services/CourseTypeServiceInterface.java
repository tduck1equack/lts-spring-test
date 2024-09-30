package lts.exam1.interfaces.services;

import lts.exam1.models.CourseType;

import java.util.List;

public interface CourseTypeServiceInterface {
    public List<CourseType> allCourseType();
    public CourseType addCourseType(String name);
    public CourseType editCourseType(Integer typeId, String name);
    public CourseType removeCourseType(Integer typeId);
}
