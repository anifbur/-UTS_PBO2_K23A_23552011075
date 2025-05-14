package com.example.demo.controller;

import com.example.demo.model.ToDo;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/index")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @Autowired
    private UserRepository UserRepository;


    @GetMapping
    public String home(Model model, Principal principal) {
        String username = principal.getName();
        User user = UserRepository.findByUsername(username);

        model.addAttribute("todos", toDoService.getTodosByUser(user));
        model.addAttribute("newTodo", new ToDo());
        model.addAttribute("selectedStatus", "all");
        model.addAttribute("currentUser", user.getUsername());
        return "index";
    }

    @PostMapping("/add")
    public String addTodo(@ModelAttribute ToDo todo, Principal principal) {
        String username = principal.getName();
        User user = UserRepository.findByUsername(username);
        todo.setUser(user);
        toDoService.saveTodo(todo);
        return "redirect:/index";
    }

    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        toDoService.deleteTodo(id);
        return "redirect:/index";
    }

    @PostMapping("/update/{id}")
    public String updateTodo(@PathVariable Long id) {
        Optional<ToDo> todo = toDoService.getTodoById(id);
        todo.ifPresent(t -> {
            t.setCompleted(!t.isCompleted());
            toDoService.saveTodo(t);
        });
        return "redirect:/index";
    }

    @PostMapping("/filter")
    public String filterTodos(@RequestParam String status, Model model, Principal principal) {
        String username = principal.getName();
        User user = UserRepository.findByUsername(username);

        List<ToDo> filteredTodos;
        switch (status) {
            case "completed":
                filteredTodos = toDoService.getCompletedTodosByUser(user);
                break;
            case "pending":
                filteredTodos = toDoService.getPendingTodosByUser(user);
                break;
            default:
                filteredTodos = toDoService.getTodosByUser(user);
        }

        model.addAttribute("todos", filteredTodos);
        model.addAttribute("newTodo", new ToDo());
        model.addAttribute("selectedStatus", status);
        model.addAttribute("currentUser", user.getUsername());
        return "index";
    }

   
    @PostMapping("/isi/{id}")
    public String isiTugas(@PathVariable Long id,
                           @RequestParam("task") String isiBaru,
                           Principal principal) {
        Optional<ToDo> todoOptional = toDoService.getTodoById(id);
        if (todoOptional.isPresent()) {
            ToDo todo = todoOptional.get();
            String username = principal.getName();
            if (todo.getUser().getUsername().equals(username)) {
                todo.setTask(isiBaru);
                toDoService.saveTodo(todo);
            }
        }
        return "redirect:/index";
    }

    
    @PostMapping("/edit/{id}")
    public String editTugas(@PathVariable Long id,
                            @RequestParam("task") String isiBaru,
                            Principal principal) {
        Optional<ToDo> todoOptional = toDoService.getTodoById(id);
        if (todoOptional.isPresent()) {
            ToDo todo = todoOptional.get();
            String username = principal.getName();
            if (todo.getUser().getUsername().equals(username)) {
                todo.setTask(isiBaru);
                toDoService.saveTodo(todo);
            }
        }
        return "redirect:/index";
    }
    @PostMapping("/detail/{id}")
public String updateDetail(@PathVariable Long id, @RequestParam("detail") String detail) {
    Optional<ToDo> todoOpt = toDoService.getTodoById(id);
    todoOpt.ifPresent(todo -> {
        todo.setDetail(detail);
        toDoService.saveTodo(todo);
    });
    return "redirect:/index";
}
}
