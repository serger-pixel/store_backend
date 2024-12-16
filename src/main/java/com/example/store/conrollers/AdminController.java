package com.example.store.conrollers;

import com.example.store.entities.UserStore;
import com.example.store.exceptions.NotAdmin;
import com.example.store.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.store.services.UserService._NotAccess;
import static com.example.store.services.UserService._adminRole;

@RestController
public class AdminController {
    @Autowired
    AdminService _service;

    @GetMapping(value = "users/{login}/get/all")
    public ResponseEntity<Iterable<UserStore>> getAllUsers(@PathVariable(value = "login") String userLogin){
        UserStore user = _service._userRepository.findBy_login(userLogin);
        if (user.getRole().equals(_adminRole)) {
            return ResponseEntity.ok().body(_service.getAllUsers(userLogin));
        }
        throw new NotAdmin(_NotAccess);
    }

    @PostMapping(value = "users/{login}/post")
    public ResponseEntity<UserStore> addUser(@PathVariable(value = "login") String userLogin,
                                             @RequestBody UserStore user){
        UserStore localUser = _service._userRepository.findBy_login(userLogin);
        if (localUser.getRole().equals(_adminRole)) {
            return ResponseEntity.ok().body(_service.addUser(user));
        }
        throw new NotAdmin(_NotAccess);
    }

    @DeleteMapping(value ="users/{login}/delete/{id}")
    public void deleteUser(@PathVariable(value = "login") String userLogin,
                           @PathVariable(value = "id") String id){
        UserStore localUser = _service._userRepository.findBy_login(userLogin);
        if (localUser.getRole().equals(_adminRole)) {
            _service.deleteUser(Integer.parseInt(id));
        }
        throw new NotAdmin(_NotAccess);
    }

    @PutMapping(value="users/{login}/editrole/{id}/{role}")
    public void setRole(@PathVariable(value="login") String userLogin,
                        @PathVariable(value = "id") String id,
                        @PathVariable(value = "role") String role){
        UserStore localUser = _service._userRepository.findBy_login(userLogin);
        if (localUser.getRole().equals(_adminRole)){
            _service.setRole(Integer.parseInt(id), role);
        }
        throw new NotAdmin(_NotAccess);
    }

    @PutMapping(value="users/{login}/setuserstatus/{id}/{status}")
    public void setUserStatus(@PathVariable(value="login") String userLogin,
                              @PathVariable(value = "id") String id,
                              @PathVariable(value = "status") String status){
        UserStore localUser = _service._userRepository.findBy_login(userLogin);
        if (localUser.getRole().equals(_adminRole)){
            _service.setUserStatus(Integer.parseInt(id), status);
        }
        throw new NotAdmin(_NotAccess);
    }
}
