package com.github.lrssmeiksts.qwiz.model;

import com.github.lrssmeiksts.qwiz.swagger.DescriptionVariables;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {

    @Schema(hidden = true, description = "Unique quiz id", example = "1")
    @NotNull
    @Min(value = 1, message = DescriptionVariables.MODEL_ID_MIN)
    @Max(value = Long.MAX_VALUE, message = DescriptionVariables.MODEL_ID_MAX)
    private Long id;

    @Schema(description = "User id", example = "1")
    @NotNull
    @Min(value = 1, message = DescriptionVariables.MODEL_ID_MIN)
    @Max(value = Long.MAX_VALUE, message = DescriptionVariables.MODEL_ID_MAX)
    private Long userId;

    @Schema(description = "Category id", example = "1")
    @NotNull
    @Min(value = 1, message = DescriptionVariables.MODEL_ID_MIN)
    @Max(value = Long.MAX_VALUE, message = DescriptionVariables.MODEL_ID_MAX)
    private Long categoryId;


    @Schema(description = "Title of the quiz",example = "What's something you can break just by saying its name?")
    @NotEmpty
    @Size(min = 1, max = 500, message = "Title must be between 1 and 500 characters")
    private String title;

    @Schema(description = "Answer for the quiz",example = "Silence")
    @NotEmpty
    @Size(min = 1, max = 200, message = "Answer must be between 10 and 120 characters")
    private String answer;

    @Schema(description = "Point value of the Quiz", example = "1")
    @NotNull
    @Min(value = 1)
    @Max(value = 5)
    private int pointValue;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Date must not be null")
    @Schema(description = "Required existing date value. Date format 'yyyy-MM-dd'", example = "yyyy-MM-dd")
    private LocalDate createdAt;
}
