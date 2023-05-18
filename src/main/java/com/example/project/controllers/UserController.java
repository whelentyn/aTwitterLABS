package com.example.project.controllers;

import com.example.project.models.User;
import com.example.project.services.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="api/v1/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @Operation(summary = "This endpoint returns a List of all available Users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK: GET the list of all Users",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "An error occured while GETTING the Users",
                    content = @Content) })
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @Operation(summary = "This endpoint returns a User depending on a parameter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK: GET the user",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "An error occurred while GETTING the User",
                    content = @Content) })
    @GetMapping(value = "search/{param}")
    public User getUserByParam(@PathVariable Object param) throws Exception {
        return userService.getUserByParam(param);
    }

    @Operation(summary = "This endpoint registers a User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK: User has been successfully register!",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "An error occurred while registering the User",
                    content = @Content) })
    @PostMapping("/register")
    public void registerUser(@RequestBody User user) throws Exception {
        userService.registerUser(user);
    }

    @Operation(summary = "This endpoint patch a User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK: User has been patched successfully!",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "An error occurred while patching the User",
                    content = @Content) })
    @PostMapping("/{id}/update")
    public void patchUser(@PathVariable Long id, @RequestBody Map<String, String> partialUser) {
        userService.patchUser(id, partialUser);
    }


    @Operation(summary = "This endpoint patch a User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK: User has been patched successfully!",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "An error occurred while patching the User",
                    content = @Content) })
    @DeleteMapping(value = "/{id}/delete")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
