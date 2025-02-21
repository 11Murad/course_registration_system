package org.example.the_system_of_student_information.service.abstracts;
import org.example.the_system_of_student_information.model.request.CourseRequest;
import org.example.the_system_of_student_information.model.response.CourseResponse;
import org.example.the_system_of_student_information.model.result.ResultPage;

public interface CourseService {
    ResultPage<CourseResponse> getAllCoursesByName (String name, int page, int size);
    void addCourse(CourseRequest course);
    void addTeacherById(Integer Id, Integer teacherId);
    void addStudentById(Integer id, Integer studentId);
    void deleteTeacher(Integer courseId, Integer teacherId);
    void deleteStudent(Integer courseId,Integer studentId);
    void updateCourse(Integer id,CourseRequest course);
    void deleteCourse(int id);
}
