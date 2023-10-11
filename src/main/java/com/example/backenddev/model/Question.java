package com.example.backenddev.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Set;



@Entity
@Table(name = "Question")
public class Question {
    public  Question(){ super();}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_qst;

    public Question(String contenue_qst, String con_vraie) {
        super();
        this.contenue_qst = contenue_qst;
        this.con_vraie = con_vraie;
    }

    private String contenue_qst;
    private String con_vraie;


    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Categories categories;
    @ManyToMany(mappedBy = "question")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<User> users;
    @OneToMany(mappedBy = "question")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Reponse> reponse ;

    public Long getId_qst() {
        return id_qst;
    }

    public void setId_qst(Long id_qst) {
        this.id_qst = id_qst;
    }

    public String getContenue_qst() {
        return contenue_qst;
    }

    public void setContenue_qst(String contenue_qst) {
        this.contenue_qst = contenue_qst;
    }

    public String getCon_vraie() {
        return con_vraie;
    }

    public void setCon_vraie(String con_vraie) {
        this.con_vraie = con_vraie;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Reponse> getReponse() {
        return reponse;
    }

    public void setReponse(Set<Reponse> reponse) {
        this.reponse = reponse;
    }
}
