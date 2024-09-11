package com.github.lrssmeiksts.qwiz.business.repository;

import com.github.lrssmeiksts.qwiz.business.repository.model.QuizDAO;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface QuizRepository extends JpaRepository<QuizDAO, Long> {
}
