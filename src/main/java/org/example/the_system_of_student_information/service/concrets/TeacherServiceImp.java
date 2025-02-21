package org.example.the_system_of_student_information.service.concrets;
import lombok.AllArgsConstructor;
import org.example.the_system_of_student_information.entity.Teacher;
import org.example.the_system_of_student_information.entity.User;
import org.example.the_system_of_student_information.mapper.TeacherMapper;
import org.example.the_system_of_student_information.model.request.TeacherRequest;
import org.example.the_system_of_student_information.model.result.DataResult;
import org.example.the_system_of_student_information.model.result.ResultPage;
import org.example.the_system_of_student_information.model.response.TeacherResponse;
import org.example.the_system_of_student_information.model.result.SuccessDataResult;
import org.example.the_system_of_student_information.service.abstracts.TeacherService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.example.the_system_of_student_information.repository.*;

@Service
@AllArgsConstructor
public class TeacherServiceImp implements TeacherService {

    private final TeacherRepository teacherRepo;
    private final UserRepository userRepo;
    private final UserServiceImp userService;

    @Override
    public DataResult<ResultPage<TeacherResponse>> getAllTeachersByName(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Teacher> teachers;
        if (name != null) {
            teachers = teacherRepo.findByUser_NameContainingIgnoreCase(name, pageable);
        } else {
            teachers = teacherRepo.findAll(pageable);
        }
        return new SuccessDataResult<>("successfully listed", new ResultPage<>(TeacherMapper.mapTeachersToResponses(teachers.getContent()),
                page, size, teachers.getTotalPages()));
    }

    @Override
    public TeacherResponse getTeacherById(int id) {
        Teacher teacher = teacherRepo.findById(id).
                orElseThrow(()->new IllegalArgumentException("Teacher not found"));
        return TeacherMapper.mapTeacherToResponse(teacher);
    }

    @Override
    public void addTeacher(TeacherRequest teacher) {
        User user = userService.saveTeacherUser(teacher);
        Teacher savedTeacher = new Teacher();
        savedTeacher.setSalary(teacher.getSalary());
        savedTeacher.setUser(user);

        teacherRepo.save(savedTeacher);
    }

    @Override
    public void updateTeacher(Integer id, TeacherRequest teacher) {
        Teacher updateTeacher = teacherRepo.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Teacher not found"));
        updateTeacher.setUser(User.builder()
                .name(teacher.getName()).lastName(teacher.getLastName())
                .userNumber(teacher.getUserNumber())
                .password(teacher.getPassword()).build());
        updateTeacher.setSalary(teacher.getSalary());

        teacherRepo.save(updateTeacher);
    }


    @Override
    public void deleteTeacher(int id) {

}

}
