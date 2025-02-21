package org.example.the_system_of_student_information.model.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class StudentResponse {
    private Integer id;
    private String name;
    private String lastName;
    private Integer userNumber;
    private Boolean scholarshipStatus;
    private CourseResponseForStudentAndTeacher courseResponseForStudentAndTeacher;
}
