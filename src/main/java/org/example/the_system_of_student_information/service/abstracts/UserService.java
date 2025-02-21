package org.example.the_system_of_student_information.service.abstracts;
import org.example.the_system_of_student_information.entity.User;
import org.example.the_system_of_student_information.model.request.StudentRequest;
import org.example.the_system_of_student_information.model.request.TeacherRequest;
import org.example.the_system_of_student_information.model.response.UserResponse;
import org.example.the_system_of_student_information.model.result.ResultPage;

public interface UserService {
    ResultPage<UserResponse> getAllUsers(String name, int page, int size);
    User getUserById(int id);
    User saveTeacherUser(TeacherRequest teacherRequest);
    User saveStudentUser(StudentRequest studentRequest);
    void deleteUser(int id);
}
