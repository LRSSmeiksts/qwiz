package com.github.lrssmeiksts.qwiz.model;

import com.github.lrssmeiksts.qwiz.business.repository.model.LeaderboardDAO;
import com.github.lrssmeiksts.qwiz.swagger.DescriptionVariables;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Schema(hidden = true, description = "Unique user id", example = "1")
    @NotNull
    @Min(value = 1, message = DescriptionVariables.MODEL_ID_MIN)
    @Max(value = Long.MAX_VALUE, message = DescriptionVariables.MODEL_ID_MAX)
    private Long id;

    // leaderboard id
    @Schema(description = "User's leaderboard id")
    private LeaderboardDAO leaderboardId;

    // quizzes id's

    // quiz result id's

    @Schema( description = "Email of the user",example = "example@example.com")
    @NotNull
    @Size(min = 10, max = 200, message = "Email must be between 10 and 120 characters")
    private String email;

    @Schema(description = "Username of the user", example = "user123")
    @NotNull
    @Size(min = 1, max = 200, message = "Username must be between 1 and 120 characters")
    private String username;

    @Schema(description = "URl for the picture of the user", example = "C://pictures/picture.jpg")
    private String pictureUrl;

    @Schema(description = "Role of the user", example = "user")
    @NotNull
    @Size(min = 1, max = 5, message = "role must be between 1 and 5 characters")
    private String role;
}
