package com.example.demo.domain;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="members")
@Data
@NamedEntityGraph(
        name = "member_with_all_associations",
        includeAllAttributes = true
)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String birthday;
    private String programming;
    private String hobby;
    @Column(name="division_id")
    private Integer division_id;
    private Timestamp created_at;
    private Timestamp updated_at;

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "id", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private Division division;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday){
        this.birthday = new SimpleDateFormat("yyyy-MM-dd").format(birthday);
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

    public Integer getDivision_id() {
        return division_id;
    }

    public void setDivision_id(Integer division_id) {
        this.division_id = division_id;
    }

    public Timestamp getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
