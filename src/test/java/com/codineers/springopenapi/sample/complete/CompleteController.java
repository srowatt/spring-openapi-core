package com.codineers.springopenapi.sample.complete;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CompleteController {

    @PostMapping
    public void completePostMapping() {
    }

    @PutMapping
    public void completePutMapping() {
    }

    @DeleteMapping
    public void completeDeleteMapping() {
    }

    @GetMapping
    public String completeGetMapping() {
        return "";
    }

    @PatchMapping
    public void completePatchMapping() {
    }

    @RequestMapping
    public String completeRequestMapping() {
        return "";
    }
}
