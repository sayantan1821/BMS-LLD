package com.sayantan.bookmyshow.controllers;

import com.sayantan.bookmyshow.dto.*;
import com.sayantan.bookmyshow.models.User;
import com.sayantan.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }
    public SignUpResponseDTO signUp(SignUpRequestDTO signUpRequestDTO) {
        SignUpResponseDTO signUpResponseDTO = new SignUpResponseDTO();
        try{
            User user = userService.signUp(signUpRequestDTO.getEmail(), signUpRequestDTO.getPassword());
            signUpResponseDTO.setUserId(user.getId());
            signUpResponseDTO.setStatus(ResponseStatus.SUCCESS);
        }catch(Exception e) {
            signUpResponseDTO.setStatus(ResponseStatus.FAILURE);
        }
        return signUpResponseDTO;
    }

    public SignInResponseDTO signIn(SignInRequestDTO signInRequestDTO) {
        SignInResponseDTO signInResponseDTO = new SignInResponseDTO();
        try {
            User user = userService.signIn(signInRequestDTO.getEmail(), signInRequestDTO.getPassword());
            signInResponseDTO.setUserId(user.getId());
            signInResponseDTO.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            signInResponseDTO.setStatus(ResponseStatus.FAILURE);
        }
        return signInResponseDTO;
    }
}
