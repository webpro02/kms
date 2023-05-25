package com.example.demo.controller;
import com.example.demo.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
@Controller
@RequestMapping(produces = "application/json")
public class LoginController {

    LoginService  loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login/oauth2/code/{registrationId}")
    public String googleLogin(@RequestParam String code, @PathVariable String registrationId) {
        loginService.socialLogin(code, registrationId);
        return "index";
    }
    /*
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public RedirectView logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        System.out.println("abc");
        if (session != null) {
            session.invalidate(); // 세션 무효화
        }
        return new RedirectView("/", true); // 홈으로 리다이렉트
    }*/
}
