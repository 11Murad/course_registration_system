package org.example.the_system_of_student_information.mapper;
import org.example.the_system_of_student_information.entity.Student;
import org.example.the_system_of_student_information.model.response.CourseResponseForStudentAndTeacher;
import org.example.the_system_of_student_information.model.response.StudentResponse;
import java.util.List;

public interface StudentMapper {
    static StudentResponse mapStudentToResponse(Student student) {
       return StudentResponse.builder().id(student.getId())
                .scholarshipStatus(student.getScholarshipStatus()).name(student.getUser().getName())
                .lastName(student.getUser().getLastName()).userNumber(student.getUser().getUserNumber())
                       .courseResponseForStudentAndTeacher(student.getCourse() != null ?
                               CourseResponseForStudentAndTeacher.builder()
                               .id(student.getCourse().getId())
                               .name(student.getCourse().getName())
                               .build():null).build();
    }
    static List<StudentResponse> mapStudentsToResponses(List<Student> students) {
        return students.stream().map(StudentMapper::mapStudentToResponse).toList();
    }
}
