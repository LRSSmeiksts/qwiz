package com.github.lrssmeiksts.qwiz.business.mappers;


import com.github.lrssmeiksts.qwiz.business.repository.model.CategoryDAO;
import com.github.lrssmeiksts.qwiz.business.repository.model.QuizDAO;
import com.github.lrssmeiksts.qwiz.model.Category;
import jdk.jfr.Name;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.internal.util.collections.CollectionHelper.isNotEmpty;

@Mapper(componentModel = "spring",uses={
        QuizMapper.class
})

public interface CategoryMapper {

    @Mapping(source ="quizIds", target = "quizIds",qualifiedByName = "quizIdToQuizDAOId")
    CategoryDAO categoryToCategoryDAO(Category category);

    @Mapping(source ="quizIds", target = "quizIds",qualifiedByName = "quizDAOIdToQuizId")
    Category categoryDAOToCategory(CategoryDAO categoryDAO);

    @Named("quizIdToQuizDAOId")
    default List<QuizDAO> quizDAOIdsToQuizIds(List<Long> quizIds){
        List<QuizDAO> quizDAOIdsList = new ArrayList<>();
        if(isNotEmpty(quizIds)){
            quizIds.forEach(
                    quizId ->
                            quizDAOIdsList.add(new QuizDAO(quizId))
            );
        }
        return quizDAOIdsList;
    }

    @Named("quizDAOIdToQuizId")
    default List<Long> quizIdsToQuizDAOIds(List<QuizDAO> quizDAOIds){
        List<Long> quizIdsList = new ArrayList<>();
        if(isNotEmpty(quizDAOIds)){
            quizDAOIds.forEach(
                    quizDAO ->
                            quizIdsList.add(quizDAO.getId())
            );
        }
        return quizIdsList;
    }

}
