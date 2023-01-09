package todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todolist.model.Task;
import todolist.model.TodoRepo;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

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
    public Optional<Task> findById(@PathVariable int id) {
        return todoRepo.findById(id);
    }

    @PostMapping
    public Task save(@RequestBody Task task) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        task.setCreationTime(String.valueOf(LocalDateTime.now().format(formatter)));

        double number = Math.random();
        if (number < 0.5) {
            task.setDone(true);
        }
        else {
            task.setDone(false);
        }
        return todoRepo.save(task);
    }

    @PatchMapping(value = "/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Task update(@PathVariable("id") @RequestBody final int id,
                                     @RequestBody final Task task) {
        return todoRepo.save(task);
    }

    @DeleteMapping(value = "/tasks/{id}")
    public void delete(@PathVariable int id) {
        todoRepo.deleteById(id);
    }

    @DeleteMapping("/tasks")
    public void deleteAll() {
        todoRepo.deleteAll();
    }
}