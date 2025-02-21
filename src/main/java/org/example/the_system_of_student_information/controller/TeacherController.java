package org.example.the_system_of_student_information.controller;
import lombok.RequiredArgsConstructor;
import org.example.the_system_of_student_information.model.request.TeacherRequest;
import org.example.the_system_of_student_information.model.result.DataResult;
import org.example.the_system_of_student_information.model.result.ResultPage;
import org.example.the_system_of_student_information.model.response.TeacherResponse;
import org.example.the_system_of_student_information.service.concrets.TeacherServiceImp;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherServiceImp teacherService;

    @GetMapping
    public DataResult<ResultPage<TeacherResponse>> getAllTeachers(@RequestParam(required = false) String name,
                                                                  @RequestParam(defaultValue = "0") int page,
                                                                  @RequestParam(defaultValue = "5") int size) {
        return teacherService.getAllTeachersByName(name,page,size);
    }


    @GetMapping("{id}")
    public TeacherResponse getTeacherById(@PathVariable Integer id) {
        return teacherService.getTeacherById(id);
    }


    @PostMapping
    public void addTeacher(@RequestBody TeacherRequest teacher) {
        teacherService.addTeacher(teacher);
    }


    @PutMapping("/{id}")
    public void updateTeacher(@PathVariable int id, @RequestBody TeacherRequest teacherRequest) {
        teacherService.updateTeacher(id,teacherRequest);
    }
}
