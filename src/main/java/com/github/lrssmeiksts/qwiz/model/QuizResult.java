package com.github.lrssmeiksts.qwiz.model;

import com.github.lrssmeiksts.qwiz.swagger.DescriptionVariables;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizResult {

    @Schema(hidden = true, description = "Unique quizResults id", example = "1")
    @NotNull
    @Min(value = 1, message = DescriptionVariables.MODEL_ID_MIN)
    @Max(value = Long.MAX_VALUE, message = DescriptionVariables.MODEL_ID_MAX)
    private Long id;

    @Schema(description = "if of the user", example = "1")
    @NotNull
    private Long userId;

    @Schema(description = "id of the quiz", example = "1")
    @NotNull
    private Long quizId;

    @Schema(description = "Score gotten on the quiz", example = "1")
    @NotNull
    @Min(value = 0)
    @Max(value = 5, message = "score must not be higher than 5")
    private int score;

    @Schema(description = "Quiz guess date")
    @NotNull
    private LocalDate guessDate;
}
