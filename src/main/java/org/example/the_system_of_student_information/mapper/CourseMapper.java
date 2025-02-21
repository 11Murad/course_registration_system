package org.example.the_system_of_student_information.mapper;
import org.example.the_system_of_student_information.entity.Course;
import org.example.the_system_of_student_information.model.response.CourseResponse;
import org.example.the_system_of_student_information.model.response.StudentResponseForCourse;
import org.example.the_system_of_student_information.model.response.TeacherResponse;
import org.example.the_system_of_student_information.model.response.TeacherResponseForCourse;

import java.util.List;

public interface CourseMapper {

    static CourseResponse courseToCourseResponse(Course course) {
        return CourseResponse.builder().id(course.getId())
                .name(course.getName())
                .students(course.getStudents().stream().map(s -> {
                    return StudentResponseForCourse.builder().id(s.getId()).build();
                }).toList())
                .teachers(course.getTeachers().stream().map(t -> {
                    return TeacherResponseForCourse.builder().id(t.getId()).build();
                }).toList()).build();
    }

    static List<CourseResponse> coursesToCourseResponses(List<Course> courses) {
        return courses.stream()
                .map(course -> CourseResponse.builder()
                        .id(course.getId())
                        .name(course.getName())
                        .teachers(course.getTeachers().isEmpty()? null : course.getTeachers().stream()
                                .map(t->{
                                    return TeacherResponseForCourse.builder()
                                            .id(t.getId())
                                            .name(t.getUser().getName())
                                            .lastName(t.getUser().getLastName())
                                            .userNumber(t.getUser().getUserNumber())
                                            .salary(t.getSalary()).build();
                                }).toList())
                        .students(course.getStudents().isEmpty()? null:course.getStudents().stream()
                                .map(s->{
                                    return StudentResponseForCourse.builder()
                                            .id(s.getId())
                                            .name(s.getUser().getName())
                                            .lastName(s.getUser().getLastName())
                                            .userNumber(s.getUser().getUserNumber())
                                            .build();
                                }).toList())
                        .build())
                .toList();
    }

}
