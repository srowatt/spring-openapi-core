package com.codineers.springopenapi.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SimpleController {

    @PostMapping
    public void simplePostMapping() {
    }

    @PutMapping
    public void simplePutMapping() {
    }

    @DeleteMapping
    public void simpleDeleteMapping() {
    }

    @GetMapping
    public String simpleGetMapping() {
        return "";
    }

    @PatchMapping
    public void simplePatchMapping() {
    }

    @RequestMapping
    public String simpleRequestMapping() {
        return "";
    }
}
