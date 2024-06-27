package lk.ijse.user_service.repo;

import lk.ijse.user_service.dto.UserDTO;
import lk.ijse.user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findUserByEmail(String userEmail);
}
