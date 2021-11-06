package com.example.examprep15oct.repository;

import com.example.examprep15oct.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndPassword(String username, String Password);

    @Query("SELECT u from User u order by size(u.orders) desc")
    List<User> findAllByOrderCountOrdersDescending();
}
