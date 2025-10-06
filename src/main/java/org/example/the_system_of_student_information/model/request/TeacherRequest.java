package org.example.the_system_of_student_information.model.request;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class TeacherRequest {
    @NotNull(message = "Name should not be null")
    private String name;
    @NotNull(message = "Lastname should not be null")
    private String lastName;
    @Digits(integer = 8, fraction = 0, message = "UserNumber must be 8 digits")
    private Integer userNumber;
    @Size(min = 8,max = 30)
    private String password;
    @NotNull
    private BigDecimal salary;


}
