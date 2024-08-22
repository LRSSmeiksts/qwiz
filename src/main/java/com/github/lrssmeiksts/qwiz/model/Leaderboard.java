package com.github.lrssmeiksts.qwiz.model;

import com.github.lrssmeiksts.qwiz.swagger.DescriptionVariables;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Leaderboard {

    @Schema(hidden = true, description = "Unique leaderboard id", example = "1")
    @NotNull
    @Min(value = 1, message = DescriptionVariables.MODEL_ID_MIN)
    @Max(value = Long.MAX_VALUE, message = DescriptionVariables.MODEL_ID_MAX)
    private Long id;

    @Schema(description = "Total score of all quizzes", example = "1")
    @NotNull
    private int totalScore;

    @Schema(description = "Total guessed quizzes", example = "1")
    @NotNull
    private int quizzesGuessed;
}
