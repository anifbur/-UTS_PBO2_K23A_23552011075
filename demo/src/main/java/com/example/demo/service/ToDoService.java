package com.example.demo.service;

import com.example.demo.model.ToDo;
import com.example.demo.model.User;
import com.example.demo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDo> getAllTodos() {
        return toDoRepository.findAll();
    }

    public void saveTodo(ToDo todo) {
        toDoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        toDoRepository.deleteById(id);
    }

    public Optional<ToDo> getTodoById(Long id) {
        return toDoRepository.findById(id);
    }

    public List<ToDo> getCompletedTodos() {
        return toDoRepository.findByCompleted(true);
    }

    public List<ToDo> getPendingTodos() {
        return toDoRepository.findByCompleted(false);
    }

    public List<ToDo> getTodosByUser(User user) {
        return toDoRepository.findByUser(user);
    }

    public List<ToDo> getCompletedTodosByUser(User user) {
        return toDoRepository.findByUserAndCompleted(user, true);
    }

   
    public List<ToDo> getPendingTodosByUser(User user) {
        return toDoRepository.findByUserAndCompleted(user, false);
    }
}
