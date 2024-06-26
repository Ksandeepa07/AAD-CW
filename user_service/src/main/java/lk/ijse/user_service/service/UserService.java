package lk.ijse.user_service.service;

import lk.ijse.user_service.dto.UserDTO;
import org.apache.catalina.User;

public interface UserService {
    UserDTO save(UserDTO userDTO);
    boolean login(UserDTO userDTO);
    boolean existById(String userId);
}
