/**
 * 
 */
package com.myprojects.todo.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.myprojects.todo.entity.ToDoItem;
import com.myprojects.todo.entity.ToDoItemRepository;

/**
 * TO DO Application Controller that handles the end points logic.
 * @author rami
 *
 */
@Controller
public class ToDoController {
    private static final Logger LOGGER = Logger.getLogger(ToDoController.class.getCanonicalName());
    @Autowired
    private ToDoItemRepository toDoItemRepository;

    @RequestMapping(value = "/todo", method = RequestMethod.GET)
    @ResponseBody
    public List<ToDoItem> getToDos() {
        LOGGER.info("Method getToDos invoked.");
        return Lists.newArrayList(toDoItemRepository.findAll());
    }

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ToDoItem getToDo(@PathVariable("id") long id) {
        LOGGER.info("Method getToDo invoked.");
        return toDoItemRepository.findOne(id);
    }

    @RequestMapping(value = "/todo", method = RequestMethod.POST)
    @ResponseBody
    public ToDoItem addToDo(@RequestBody ToDoItem newToDoItem) {
        LOGGER.info("Method addToDo invoked.");
        toDoItemRepository.save(newToDoItem);
        return newToDoItem;
    }

    @RequestMapping(value = "/todo", method = RequestMethod.PUT)
    @ResponseBody
    public ToDoItem updateToDo(@RequestBody ToDoItem modifiedToDoItem) {
        LOGGER.info("Method updateToDo invoked.");
        return toDoItemRepository.save(modifiedToDoItem);
    }

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteToDo(@RequestBody ToDoItem deletedToDoItem) {
        LOGGER.info("Method deleteToDo invoked.");
        toDoItemRepository.delete(deletedToDoItem.getId());
    }
}
