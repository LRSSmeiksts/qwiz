package com.github.lrssmeiksts.qwiz.business.repository;

import com.github.lrssmeiksts.qwiz.business.repository.model.CategoryDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryDAO, Long> {
}
