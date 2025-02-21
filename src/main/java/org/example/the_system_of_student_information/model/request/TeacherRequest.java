package org.example.the_system_of_student_information.model.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class TeacherRequest {
    private String name;
    private String lastName;
    private Integer userNumber;
    private String password;
    private BigDecimal salary;


}
