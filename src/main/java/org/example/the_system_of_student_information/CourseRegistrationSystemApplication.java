package org.example.the_system_of_student_information;

import lombok.AllArgsConstructor;
import org.example.the_system_of_student_information.entity.Course;
import org.example.the_system_of_student_information.entity.Student;
import org.example.the_system_of_student_information.entity.Teacher;
import org.example.the_system_of_student_information.entity.User;
import org.example.the_system_of_student_information.repository.CourseRepository;
import org.example.the_system_of_student_information.repository.StudentRepository;
import org.example.the_system_of_student_information.repository.TeacherRepository;
import org.example.the_system_of_student_information.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.Set;

@SpringBootApplication
@AllArgsConstructor
public class CourseRegistrationSystemApplication implements CommandLineRunner {

    CourseRepository courseRepo;

    public static void main(String[] args) {
        SpringApplication.run(CourseRegistrationSystemApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        List<Course> all = courseRepo.findAll();
        System.out.println(all.get(10));

//        for (int i = 0; i < 50; i++) {
//            User user = new User();
//            user.setName("Azer" + i);
//            user.setLastName("Aliyev" + i);
//            user.setUserNumber(new Random().nextInt(10000) + i);
//            Student student = new Student();
//            student.setUser(user);
//
//            User user2 = new User();
//            user2.setName("Vali" + i);
//            user2.setLastName("Agayev" + i);
//            user2.setUserNumber(new Random().nextInt(10000) + i);
//            Student student2 = new Student();
//            student2.setUser(user2);
//
//            User user3 = new User();
//            user3.setName("Xaliq" + i);
//            user3.setLastName("Xalilov" + i);
//            user3.setUserNumber(new Random().nextInt(10000) + i);
//            Student student3 = new Student();
//            student3.setUser(user3);
//
//            User user4 = new User();
//            user4.setName("Akber" + i);
//            user4.setLastName("Mammadov" + i);
//            user4.setUserNumber(new Random().nextInt(10000) + i);
//            Teacher teacher = new Teacher();
//            teacher.setUser(user4);
//            teacher.setSalary(BigDecimal.valueOf(new Random().nextInt(850) + i));
//
//            Course course = new Course();
//            course.setName("Course" + i);
//
//            course.getTeachers().add(teacher);
//            teacher.getCourses().add(course);
//
//            course.getStudents().addAll(Set.of(student,student2,student3));
//            student.setCourse(course);
//            student2.setCourse(course);
//            student3.setCourse(course);
//            courseRepo.save(course);
//        }
    }
}
