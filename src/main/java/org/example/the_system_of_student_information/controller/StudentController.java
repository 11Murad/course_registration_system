package org.example.the_system_of_student_information.controller;
import lombok.RequiredArgsConstructor;
import org.example.the_system_of_student_information.model.request.StudentRequest;
import org.example.the_system_of_student_information.model.result.ResultPage;
import org.example.the_system_of_student_information.model.response.StudentResponse;
import org.example.the_system_of_student_information.service.concrets.StudentServiceImp;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentServiceImp studentService;

    @GetMapping
    public ResultPage<StudentResponse> getAllStudents(@RequestParam(required = false) String name,
                                                      @RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "5") int size) {
        return studentService.getAllStudents(name, page, size);
    }

    @GetMapping("{id}")
    public StudentResponse getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public void save(@RequestBody StudentRequest student) {
    studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Integer id, @RequestBody StudentRequest studentRequest) {
        studentService.updateStudent(id,studentRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }


}
