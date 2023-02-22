package gustavo.com.api.services.impl;

import gustavo.com.api.domain.User;
import gustavo.com.api.domain.dto.UserDTO;
import gustavo.com.api.repositories.UserRepository;
import gustavo.com.api.services.UserService;
import gustavo.com.api.services.exceptions.DataIntegratyVaiolationException;
import gustavo.com.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, User.class));
    }

    private void findByEmail(UserDTO obj) {
        Optional<User> user = repository.findByEmail(obj.getEmail());
        if (user.isPresent()) {
            throw new DataIntegratyVaiolationException("E-mail ja cadastrado no sistema");
        }
    }

}
