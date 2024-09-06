package com.github.lrssmeiksts.qwiz.business.mappers;


import com.github.lrssmeiksts.qwiz.business.repository.model.LeaderboardDAO;
import com.github.lrssmeiksts.qwiz.business.repository.model.QuizDAO;
import com.github.lrssmeiksts.qwiz.business.repository.model.QuizResultDAO;
import com.github.lrssmeiksts.qwiz.business.repository.model.UserDAO;
import com.github.lrssmeiksts.qwiz.model.User;
import jdk.jfr.Name;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.internal.util.collections.CollectionHelper.isNotEmpty;

@Mapper(componentModel = "spring", uses ={
        LeaderboardMapper.class,
        QuizMapper.class,
        QuizResultMapper.class
})
public interface UserMapper {

    @Mappings({
            @Mapping(source = "leaderboardId", target = "leaderboardId", qualifiedByName = "leaderboardIdToLeaderboardDAOId"),
            @Mapping(source = "quizIds", target = "quizIds", qualifiedByName = "quizIdsToQuizDAOIds"),
            @Mapping(source = "quizResultIds", target = "quizResultIds", qualifiedByName = "quizResultIdsToQuizResultDAOIds")
    })
    UserDAO userToUserDAO(User user);

    @Mappings({
            @Mapping(source = "leaderboardId", target = "leaderboardId", qualifiedByName = "leaderboardDAOIdToLeaderboardId"),
            @Mapping(source = "quizIds", target = "quizIds", qualifiedByName = "quizDAOIdsToQuizIds"),
            @Mapping(source = "quizResultIds", target = "quizResultIds", qualifiedByName = "quizResultDAOIdsToQuizResultIds")

    })
    User userDAOToUser(UserDAO userDAO);

    @Named("quizResultIdsToQuizResultDAOIds")
    default List<QuizResultDAO> quizResultIdsToQuizResultDAOIds(List<Long> quizResultIds){
        List<QuizResultDAO> quizResultDAOIdsList = new ArrayList<>();
        if(isNotEmpty(quizResultIds)){
            quizResultIds.forEach(
                    quizResultId ->
                            quizResultDAOIdsList.add(new QuizResultDAO(quizResultId))
            );
        }
        return quizResultDAOIdsList;
    }

    @Named("quizResultDAOIdsToQuizResultIds")
    default List<Long> quizResultDAOIdsToQuizResultIds(List<QuizResultDAO> quizResultDAOIdsList){
        List<Long>  quizResultIdsList = new ArrayList<>();
        if(isNotEmpty(quizResultDAOIdsList)){
            quizResultDAOIdsList.forEach(
                    quizResultDAO ->
                            quizResultIdsList.add(quizResultDAO.getId())
            );
        }
        return quizResultIdsList;
    }
    @Named("quizIdsToQuizDAOIds")
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

    @Named("quizDAOIdsToQuizIds")
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

    @Named("leaderboardIdToLeaderboardDAOId")
    default LeaderboardDAO leaderboardIdToLeaderboardDAOId(Long id){
        LeaderboardDAO leaderboardDAO = new LeaderboardDAO();
        leaderboardDAO.setId(id);
        return leaderboardDAO;
    }
    @Named("leaderboardDAOIdToLeaderboardId")
    default Long leaderboardDAOIdToLeaderboardId(LeaderboardDAO leaderboardDAO){
        return leaderboardDAO.getId();
    }
}