package pl.flaaaxxx.springreactivestart.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.flaaaxxx.springreactivestart.entity.Student;
import pl.flaaaxxx.springreactivestart.repository.StudentRepo;
import reactor.core.publisher.Flux;

@Service
public class InitService {

    private final StudentRepo studentRepo;

    public InitService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public String get() {

        studentRepo.deleteAll()
                .thenMany(
                        Flux.just("Lukasz", "Asia", "Leon", "Zofia", "Holly"))
                .map(name ->
                        Student.builder()
                                .name(name)
                                .build())
                .flatMap(studentRepo::save)
                .thenMany(studentRepo.findAll())
                .subscribe(System.out::println);


        return "";
    }

}
