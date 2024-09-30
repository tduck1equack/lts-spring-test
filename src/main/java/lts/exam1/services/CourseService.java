package lts.exam1.services;

import lts.exam1.interfaces.services.CourseServiceInterface;
import lts.exam1.models.Course;
import lts.exam1.models.CourseType;
import lts.exam1.repositories.CourseRepository;
import lts.exam1.repositories.CourseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// todo: automatically updates student count based on status
// todo: requires fields
@Service
public class CourseService implements CourseServiceInterface {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseTypeRepository courseTypeRepository;

    @Override
    public List<Course> getAllCourses(Pageable pageable) {
        return courseRepository.findAll(pageable).getContent();
    }

    @Override
    public Course addCourse(Course course) {
        courseRepository.save(course);
        return course;
    }

    @Override
    public Course editCourse(Course course) {
        Optional<Course> target = courseRepository.findById(course.getCourseId());
        if (target.isEmpty()) return null;
        Course targetCourse = target.get();
        targetCourse.setCourseTypeId(course.getCourseTypeId());
        targetCourse.setCourseType(course.getCourseType());
        targetCourse.setFee(course.getFee());
        targetCourse.setIntroduction(course.getIntroduction());
        targetCourse.setDescription(course.getDescription());
        targetCourse.setLearningTime(course.getLearningTime());
        targetCourse.setName(course.getName());
        targetCourse.setPhoto(course.getPhoto());
        targetCourse.setRegistrations(course.getRegistrations());
        targetCourse.setStudentCount(course.getStudentCount());
        targetCourse.setSubjectCount(course.getSubjectCount());
        courseRepository.save(targetCourse);
        return targetCourse;
    }

    @Override
    public Course removeCourse(Integer courseId) {
        Optional<Course> target = courseRepository.findById(courseId);
        if (target.isEmpty()) return null;
        courseRepository.delete(target.get());
        return target.get();
    }

    @Override
    public List<Course> findByName(String name, Pageable pageable) {
        List<Course> result = new ArrayList<>();
        for (Course course : courseRepository.findAll()){
            if (course.getName().equalsIgnoreCase(name)) result.add(course);
        }
        Page<Course> pageResult = new PageImpl<>(result, pageable, result.size());
        return pageResult.getContent();
    }
}
