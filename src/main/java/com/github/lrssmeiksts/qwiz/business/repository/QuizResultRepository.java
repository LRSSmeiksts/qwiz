package com.github.lrssmeiksts.qwiz.business.repository;

import com.github.lrssmeiksts.qwiz.business.repository.model.QuizResultDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizResultRepository extends JpaRepository<QuizResultDAO, Long> {
}
