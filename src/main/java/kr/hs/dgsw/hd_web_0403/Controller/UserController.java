package kr.hs.dgsw.hd_web_0403.Controller;

import kr.hs.dgsw.hd_web_0403.Domain.User;
import kr.hs.dgsw.hd_web_0403.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/JoinUser")
    public boolean joinUser(@RequestBody User user){
        return userService.joinUser(user);
    }

    @GetMapping("/GetUser/{id}")
    public User getUser(@PathVariable String id){
        return userService.getUser(id);
    }

    @PutMapping("/UpdateUser/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/RemoveUser/{id}")
    public boolean removeUser(@PathVariable String id){
        return userService.removeUser(id);
    }
}
