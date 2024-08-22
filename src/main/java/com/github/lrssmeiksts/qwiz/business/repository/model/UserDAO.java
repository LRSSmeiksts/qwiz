package com.github.lrssmeiksts.qwiz.business.repository.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="user")
public class UserDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="leaderboard_id", referencedColumnName = "leaderboard_id", unique = true)
    private LeaderboardDAO leaderboardId;

    //quizzes

    //quiz_results

    @Column(name = "email", nullable = false)
    @NotEmpty
    private String email;

    @Column(name = "username", nullable = false)
    @NotEmpty
    private String username;

    @Column(name = "picture_url")
    private String pictureUrl;

    @NotEmpty
    @Column(name = "role", nullable = false)
    private String role;
}
