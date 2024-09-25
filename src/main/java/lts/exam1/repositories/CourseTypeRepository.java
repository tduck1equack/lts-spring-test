package lts.exam1.repositories;

import lts.exam1.models.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseTypeRepository extends JpaRepository<CourseType, Integer> {
}
