package com.github.lrssmeiksts.qwiz.business.service.impl;

import com.github.lrssmeiksts.qwiz.business.repository.QuizRepository;
import com.github.lrssmeiksts.qwiz.business.service.QuizService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public void deleteQuizById(Long id) {
        quizRepository.deleteById(id);
        log.info("Quiz with ID {} has been deleted",id);
    }
}
