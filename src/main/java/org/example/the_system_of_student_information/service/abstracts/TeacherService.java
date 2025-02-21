package org.example.the_system_of_student_information.service.abstracts;
import org.example.the_system_of_student_information.model.request.TeacherRequest;
import org.example.the_system_of_student_information.model.result.DataResult;
import org.example.the_system_of_student_information.model.result.ResultPage;
import org.example.the_system_of_student_information.model.response.TeacherResponse;

public interface TeacherService {
    DataResult<ResultPage<TeacherResponse>> getAllTeachersByName(String name, int page, int size);
    TeacherResponse getTeacherById(int id);
    void addTeacher(TeacherRequest teacher);
    void updateTeacher(Integer id, TeacherRequest teacherRequest);
    void deleteTeacher(int id);
}
