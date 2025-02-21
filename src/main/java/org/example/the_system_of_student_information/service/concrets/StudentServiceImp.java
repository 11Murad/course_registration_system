package org.example.the_system_of_student_information.service.concrets;

import lombok.AllArgsConstructor;
import org.example.the_system_of_student_information.entity.Student;
import org.example.the_system_of_student_information.entity.User;
import org.example.the_system_of_student_information.mapper.StudentMapper;
import org.example.the_system_of_student_information.model.request.StudentRequest;
import org.example.the_system_of_student_information.model.result.ResultPage;
import org.example.the_system_of_student_information.model.response.StudentResponse;
import org.example.the_system_of_student_information.repository.StudentRepository;
import org.example.the_system_of_student_information.service.abstracts.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImp implements StudentService {
    private final StudentRepository studentRepo;
    private final UserServiceImp userService;

    @Override
    public StudentResponse getStudentById(int id) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
        return StudentMapper.mapStudentToResponse(student);
    }

    @Override
    public ResultPage<StudentResponse> getAllStudents(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> students;
        if (name != null) {
            students = studentRepo.findByUser_NameContainingIgnoreCase(name, pageable);
        } else {
            students = studentRepo.findAll(pageable);
        }
        return new ResultPage<>(StudentMapper.mapStudentsToResponses(students.getContent()),
                page, size, students.getTotalPages());
    }

    @Override
    public void addStudent(StudentRequest student) {
        User user = userService.saveStudentUser(student);
        Student savedStudent = new Student();
        savedStudent.setScholarshipStatus(student.getScholarshipStatus());
        savedStudent.setUser(user);

        studentRepo.save(savedStudent);
    }

    @Override
    public void updateStudent(Integer id, StudentRequest student) {
        Student updateStudent = studentRepo.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Student not found"));
        updateStudent.setUser(User.builder()
                .name(student.getName()).lastName(student.getLastName())
                .userNumber(student.getUserNumber())
                .password(student.getPassword()).build());
        updateStudent.setScholarshipStatus(student.getScholarshipStatus());
        updateStudent.getCourse().setId(student.getCourseId());

        studentRepo.save(updateStudent);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepo.findStudentById(id).orElseThrow(() -> new IllegalArgumentException("Student not found"));
        studentRepo.deleteById(id);
    }
}
