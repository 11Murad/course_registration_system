package org.example.the_system_of_student_information.mapper;
import org.example.the_system_of_student_information.entity.Teacher;
import org.example.the_system_of_student_information.model.response.CourseResponseForStudentAndTeacher;
import org.example.the_system_of_student_information.model.response.TeacherResponse;

import java.util.List;
import java.util.stream.Collectors;


public interface TeacherMapper {
    static TeacherResponse mapTeacherToResponse(Teacher teacher){
        return TeacherResponse.builder().id(teacher.getId()).userNumber(teacher.getUser().getUserNumber())
                .name(teacher.getUser().getName()).lastName(teacher.getUser().getLastName())
                .salary(teacher.getSalary())
                .courses(teacher.getCourses().isEmpty()? null : teacher.getCourses().stream().map(c -> {
                    return CourseResponseForStudentAndTeacher.builder()
                            .id(c.getId())
                            .name(c.getName()).build();
                        }).collect(Collectors.toSet()))
                .build();
    }

    static List<TeacherResponse> mapTeachersToResponses(List<Teacher> teachers){
        return teachers.stream().map(TeacherMapper::mapTeacherToResponse).collect(Collectors.toList());
    }
    
}
