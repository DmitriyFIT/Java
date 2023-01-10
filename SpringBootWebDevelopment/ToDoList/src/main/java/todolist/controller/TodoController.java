package todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todolist.model.Task;
import todolist.model.TodoRepo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {

    @Autowired
    private TodoRepo todoRepo;

    @RequestMapping("/")
    public String index () {
        return (new Date().toString());
    }

    @GetMapping("/tasks")
    public List<Task> findAll() {
        return todoRepo.findAll();
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> findById(@PathVariable int id) {
        if (!todoRepo.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        else {
            Optional<Task> optionalTask = todoRepo.findById(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        //return todoRepo.findById(id);
    }

    @PostMapping("/tasks")
    public ResponseEntity<Object> save(@RequestBody Task task) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        task.setCreationTime(String.valueOf(LocalDateTime.now().format(formatter)));

        double number = Math.random();
        if (number < 0.5) {
            task.setDone(true);
        }
        else {
            task.setDone(false);
        }
        todoRepo.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Object> update (@PathVariable Integer id, @RequestBody Task task) {
        if (!todoRepo.existsById(id)) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        else {
            Optional<Task> optionalTask = todoRepo.findById(id);
            Task task1 = optionalTask.get();
            task.setCreationTime(task1.getCreationTime());
            if (task.getDescription() == null) {
                task.setDescription(task1.getDescription());
            }
            if (task.getTitle() == null) {
                task.setTitle(task1.getTitle());
            }
            if (task.isDone() == task1.isDone()) {
                task.setDone(task1.isDone());
            }

            todoRepo.save(task);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping(value = "/tasks/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        if (!todoRepo.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        todoRepo.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping("/tasks")
    public void deleteAll() {
        todoRepo.deleteAll();
    }
}