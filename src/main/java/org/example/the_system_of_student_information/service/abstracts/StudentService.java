package org.example.the_system_of_student_information.service.abstracts;
import org.example.the_system_of_student_information.model.request.StudentRequest;
import org.example.the_system_of_student_information.model.result.ResultPage;
import org.example.the_system_of_student_information.model.response.StudentResponse;

public interface StudentService {
    ResultPage<StudentResponse> getAllStudents(String name, int page, int size);
    StudentResponse getStudentById(int id);
    void addStudent(StudentRequest student);
    void updateStudent(Integer id,StudentRequest studentRequest);
    void deleteStudent(int id);
}
