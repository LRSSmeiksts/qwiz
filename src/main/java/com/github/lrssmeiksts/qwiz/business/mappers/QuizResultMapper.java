package com.github.lrssmeiksts.qwiz.business.mappers;

import com.github.lrssmeiksts.qwiz.business.repository.model.QuizDAO;
import com.github.lrssmeiksts.qwiz.business.repository.model.QuizResultDAO;
import com.github.lrssmeiksts.qwiz.business.repository.model.UserDAO;
import com.github.lrssmeiksts.qwiz.model.QuizResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses={
        QuizMapper.class,
        UserMapper.class
})
public interface QuizResultMapper {

    @Mappings({
            @Mapping(source = "quizId", target = "quizId", qualifiedByName = "quizIdToQuizDAOId"),
            @Mapping(source="userId", target = "userId", qualifiedByName = "ResultUserIdToUserDAOId")
    })
    QuizResultDAO quizResultToQuizResultDAO (QuizResult quizResult);

    @Mappings({
            @Mapping(source = "quizId", target = "quizId", qualifiedByName = "quizDAOIdToQuizId"),
            @Mapping(source="userId", target = "userId", qualifiedByName = "ResultUserDAOIdToUserId")
    })
    QuizResult quizResultDAOToQuizResult (QuizResultDAO quizResultDAO);

    @Named("quizIdToQuizDAOId")
    default QuizDAO quizIdToQuizDAOId(Long quizId){
        QuizDAO quizDAOId = new QuizDAO();
        quizDAOId.setId(quizId);
        return quizDAOId;
    }

    @Named("quizDAOIdToQuizId")
    default Long quizDAOIdToQuizId(QuizDAO quizDAOId){
        return quizDAOId.getId();
    }

    @Named("ResultUserDAOIdToUserId")
    default Long ResultUserDAOIdToUserId(UserDAO userDAO){
        return userDAO.getId();
    }

    @Named("ResultUserIdToUserDAOId")
    default UserDAO ResultUserIdToUserDAOId(Long userId){
        UserDAO userDAOId = new UserDAO();
        userDAOId.setId(userId);
        return userDAOId;
    }
}
