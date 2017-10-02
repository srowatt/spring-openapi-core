package com.codineers.springopenapi.sample.complete;

import com.codineers.springopenapi.sample.complete.model.ResponseWrapper;
import com.codineers.springopenapi.sample.complete.model.User;
import com.codineers.springopenapi.sample.complete.model.UserId;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController("/complete")
public class CompleteRestController {

    @PostMapping(
        name = "createGroupUser",
        path = {"/groups/{groupId}/users", "/users"},
        headers = {"x-trace-id", "x-span-id"},
        params = {"correlationId", "mustChangePassword"},
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"}
    )
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseWrapper<UserId> createGroupUser(
        @RequestBody(required = true) User user,
        @PathVariable(name = "gid", required = true) String groupId,
        @RequestParam(name = "mcp", required = false, defaultValue = "true") boolean mustChangePassword,
        @RequestParam(name = "cid", required = true) String correlationId
    ) {

        return null;
    }

    @PutMapping
    public void completePutMapping() {
    }

    @DeleteMapping
    public void completeDeleteMapping() {
    }

    @GetMapping(
        name = "getGroupUser",
        path = "/postMapping/groups/{groupId}/users/{userId}/",
        produces = "application/json"
    )
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
