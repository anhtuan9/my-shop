package tuantienti.service;

import tuantienti.model.Users;

public interface UserService {
    boolean check(Users user);
    void save(Users user);
}
