package org.example.the_system_of_student_information.model.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeacherResponseForCourse {
    private int id;
    private String name;
    private String lastName;
    private Integer userNumber;
    private BigDecimal salary;

}
