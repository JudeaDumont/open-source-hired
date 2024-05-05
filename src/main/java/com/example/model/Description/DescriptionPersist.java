package com.example.model.Description;

import com.example.model.ID;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;

@Entity
@Table(appliesTo = "Description")
public class DescriptionPersist implements ID {

    @Id
    @SequenceGenerator(
            name = "description_sequence",
            sequenceName = "description_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "description_sequence"
    )
    private Long id;
    private String name;
    private String content;

    public DescriptionPersist() {
    }

    public DescriptionPersist(
            @JsonProperty("id") Long id,
            @JsonProperty("name") String name,
            @JsonProperty("content") String content) {
        this.id = id;
        this.content = content;
        this.name = name;
    }

    public DescriptionPersist(ResultSet resultSet) throws SQLException {
        setId(resultSet.getLong("id"));
        setName(resultSet.getString("name"));
        setContent(resultSet.getString("content"));
    }

    @Column
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column
    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
