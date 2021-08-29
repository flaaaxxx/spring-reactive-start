package pl.flaaaxxx.springreactivestart.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Builder
@Data
public class Student {

    private String id;
    private String name;
}
