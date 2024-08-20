package com.github.lrssmeiksts.qwiz.business.repository;

import com.github.lrssmeiksts.qwiz.business.repository.model.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDAO, Long> {
}
