package org.example.the_system_of_student_information.controller;
import lombok.RequiredArgsConstructor;
import org.example.the_system_of_student_information.model.request.CourseRequest;
import org.example.the_system_of_student_information.model.response.CourseResponse;
import org.example.the_system_of_student_information.model.result.ResultPage;
import org.example.the_system_of_student_information.service.concrets.CourseServiceImp;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseServiceImp courseService;

    @GetMapping
    public ResultPage<CourseResponse> getCourses(@RequestParam(required = false) String name,
                                                 @RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "5") int size){
        return courseService.getAllCoursesByName(name, page, size);
    }

    @PostMapping
    public void addCourse(@RequestBody CourseRequest course) {
        courseService.addCourse(course);
    }

    @PutMapping("/{id}")
    public void updateCourse(@PathVariable Integer id, @RequestBody CourseRequest courseRequest) {
        this.courseService.updateCourse(id, courseRequest);
    }

    @PostMapping("/{course-id}/teachers/{teacher-id}")
    public void addTeacher(@PathVariable("course-id") Integer courseId,
                           @PathVariable("teacher-id") Integer teacherId ) {
        this.courseService.addTeacherById(courseId, teacherId);
    }

    @PostMapping("/{course-id}/students/{student-id}")
    public void addStudent(@PathVariable("course-id") Integer courseId,
                           @PathVariable("student-id") Integer studentId) {
        this.courseService.addStudentById(courseId, studentId);
    }

    @DeleteMapping("/{course-id}/teachers/{teacher-id}")
    public void deleteTeacher(@PathVariable("course-id") Integer courseId,
                              @PathVariable("teacher-id") Integer teacherId) {
        courseService.deleteTeacher(courseId,teacherId);
    }

    @DeleteMapping("/{course-id}/students/{student-id}")
    public void deleteStudent(@PathVariable("course-id") Integer courseId, @PathVariable("student-id") Integer studentId) {
        courseService.deleteStudent(courseId,studentId);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Integer id) {
        this.courseService.deleteCourse(id);
    }
}
