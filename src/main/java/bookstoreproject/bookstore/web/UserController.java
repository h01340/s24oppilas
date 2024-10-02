package bookstoreproject.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.*;
import bookstoreproject.bookstore.domain.AppUser;
import bookstoreproject.bookstore.domain.AppUserRepository;
import bookstoreproject.bookstore.domain.SignUpForm;

@Controller
public class UserController {

    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping("/signup")
    public String addUser(Model model) {
        model.addAttribute("signupform", new SignUpForm());
        return "signup";
    }

    @PostMapping("/saveuser")
    public String save(@Valid @ModelAttribute("signupform") SignUpForm signUpForm, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if (signUpForm.getPassword().equals(signUpForm.getPasswordCheck())) {
                String pw = signUpForm.getPassword();
                BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
                String hashPassword = bc.encode(pw);

                AppUser newUser = new AppUser();
                newUser.setPasswordHash(hashPassword);
                newUser.setUsername(signUpForm.getUsername());
                newUser.setRole("USER");

                if (appUserRepository.findByUsername(signUpForm.getUsername()) == null) {
                    appUserRepository.save(newUser);
                } else {
                    bindingResult.rejectValue("username", "err.username", "Username already exists");
                    return "signup";
                }
            } else {
                bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords do not match");
                return "signup";
            }
        } else {
            return "signup";
        }
        return "redirect:/login";
    }
}
