package com.apiusuario.demousuario.Controller;

import Usuario.User;
import com.apiusuario.demousuario.Repository.UserRepository;
import com.apiusuario.demousuario.Service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/usuario")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/cadastro")
    public ResponseEntity<?> create(@RequestBody User user) {
        try {
            User createUser = userService.create(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createUser); //"Usuario criado."
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar usuario." + e.getMessage());
        }
    }

    @GetMapping("/listar")
    public List<User> getAll() {
        return this.userService.getAll();
    }

}