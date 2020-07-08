package com.example.TodoTutorial.service;

import com.example.TodoTutorial.model.Todo;
import com.example.TodoTutorial.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepoo;


    public List<Todo> getTodos(){
        List<Todo> todos = new ArrayList<>();
        todoRepoo.findAll().forEach(todos::add);
        return todos;
    }

    public Optional<Todo> getTodoById(Long id){
        return todoRepoo.findById(id);
    }


    public void addTodo(Todo todo){
        todoRepoo.save(todo);
    }

    public void updateTodo(Todo todo, Long id){
        for (Todo todo1: todoRepoo.findAll()){
            if (todo1.getId().equals(id)){
                todoRepoo.save(todo);
            }
        }
    }

    public void deleteTodo(Long id){
        todoRepoo.deleteById(id);
    }













}
