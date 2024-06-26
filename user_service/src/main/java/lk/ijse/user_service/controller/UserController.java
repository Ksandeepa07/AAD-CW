package lk.ijse.user_service.controller;

import lk.ijse.user_service.dto.UserDTO;
import lk.ijse.user_service.dto.VehicleDTO;
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
    public UserDTO register(@RequestBody UserDTO userDTO){
        System.out.println(userDTO);
       return userService.save(userDTO);
    }

    @PostMapping("/login")
    public String  findById(@RequestBody UserDTO userDTO){
        System.out.println(userDTO);
        boolean isLogged = userService.login(userDTO);
        if (isLogged){
            return "Login Successful!!";
        }
        return "Login failed!!";
    }

    @PostMapping("/findById")
    public Boolean findById(@RequestBody String userId){
        System.out.println("user id is "+userId);
        return userService.existById(userId);

    }


}