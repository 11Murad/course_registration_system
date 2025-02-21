package org.example.the_system_of_student_information.service.concrets;
import lombok.AllArgsConstructor;
import org.example.the_system_of_student_information.entity.Course;
import org.example.the_system_of_student_information.entity.Student;
import org.example.the_system_of_student_information.entity.Teacher;
import org.example.the_system_of_student_information.mapper.CourseMapper;
import org.example.the_system_of_student_information.model.request.CourseRequest;
import org.example.the_system_of_student_information.model.response.CourseResponse;
import org.example.the_system_of_student_information.model.result.ResultPage;
import org.example.the_system_of_student_information.repository.CourseRepository;
import org.example.the_system_of_student_information.repository.StudentRepository;
import org.example.the_system_of_student_information.repository.TeacherRepository;
import org.example.the_system_of_student_information.service.abstracts.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImp implements CourseService {
    private final CourseRepository courseRepo;
    private final TeacherRepository teacherRepo;
    private final StudentRepository studentRepo;

    @Override
    public ResultPage<CourseResponse> getAllCoursesByName(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Course> courses;
        if (name != null) {
            courses = courseRepo.findByNameContainingIgnoreCase(name, pageable);
        } else {
            courses = courseRepo.findAllCourses(pageable);
        }
        List<CourseResponse> responseCourse = CourseMapper.coursesToCourseResponses(courses.getContent()) ;
        return new ResultPage<>(responseCourse,page,size,courses.getTotalPages());
    }

    @Override
    public void addCourse(CourseRequest course) {
        Course newCourse = new Course();
        newCourse.setName(course.getName());
        courseRepo.save(newCourse);
    }

    @Override
    public void addTeacherById( Integer courseId,Integer teacherId) {
        Course course = courseRepo.findById(courseId).orElseThrow(
                ()->new IllegalArgumentException("Course not found"));
        Teacher teacher = teacherRepo.findById(teacherId).
                orElseThrow(()->new IllegalArgumentException("Teacher not found"));
        course.getTeachers().add(teacher);
        courseRepo.save(course);
    }

    @Override
    public void addStudentById(Integer id, Integer studentId) {
        Course course = courseRepo.findById(id).orElseThrow(
                ()->new IllegalArgumentException("Course not found"));
        Student student = studentRepo.findById(studentId).
                orElseThrow(()->new IllegalArgumentException("Student not found"));
        student.setCourse(course);
        studentRepo.save(student);
    }

    @Override
    public void deleteTeacher(Integer courseId, Integer teacherId) {
        Course course = courseRepo.findById(courseId).
                orElseThrow(() -> new IllegalArgumentException("Course not found"));
        boolean removed = false;
        for (Teacher teacher : course.getTeachers()) {
            if(teacher.getId().equals(teacherId)) {
                course.getTeachers().remove(teacher);
                removed = true;
            }
        }
        if (removed)
            this.courseRepo.save(course);
        else
            throw new IllegalArgumentException("Teacher not found");
    }

    @Override
    public void deleteStudent(Integer courseId, Integer studentId) {
        Course course = courseRepo.findById(courseId).
                orElseThrow(() -> new IllegalArgumentException("Course not found"));
        boolean removed = false;
        for (Student student : course.getStudents()) {
            if(student.getId().equals(studentId)) {
                course.getStudents().remove(student);
                removed = true;
            }
        }
        if (removed) this.courseRepo.save(course);
        else throw new IllegalArgumentException("Student not found");
    }

    @Override
    public void updateCourse(Integer id,CourseRequest course) {
    Course updatedCourse =courseRepo.findById(id).
            orElseThrow(()->new IllegalArgumentException("Course not found"));
    updatedCourse.setName(course.getName());
    courseRepo.save(updatedCourse);
    }

    @Override
    public void deleteCourse(int id) {
    studentRepo.deleteById(id);
    }
}
