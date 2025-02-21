package org.example.the_system_of_student_information.model.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.the_system_of_student_information.entity.enums.Status;

@Data
@Builder
@AllArgsConstructor
public class StudentRequest {
    private Boolean scholarshipStatus;
    private String name;
    private String lastName;
    private Integer userNumber;
    private String password;


    private int courseId;

}
