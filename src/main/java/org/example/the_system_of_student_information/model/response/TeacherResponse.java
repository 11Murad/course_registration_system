package org.example.the_system_of_student_information.model.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class TeacherResponse {
    private Integer id;
    private String name;
    private String lastName;
    private Integer userNumber;
    private BigDecimal salary;

    private Set<CourseResponseForStudentAndTeacher> courses;


}
