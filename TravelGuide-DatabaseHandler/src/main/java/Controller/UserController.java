package Controller;

import Authentication.EncryptService;
import Exception.ResourceNotFoundException;
import Model.User;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    @GetMapping("/users/{userEmail}/{password}")
    public User getUserByEmail(@PathVariable String userEmail, @PathVariable String password)
    {
        return userRepository.findByEmailAndPassword(userEmail,password);
    }


    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user)
    {
        user.setPassword(EncryptService.encryptPassword(user.getPassword()));
        return userRepository.save(user);
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable UUID userId,
                           @Valid @RequestBody User userRequest)
    {
        return userRepository.findById(userId)
                .map(user -> {
                    user.setEmail(userRequest.getEmail());
                    user.setName(userRequest.getName());
                    user.setSurname(userRequest.getSurname());
                    user.setPassword(EncryptService.encryptPassword(userRequest.getPassword()));
                    return userRepository.save(user);

                }).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID userId)
    {
        return userRepository.findById(userId)
                .map(user -> {
                    userRepository.delete(user);
                    return ResponseEntity.ok().build();
                }).orElseThrow(()-> new ResourceNotFoundException("User not found with id " + userId));
    }


}
