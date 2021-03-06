package com.example.TodoTutorial.repository;

import com.example.TodoTutorial.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends CrudRepository <Todo, Long> {

}
