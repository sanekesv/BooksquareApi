package ru.kpfu.itis.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by sanekesv on 23.03.16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDto {

    private Long id;

    private String name;

    private String description;

    public AuthorDto author;

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

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }
}
