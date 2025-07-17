package com.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WhatsAppService whatsAppService;

    public User registerUser(User user) {
        User savedUser = userRepository.save(user);
        whatsAppService.sendRegistrationMessage(user.getPhoneNumber(), user.getFirstName());
        return savedUser;
    }
}
