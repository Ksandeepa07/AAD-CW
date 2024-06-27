package lk.ijse.user_service.service;

import lk.ijse.user_service.dto.UserDTO;
import lk.ijse.user_service.entity.User;
import lk.ijse.user_service.repo.UserRepo;
import lk.ijse.user_service.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO save(UserDTO userDTO) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return mapper.map(userRepo.save(mapper.map(userDTO,User.class)),UserDTO.class);
    }

    @Override
    public boolean login(UserDTO userDTO) {
        User userData = userRepo.findUserByEmail(userDTO.getEmail());
        if (userData!=null){
           if (passwordEncoder.matches(userDTO.getPassword(),userData.getPassword())){
               return true;
           }else{
               throw new NotFoundException("Entered password is incorrect!!");
           }
        }else {
           throw new NotFoundException("Can't find user with this email!!");
        }
    }

    @Override
    public boolean existById(Integer userId) {
        if (userRepo.existsById(userId)){
            return true;
        }else {
            throw new NotFoundException("Can't find user id!!");
        }

    }
}
