package br.com.portfolio.crud.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import br.com.portfolio.crud.entities.User;

@RestController
@RequestMapping(value = "/users")

public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {

        User usuario = new User(1L, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        return ResponseEntity.ok().body(usuario);
    }
}
