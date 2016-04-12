package ru.kpfu.itis.dto;

import java.util.Date;

/**
 * Created by sanekesv on 23.03.16.
 */
public class UserDto {

    private Long id;

    private String name;

    private Date birthday;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
