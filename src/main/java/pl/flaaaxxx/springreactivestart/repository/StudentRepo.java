package pl.flaaaxxx.springreactivestart.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pl.flaaaxxx.springreactivestart.entity.Student;

public interface StudentRepo extends ReactiveMongoRepository<Student, String> {
}
