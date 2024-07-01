package lk.ijse.user_service.controller;

import jakarta.validation.Valid;
import lk.ijse.user_service.dto.UserDTO;

import lk.ijse.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController() {
        System.out.println("User Controller Instantiated");
    }

    @PostMapping("/register")
    public UserDTO register(@Valid @RequestBody UserDTO userDTO){
        System.out.println(userDTO);
       return userService.save(userDTO);
    }

    @PostMapping("/login")
    public String  findById(@Valid @RequestBody UserDTO userDTO){
        System.out.println(userDTO);
        boolean isLogged = userService.login(userDTO);
        if (isLogged){
            return "Login Successful!!";
        }
        return "Login failed!!";
    }

    @GetMapping("/findById/{userId}")
    public Boolean findById(@PathVariable Integer userId){
        System.out.println("user id is "+userId);
        return userService.existById(userId);

    }


}
