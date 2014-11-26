package com.myprojects.todo.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author rami
 *
 */
@Repository
public interface ToDoItemRepository extends CrudRepository<ToDoItem, Long> {

}
