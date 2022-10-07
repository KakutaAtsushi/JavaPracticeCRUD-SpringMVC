package com.example.demo.web.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.text.ParseException;

@Data
public class MemberForm {

    private Integer id;
    @NotBlank
    @Length(max=20)
    private String name;

    private String birthday;

    @NotBlank
    @Length(max=20)
    private String hobby;

    @NotBlank
    @Length(max=20)
    private String programming;

    @NotNull
    private Integer division_id;

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

    public void setBirthday(String birthday) throws ParseException {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getProgramming() {
        return programming;
    }


    public void setProgramming(String programming_language) {
        this.programming = programming_language;
    }


    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getHobby() {
        return hobby;
    }

    public void setDivision_id(Integer division_id) {
        this.division_id = division_id;
    }

    public Integer getDivision_id() {
        return division_id;
    }
}
