package org.example.the_system_of_student_information.controller;
import lombok.RequiredArgsConstructor;
import org.example.the_system_of_student_information.model.response.UserResponse;
import org.example.the_system_of_student_information.model.result.ResultPage;
import org.example.the_system_of_student_information.service.abstracts.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResultPage<UserResponse> getAllCourses(@RequestParam(required = false) String name,
                                                  @RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "5") int size){
        return userService.getAllUsers(name, page, size);
    }
}
