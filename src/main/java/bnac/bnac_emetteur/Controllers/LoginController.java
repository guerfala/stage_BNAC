package bnac.bnac_emetteur.Controllers;

import bnac.bnac_emetteur.Entities.User;
import bnac.bnac_emetteur.Services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bnac")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @GetMapping("/login")
    public User login(@RequestParam String username, @RequestParam String password)
    {
        return loginService.login(username, password);
    }
}
