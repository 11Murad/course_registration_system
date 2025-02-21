package org.example.the_system_of_student_information.model.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CourseRequest {
    private String name;
}
