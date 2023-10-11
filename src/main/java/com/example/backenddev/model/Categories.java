package com.example.backenddev.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "categories")
public class Categories {

    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id_cat ;
    private String name ;
    private String description;
    @OneToMany
    @JoinColumn(name ="categorie")
    private List<Question> questionList ;


    public Categories() {
    }

    public Categories(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId_cat() {
        return id_cat;
    }

    public void setId_cat(Long id_cat) {
        this.id_cat = id_cat;
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

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}

