package kz.bitlab.sprint_one.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Surname is mandatory")
    private String surname;
    @Min(value = 0, message = "Exam should be at least 0")
    @Max(value = 100, message = "Exam should be at max 100")
    private int exam;
    private String mark;
}
