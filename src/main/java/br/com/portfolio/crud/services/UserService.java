package br.com.portfolio.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.portfolio.crud.entities.User;
import br.com.portfolio.crud.repositories.UserRepository;
import br.com.portfolio.crud.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> usuario = repository.findById(id);
        return usuario.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User usuario) {
        return repository.save(usuario);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public User update(Long id, User usuario) {
        User cadastro = repository.getReferenceById(id);
        updateData(cadastro, usuario);
        return repository.save(cadastro);
    }

    private void updateData(User cadastro, User usuario) {
        cadastro.setName(usuario.getName());
        cadastro.setEmail(usuario.getEmail());
        cadastro.setTelefone(usuario.getTelefone());
    }
}
