package com.example.demo.repository;

import com.example.demo.model.ToDo;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {

    // Find all todos by completion status
    List<ToDo> findByCompleted(boolean completed);

    // Find all todos for a specific user
    List<ToDo> findByUser(User user);

    // Find todos by user and completion status
    List<ToDo> findByUserAndCompleted(User user, boolean completed);

    // Additional useful query: find todos by user ID
    List<ToDo> findByUserId(Long userId);

    // Additional query: find completed/incomplete todos by user ID
    List<ToDo> findByUserIdAndCompleted(Long userId, boolean completed);

}