package yte.intern.spring_web;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comment {
    private Long postId;
    private Long id;
    private String name;
    private String email;
    private String body;

}
