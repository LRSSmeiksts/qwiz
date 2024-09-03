package com.github.lrssmeiksts.qwiz.business.mappers;

import com.github.lrssmeiksts.qwiz.business.repository.model.CategoryDAO;
import com.github.lrssmeiksts.qwiz.business.repository.model.QuizDAO;
import com.github.lrssmeiksts.qwiz.business.repository.model.UserDAO;
import com.github.lrssmeiksts.qwiz.model.Quiz;
import jdk.jfr.Name;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.context.annotation.EnableMBeanExport;


@Mapper(componentModel = "spring",uses={
        UserMapper.class,
        CategoryMapper.class
})
public interface QuizMapper {

    @Mappings({
            @Mapping(source = "userId", target = "userId", qualifiedByName = "userIdToUserDAOId"),
            @Mapping(source = "categoryId", target = "categoryId",qualifiedByName = "categoryIdToCategoryDAOId")
    })
    QuizDAO quizToQuizDAO(Quiz quiz);

    @Mappings({
            @Mapping(source = "userId", target = "userId", qualifiedByName = "userDAOIdToUserId"),
            @Mapping(source = "categoryId", target = "categoryId",qualifiedByName = "categoryDAOIdToCategoryId")
    })
    Quiz quizDAOToQuiz(QuizDAO quizDAO);

    @Named("userDAOIdToUserId")
    default Long userIdToUserDAOId(UserDAO userDAO){
        return userDAO.getId();
    }

    @Named("userIdToUserDAOId")
    default UserDAO userIdToUserDAOId(Long userId){
        UserDAO userDAOId = new UserDAO();
        userDAOId.setId(userId);
        return userDAOId;
    }

    @Named("categoryDAOIdToCategoryId")
    default Long categoryDAOIdToCategoryId(CategoryDAO categoryDAO){
        return categoryDAO.getId();
    }

    @Named("categoryIdToCategoryDAOId")
    default CategoryDAO categoryIdToCategoryDAOId(Long categoryId){
        CategoryDAO categoryDAOId = new CategoryDAO();
        categoryDAOId.setId(categoryId);
        return  categoryDAOId;
    }

}
