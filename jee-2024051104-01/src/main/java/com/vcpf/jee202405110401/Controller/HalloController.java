package com.vcpf.jee202405110401.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HalloController {
    @GetMapping("/hallo")
    public String hallo(){
        return "hallo";
    }
}
