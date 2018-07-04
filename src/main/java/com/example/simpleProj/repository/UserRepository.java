package com.example.simpleProj.repository;

import com.example.simpleProj.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Kamarou_S on 04.07.2018.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
