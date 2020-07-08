package com.example.TodoTutorial.controller;

import com.example.TodoTutorial.dto.SuccessfulResponseDetail;
import com.example.TodoTutorial.model.Todo;
import com.example.TodoTutorial.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(method = RequestMethod.GET, value = "/todos")
    public ResponseEntity getAllTodos(){
        List<Todo> todos = todoService.getTodos();
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.OK.value(), "Todos have been retrived", todos);
        return new ResponseEntity(successfulResponseDetail, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/todos/{id}")
    public Optional<Todo> getTodoById(Long id){
        return todoService.getTodoById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/todos")
    public void addTodo(@RequestBody Todo todo){
        todoService.addTodo(todo);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/todos/{id}")
    public void updateTodo(@RequestBody Todo todo, @PathVariable Long id){
        todoService.updateTodo(todo, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/todos/{id}")
    public void deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
    }
}
