package yte.intern.spring_data;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String author;
    private Long age;
    private LocalDateTime publishDate;

}
