package com.example.demo;


import com.example.demo.config.security.SecurityService;
import io.jsonwebtoken.Claims;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@CrossOrigin
public class TestController {
    @Autowired
    private SecurityService securityService;
    @Value("${file}")
    private String fileDirectory;


    @GetMapping("/")
    public String test(){
        return "test";
    }
//
//    @GetMapping("/{id}")
//    public String testVariable(@PathVariable String id){
//        return id;
//    }

    @PostMapping("/create/token")
    public String createToken(@RequestBody Map<String,Object> Dto){

        String token = securityService.createToken(Dto.get("subject").toString());
        return token;
    }
    @GetMapping("/get/subject")
    public String getSubject(HttpServletRequest request){

        String token = request.getHeader("Authorization");
        return securityService.getSubject(token);
    }
    @GetMapping("/get/claims")
    public String getClaims(HttpServletRequest request){

        String token = request.getHeader("Authorization");
        return securityService.getSubject(token);
    }

    @PostMapping("/upload")
    public String saveFile(@RequestParam MultipartFile file) throws IOException {
        //
        if (!file.isEmpty()) {
            String downloadPath = fileDirectory + file.getOriginalFilename();
            file.transferTo(new File(downloadPath));
        }
        return "success";
    }


}
