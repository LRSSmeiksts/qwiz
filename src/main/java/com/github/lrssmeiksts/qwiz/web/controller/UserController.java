package com.github.lrssmeiksts.qwiz.web.controller;

import com.github.lrssmeiksts.qwiz.business.service.UserService;
import com.github.lrssmeiksts.qwiz.model.User;
import com.github.lrssmeiksts.qwiz.swagger.HTMLResponseMessages;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Operation(description = "saves user")
    @ApiResponses(value={
            @ApiResponse(responseCode = "201", description = HTMLResponseMessages.HTTP_201,content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
            }),
            @ApiResponse(responseCode = "500", description = HTMLResponseMessages.HTTP_500, content = @Content),
            @ApiResponse(responseCode = "400", description = HTMLResponseMessages.HTTP_400, content = @Content)
    })
    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody
                                        User user, BindingResult bindingResult){
        log.info("Attempting to create a new user by passing: {}", user);
        if(bindingResult.hasErrors()){
            log.error("New user is not created. Binding result errors: {}", bindingResult);
            List<String> errorMessages = bindingResult.getFieldErrors().stream()
                    .map(fieldError -> fieldError.getField()+ ": "+ fieldError.getDefaultMessage())
                    .collect(Collectors.toList());

            return ResponseEntity.badRequest().body(errorMessages);
        }

        if(user.getId() != null){
            log.error("New user is not created. ID must not be included in the request");
            return ResponseEntity.badRequest().body("ID must not be included in the request");
        }

        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @Operation(description = "Gets user by id")
    @ApiResponses(value={@ApiResponse(responseCode = "200", description = HTMLResponseMessages.HTTP_200,content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
    }),
            @ApiResponse(responseCode = "500", description = HTMLResponseMessages.HTTP_500, content = @Content),
            @ApiResponse(responseCode = "404", description = HTMLResponseMessages.HTTP_404, content = @Content)

    })
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@NonNull @PathVariable Long id){
        log.info("Attempting to find User with ID: {}", id);
        Optional<User> optUser = (userService.getUserById(id));
        if(optUser.isEmpty()){
            log.warn("User with ID {} is not found", id);
        }
        else{
            log.debug("User with ID {} is found: {}", id, optUser);
        }
        return optUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}