ToDo
====

A running sample to learn new technologies.
This is a simple TODO application for creating and maintainig a list of TODOs.
The server is created using Spring Boot.
To start the application, open a terminal or a command prompt and type 'mvn clean install sprint-boot:run', and you'll have a Jetty server listening on port 8080.

The Rest API is quite simple:
1- List all the todo items --> GET /todo
2- Find a todo item by Id --> GET /todo/id
3- Create a new todo item --> POST /todo with a json request body {"title": "ToDo title", "content": "ToDo content"}
4- Update an existing todo item --> PUT /todo with a json body {"id": 1, "title": "modified title", "content": "modified content"}
5- Delete an existing todo item by Id --> DELETE /todo/{id}

Note: I'm using an in-memory HSQL database so data is lost when shutting down the Jetty server.

