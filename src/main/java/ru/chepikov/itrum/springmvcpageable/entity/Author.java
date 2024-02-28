package ru.chepikov.itrum.springmvcpageable.entity;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.chepikov.itrum.springmvcpageable.Views;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author", schema = "public")
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Base.class)
    private Long id;
    @JsonView(Views.Base.class)
    private String name;

    @OneToMany(mappedBy = "author")
    @JsonView(Views.Base.class)
    private List<Book> bookList = new ArrayList<>();
}
