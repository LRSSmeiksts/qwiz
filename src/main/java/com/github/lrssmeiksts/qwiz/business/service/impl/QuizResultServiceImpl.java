package com.github.lrssmeiksts.qwiz.business.service.impl;

import com.github.lrssmeiksts.qwiz.business.repository.QuizResultRepository;
import com.github.lrssmeiksts.qwiz.business.service.QuizResultService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class QuizResultServiceImpl implements QuizResultService {

    private final QuizResultRepository quizResultRepository;

    @Autowired
    public QuizResultServiceImpl(QuizResultRepository quizResultRepository) {
        this.quizResultRepository = quizResultRepository;
    }

    @Override
    public void deleteQuizResultById(Long id) {
        quizResultRepository.deleteById(id);
        log.info("QuizResult with ID {} has been deleted",id);

    }
}
