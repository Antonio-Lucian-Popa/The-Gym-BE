package com.asusoftware.Backend.The.Gym.user.repository;

import com.asusoftware.Backend.The.Gym.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
