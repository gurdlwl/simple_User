package kr.hs.dgsw.hd_web_0403.Service;

import kr.hs.dgsw.hd_web_0403.Domain.User;

public interface UserService {
    boolean joinUser(User user);
    User getUser(String id);
    User updateUser(String id, User user);
    boolean removeUser(String id);
}
