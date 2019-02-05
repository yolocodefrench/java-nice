package com.esperluette.nice.repository;

import com.esperluette.nice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(" select u from User u " +
            " where u.email = ?1")
    User findByUsername(String username);

}
