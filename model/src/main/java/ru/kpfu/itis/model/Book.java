package ru.kpfu.itis.model;

import javax.persistence.*;

/**
 * Created by sanekesv on 22.03.16.
 */
@Entity
@SequenceGenerator(name = "book_gen", sequenceName = "book_seq")
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_gen")
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(nullable = true, name = "author_id", referencedColumnName = "id")
    private Author author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
