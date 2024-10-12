package ru.clevertec.clevertecvideohostingchannelapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.clevertec.clevertecvideohostingchannelapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
