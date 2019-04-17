package kr.hs.dgsw.hd_web_0403.Service;

import kr.hs.dgsw.hd_web_0403.Domain.User;
import kr.hs.dgsw.hd_web_0403.Repasitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean joinUser(User user) {
        if(findUser(user.getId()) == true){
            this.userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User getUser(String id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUser(String id, User user) {
        return this.userRepository.findById(id).map(fu -> {
            fu.setPassword(user.getPassword());
            fu.setUsername(user.getUsername());
            fu.setEmail(user.getEmail());

            return userRepository.save(fu);
        }).orElse(null);
    }

    @Override
    public boolean removeUser(String id) {
        try{
            userRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    private boolean findUser(String id){
        if(this.userRepository.findById(id).isPresent())
            return false;
        else
            return true;
    }
}
