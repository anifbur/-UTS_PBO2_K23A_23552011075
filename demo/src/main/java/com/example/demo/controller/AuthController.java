package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user,
                               @RequestParam("retypePassword") String retypePassword,
                               Model model) {

        // Cek password 
        if (!user.getPassword().equals(retypePassword)) {
            model.addAttribute("error", "Password dan konfirmasi tidak cocok!");
            return "register";
        }

        // Cek username 
        if (userRepository.findByUsername(user.getUsername()) != null) {
            model.addAttribute("error", "Username sudah digunakan.");
            return "register";
        }

        // Cek email 
        if (userRepository.findByEmail(user.getEmail()) != null) {
            model.addAttribute("error", "Email sudah digunakan.");
            return "register";
        }

        // Simpan user setelah enkripsi password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return "redirect:/login?registered";
    }
}
