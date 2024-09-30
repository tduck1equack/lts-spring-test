package lts.exam1.interfaces.services;

import lts.exam1.models.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseServiceInterface {
    public List<Course> getAllCourses(Pageable pageable);

    public Course addCourse(Course course);

    public Course editCourse(Course course);

    public Course removeCourse(Integer courseId);

    public List<Course> findByName(String name, Pageable pageable);

}
