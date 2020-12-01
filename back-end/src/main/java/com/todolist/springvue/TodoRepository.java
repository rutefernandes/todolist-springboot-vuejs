package com.todolist.springvue;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.springvue.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

}
