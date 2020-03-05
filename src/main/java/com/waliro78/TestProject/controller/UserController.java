package com.waliro78.TestProject.controller;

import com.waliro78.TestProject.entity.User;
import com.waliro78.TestProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by User on 3/2/2020.
 */
@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/welcomepage")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping("/createauser")
    public String createNewUser(Model model,@Valid User user ,Errors errors){
        if(errors.hasErrors()){
            return "newuser";
        }
         user = new User();
        model.addAttribute("createnewuser",user);
       return "newuser";
    }
    @GetMapping("/allusers")
    public String getAllUsers(Model model){
        List<User>allusersDB = userService.allUsers();
        model.addAttribute("allusers",allusersDB);
        return "DisplayAllUser";

    }
    @RequestMapping("/save")
    public String saveUserInput( Model model,User user){
        userService.createANewUser(user);
        model.addAttribute("userInputDetails",user);
        return "creationMessage";
    }


    @RequestMapping("/edit/{userId}")
    public String updateUser(@PathVariable(name="userId")Integer userId,Model model) {
        User user = userService.findById(userId);

        if (userService.isExists(userId)==true){
             model.addAttribute("viewmodelobject",user);
            return "editPage";
        }
        else {
            return null;
        }
    }
    @RequestMapping("/submiteditedform")
    public String saveeditedform(@ModelAttribute("viewmodelobject") User user, Model model ){
        userService.createANewUser(user);
        return "userEditConfirmationPage";
    }

    @RequestMapping("/delete/{userId}")
    public String removeAUser(@PathVariable Integer userId,Model model, User user){
        user = userService.findById(userId);

        if (userService.isExists(userId)==true) {
            userService.deleteUser(userId);
            model.addAttribute("viewDeleteUser",user);
            return "deleteUserPage";
        }
        else {
            return null;
        }
    }
}
