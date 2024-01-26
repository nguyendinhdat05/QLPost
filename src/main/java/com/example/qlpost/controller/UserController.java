package com.example.qlpost.controller;
import com.example.qlpost.model.User;
import com.example.qlpost.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity findAll(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity save(@RequestBody User user){
        return new ResponseEntity<>(userRepository.save(user),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id , User user){
        user.setId(id);
        return new ResponseEntity<>(userRepository.save(user),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id ){
        userRepository.deleteById(id);
        return new ResponseEntity<>("done delete", HttpStatus.OK);
    }

    @GetMapping("/check")
    public ResponseEntity checkAcc(String username , String password){
        return new ResponseEntity<>(userRepository.findByUsernameAndPassword(username, password), HttpStatus.OK);
    }

}
