package todolist.model;

import org.springframework.data.jpa.repository.JpaRepository;
import todolist.model.Task;

public interface TodoRepo extends JpaRepository<Task, Integer> {
}