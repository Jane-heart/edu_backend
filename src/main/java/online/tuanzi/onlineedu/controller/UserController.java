package online.tuanzi.onlineedu.controller;

import io.swagger.annotations.Api;
import online.tuanzi.onlineedu.model.entity.User;
import online.tuanzi.onlineedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/users")
@Api(tags = "用户管理")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/{id}")
  public User getUserById(@PathVariable int id) {
    return userService.getUserById(id);
  }

  @PostMapping("/")
  public User createUser(@RequestBody User user) {
    return userService.createUser(user);
  }

  @PutMapping("/{id}")
  public User updateUser(@PathVariable int id, @RequestBody User user) {
    return userService.updateUser(id, user);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable int id) {
    userService.deleteUser(id);
  }
}