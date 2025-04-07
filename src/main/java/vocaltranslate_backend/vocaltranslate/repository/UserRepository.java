package vocaltranslate_backend.vocaltranslate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vocaltranslate_backend.vocaltranslate.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
