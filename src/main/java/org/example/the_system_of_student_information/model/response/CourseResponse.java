package org.example.the_system_of_student_information.model.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CourseResponse {
    private Integer id;
    private String name;

    private List<StudentResponseForCourse> students;
    private List<TeacherResponseForCourse> teachers;
}
