package yte.intern.spring_web;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {

    private Long userId;
    private Long id;
    private String title;
    private String body;
}
