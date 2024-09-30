package lts.exam1.services;

import lts.exam1.interfaces.services.CourseTypeServiceInterface;
import lts.exam1.models.CourseType;
import lts.exam1.repositories.CourseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseTypeService implements CourseTypeServiceInterface {
    @Autowired
    private CourseTypeRepository courseTypeRepository;

    @Override
    public List<CourseType> allCourseType() {
        return courseTypeRepository.findAll();
    }

    @Override
    public CourseType addCourseType(String name) {
        CourseType newCourseType = new CourseType();
        newCourseType.setName(name);
        courseTypeRepository.save(newCourseType);
        return newCourseType;
    }

    @Override
    public CourseType editCourseType(Integer typeId, String name) {
        Optional<CourseType> target = courseTypeRepository.findById(typeId);
        if (target.isEmpty()) return null;
        target.get().setName(name);
        courseTypeRepository.save(target.get());
        return target.get();
    }

    @Override
    public CourseType removeCourseType(Integer typeId) {
        Optional<CourseType> target = courseTypeRepository.findById(typeId);
        if (target.isEmpty()) return null;
        courseTypeRepository.delete(target.get());
        return target.get();
    }
}
