package org.example.the_system_of_student_information.service.concrets;
import lombok.AllArgsConstructor;
import org.example.the_system_of_student_information.entity.User;
import org.example.the_system_of_student_information.entity.enums.Status;
import org.example.the_system_of_student_information.mapper.UserMapper;
import org.example.the_system_of_student_information.model.request.StudentRequest;
import org.example.the_system_of_student_information.model.request.TeacherRequest;
import org.example.the_system_of_student_information.model.response.UserResponse;
import org.example.the_system_of_student_information.model.result.ResultPage;
import org.example.the_system_of_student_information.repository.UserRepository;
import org.example.the_system_of_student_information.service.abstracts.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepo;

    @Override
    public ResultPage<UserResponse> getAllUsers(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> users;
        if (name != null) {
            users = userRepo.findByNameContainingIgnoreCase(name, pageable);
        } else {
            users = userRepo.findAll(pageable);
        }
        List<UserResponse> userResponses =  users.stream().map(UserMapper::userToUserResponse).toList();
        return new ResultPage<>(userResponses,page,size,users.getTotalPages());
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public User saveTeacherUser(TeacherRequest teacherRequest) {
        User user=User.builder()
                .name(teacherRequest.getName())
                .lastName(teacherRequest.getLastName())
                .userNumber(teacherRequest.getUserNumber())
                .password(teacherRequest.getPassword())
                .status(Status.ACTIVE)
                .build();
        return userRepo.save(user);
    }

    @Override
    public User saveStudentUser(StudentRequest studentRequest) {
        User user=User.builder()
                .name(studentRequest.getName())
                .lastName(studentRequest.getLastName())
                .userNumber(studentRequest.getUserNumber())
                .password(studentRequest.getPassword())
                .status(Status.ACTIVE)
                .build();
        return userRepo.save(user);
    }

    @Override
    public void deleteUser(int id) {

    }

}
