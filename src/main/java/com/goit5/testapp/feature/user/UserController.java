package com.goit5.testapp.feature.user;

import com.goit5.testapp.feature.user.dto.DeleteUserResponse;
import com.goit5.testapp.feature.user.dto.SaveUserResponse;
import com.goit5.testapp.feature.user.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Collection;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@RestController
public class UserController {
    private final UserService userService;
    private final UserValidateService validateService;

    @GetMapping("/list")
    public List<UserDTO> list() {
        return userService.findAll().stream().map(UserDTO::fromUser).collect(Collectors.toList());
    }

    @PostMapping("/save")
    public SaveUserResponse save(@RequestBody UserDTO userDto) {
        if (!validateService.isEmailValid(userDto.getEmail())) {
            return SaveUserResponse.failed(SaveUserResponse.Error.invalidEmail);
        }

        User user = UserDTO.fromDto(userDto);

        userService.save(user);

        return SaveUserResponse.success();
    }

    @PostMapping("/delete/{email}")
    public DeleteUserResponse delete(@PathVariable("email") String email, HttpServletResponse response) {
        if (!userService.exists(email)) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);

            return DeleteUserResponse.failed(DeleteUserResponse.Error.userNotFound);
        }

        userService.deleteById(email);

        return DeleteUserResponse.success();
    }

    @GetMapping("/search")
    public List<UserDTO> search(@RequestParam(name = "query", required = false) String query,
                                HttpServletResponse response) {
        if (!validateService.isSearchQueryValid(query)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return Collections.emptyList();
        }

        return userService.search(query).stream().map(UserDTO::fromUser).collect(Collectors.toList());
    }

    @GetMapping("/countOlderThan/{age}")
    public int countPeopleOlderThan(@PathVariable("age") int age) {
        return userService.countPeopleOlderThan(age);
    }
}
