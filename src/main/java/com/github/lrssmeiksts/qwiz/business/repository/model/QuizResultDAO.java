package com.github.lrssmeiksts.qwiz.business.repository.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "quiz_result")
public class QuizResultDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_result_id")
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "quiz_id",referencedColumnName = "quiz_id",unique = true)
    private QuizDAO quizId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserDAO userId;

    @Column(name = "score", nullable = false)
    private int score;

    @Column(name = "guess_date", nullable = false)
    private LocalDate guessDate;

    public QuizResultDAO(Long id){this.id = id;}
}
