package com.github.lrssmeiksts.qwiz.business.mappers;


import com.github.lrssmeiksts.qwiz.business.repository.model.UserDAO;
import com.github.lrssmeiksts.qwiz.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses ={
        LeaderboardMapper.class
})
public interface UserMapper {
    UserDAO userToUserDAO(User user);

    User userDAOToUSer(UserDAO userDAO);
}
