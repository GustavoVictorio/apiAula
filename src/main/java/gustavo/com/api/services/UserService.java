package gustavo.com.api.services;

import gustavo.com.api.domain.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();

}
