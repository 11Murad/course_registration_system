package org.example.the_system_of_student_information.mapper;
import org.example.the_system_of_student_information.entity.User;
import org.example.the_system_of_student_information.model.response.UserResponse;

public interface UserMapper {
    static UserResponse userToUserResponse(User user) {
        return UserResponse.builder().id(user.getId())
                .name(user.getName()).lastName(user.getLastName()).userNumber(user.getUserNumber()).build();
    }
}
