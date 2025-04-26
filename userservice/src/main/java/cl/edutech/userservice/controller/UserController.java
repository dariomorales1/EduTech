package cl.edutech.userservice.controller;

import cl.edutech.userservice.controller.Response.MessageResponse;
import cl.edutech.userservice.domain.User;
import cl.edutech.userservice.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/ping")
    public ResponseEntity<MessageResponse> ping() {
        return ResponseEntity.ok(new MessageResponse("PONG"));
    }

    List<User> userList;

    public UserController() {
        userList = UserRepository.findAll();
    }

    // Create =======================================================================================

    @PostMapping
    public ResponseEntity<MessageResponse> createUser(@RequestBody User request) {
        String email = request.getEmail();
        for (User user : userList) {
            if(user.getEmail().equals(email)){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageResponse("Error: User already exists"));
            }
        }
        userList.add(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageResponse("User created"));
    }


    // Read =========================================================================================

    @GetMapping("/list")
    public ResponseEntity<List<User>> getUserList() {
        return ResponseEntity.ok(userList);
    }


    // Update =======================================================================================

    @PutMapping("/{email}")
    public ResponseEntity<MessageResponse> replaceUser(@PathVariable String email, @RequestBody User request) {

        User found = null;

        for(User user : userList) {
            if(user.getEmail().equals(email)){
                found = user;
                break;
            }
        }
        int index = userList.indexOf(found);
        if(index == -1) {
            return ResponseEntity.notFound().build();
        }
        userList.set(index, request);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("User updated"));
    }

    // Delete =======================================================================================

    @DeleteMapping("/{email}")
    public ResponseEntity<MessageResponse> deleteUser(@PathVariable String email) {
        User found = null;
        for(User user : userList) {
            if(user.getEmail().equals(email)){
                found = user;
                break;
            }
        }

        if(found == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("User not found"));
        }

        userList.remove(found);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("User deleted"));

    }
}
