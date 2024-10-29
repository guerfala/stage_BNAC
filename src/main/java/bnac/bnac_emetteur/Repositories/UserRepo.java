package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.username = :username and u.password = :password ")
    User login(@Param("username") String username, @Param("password") String password);
}
