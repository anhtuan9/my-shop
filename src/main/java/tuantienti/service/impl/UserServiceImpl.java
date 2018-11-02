package tuantienti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import tuantienti.model.Users;
import tuantienti.repository.UserRepository;
import tuantienti.service.UserService;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public boolean check(Users user) {
        Iterable<Users> danhsach = userRepository.findAll();
        for (Users a:danhsach) {
            if (a.getAcc().equals(user.getAcc())&& a.getPass().equals(user.getPass())){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    @Override
    public void save(Users user) {
        userRepository.save(user);
    }
}
