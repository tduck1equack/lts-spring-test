package lts.exam1.repositories;

import lts.exam1.models.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseTypeRepository extends JpaRepository<CourseType, Integer> {
}
