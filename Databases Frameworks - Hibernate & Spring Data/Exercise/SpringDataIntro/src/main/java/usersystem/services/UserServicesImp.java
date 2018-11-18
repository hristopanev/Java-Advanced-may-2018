package usersystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usersystem.repository.UserRepository;

@Service
public class UserServicesImp  implements UserServices{

    private final UserRepository userRepository;

    @Autowired
    public UserServicesImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void seedUsers() {

    }
}
