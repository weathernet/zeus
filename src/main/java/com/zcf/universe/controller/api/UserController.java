package com.zcf.universe.controller.api;

import com.zcf.universe.common.utils.FileUploadUtils;
import com.zcf.universe.pojo.User;
import com.zcf.universe.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    public static final long EXPIRY_TIME = 60;

    @Value("${file.uploadFolder}")
    private String pathUrl;


    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("65456", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public RestTemplate Hellow(RestTemplateBuilder restTemplateBuilder) {
        return null;
    }

    @GetMapping("/setCode")
    public boolean setCode(@RequestParam String phone) {
        redisTemplate.opsForValue().set(phone, "100", EXPIRY_TIME, TimeUnit.SECONDS);
        return true;
    }

    @GetMapping("/getCode")
    public Long getCode(@RequestParam String phone) {
        //Object o = redisTemplate.opsForValue().get(phone);
        return redisTemplate.getExpire(phone);//根据Key获取过期的时间

    }


    @RequestMapping("upload")
    public boolean upload(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        String pathval = request.getSession().getServletContext().getRealPath("/");
        String customPath = "Images/";
        String s = FileUploadUtils.fileUpload(file, pathval, customPath);
        System.out.println(pathval + customPath);
        System.out.println(s);
        return true;
    }

    @GetMapping("/user")
    public List<User> findList() {
        return userService.findList();
    }

    @PostMapping("/user")
    public boolean addUser(User user) {
        return this.userService.addUser(user);
    }

    @PutMapping("/user")
    public boolean updateUser(User user) {
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable("id") Integer id) {
        return this.userService.deleteUser(id);
    }

    @GetMapping("/user6")
    public User selectOneUser() {
        return userService.selectOneUser();
    }


}
