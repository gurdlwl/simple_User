package kr.hs.dgsw.hd_web_0403.Repasitory;

import kr.hs.dgsw.hd_web_0403.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findById(String id);
}
