package org.example.the_system_of_student_information.model.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseForCourse {
    private int id;
    private String name;
    private String lastName;
    private Integer userNumber;
    private Boolean scholarship;
}
