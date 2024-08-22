package com.github.lrssmeiksts.qwiz.web.controller;

import com.github.lrssmeiksts.qwiz.business.service.UserService;
import com.github.lrssmeiksts.qwiz.model.User;
import com.github.lrssmeiksts.qwiz.swagger.DescriptionVariables;
import com.github.lrssmeiksts.qwiz.swagger.HTMLResponseMessages;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @Operation(description = "finds all users",
    summary ="Returns list of users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = HTMLResponseMessages.HTTP_200, content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
            }),
            @ApiResponse(responseCode = "500", description = HTMLResponseMessages.HTTP_500, content = @Content)})
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
    log.info("Trying to retrieve list of all Users");
        List<User> userList = userService.getAllUsers();
        if(userList.isEmpty()){
            log.warn("User list is empty! {} ", userList);
            return ResponseEntity.ok(userList);
        }
        log.debug("Users found! List size: {}", userList.size());
        return ResponseEntity.ok(userList);
    }
}