package lts.exam1.repositories;

import lts.exam1.models.ArticleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleTypeRepository extends JpaRepository<ArticleType, Integer> {
}
