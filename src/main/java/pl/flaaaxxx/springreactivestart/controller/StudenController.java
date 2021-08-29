package pl.flaaaxxx.springreactivestart.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.flaaaxxx.springreactivestart.entity.Student;
import pl.flaaaxxx.springreactivestart.repository.StudentRepo;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class StudenController {

    private final StudentRepo studentRepo;

    public StudenController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Student> get() {
        return studentRepo.findAll().delayElements(Duration.ofSeconds(4));
    }

}
