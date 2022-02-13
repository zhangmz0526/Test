package com.example.druidtest.controller;


import com.example.druidtest.entity.User;
import com.example.druidtest.service.UsersService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/user")
@RestController
public class UsersController {
    final
    UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/{id}")
    public List<Map<String, Object>> findById(@PathVariable Integer id){
        return usersService.getUser(id);
    }
    @GetMapping
    public List<Map<String, Object>> findAll(){
        return usersService.getUserList();
    }
    @DeleteMapping("/{id}")
    public String removeUser(@PathVariable Integer id){
        return usersService.deleteUser(id);
    }
    @PostMapping
    public String addUser( @RequestBody User user){
        return usersService.postUser(user);
    }
    @PutMapping("/{id}")
    public String modifyUser( @PathVariable Integer id, @RequestBody User user){
        return usersService.putUser(id, user);

    }
}