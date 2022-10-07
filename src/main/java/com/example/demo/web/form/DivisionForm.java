package com.example.demo.web.form;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.sql.Time;
import java.sql.Timestamp;

public class DivisionForm {

    private Integer id;
    @NotBlank
    @Length(max=32)
    private String name;
    private Timestamp created_at;
    private Timestamp updated_at;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }
}
