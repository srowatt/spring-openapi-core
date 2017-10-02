package com.codineers.springopenapi.sample.minimum;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MinimumRestController {

    @PostMapping
    public void minimumPostMapping() {
    }

    @PutMapping
    public void minimumPutMapping() {
    }

    @DeleteMapping
    public void minimumDeleteMapping() {
    }

    @GetMapping
    public String minimumGetMapping() {
        return "";
    }

    @PatchMapping
    public void minimumPatchMapping() {
    }

    @RequestMapping
    public String minimumRequestMapping() {
        return "";
    }
}
