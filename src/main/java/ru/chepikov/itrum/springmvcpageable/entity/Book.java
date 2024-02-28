package ru.chepikov.itrum.springmvcpageable.entity;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.chepikov.itrum.springmvcpageable.Views;

@Entity
@Table(name = "book", schema = "public")
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Base.class)
    private Long id;
    @JsonView(Views.Base.class)
    private String name;


    @ManyToOne
    @JoinColumn(name = "author_id")

    private Author author;
}
