package bnac.bnac_emetteur.Services;

import bnac.bnac_emetteur.Entities.User;
import bnac.bnac_emetteur.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepo userRepo;

    public User login(String username, String password)
    {
        return userRepo.login(username, password);
    }
}
