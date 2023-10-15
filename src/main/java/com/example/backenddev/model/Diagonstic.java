package com.example.backenddev.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "diagnostic")
public class Diagonstic {

    public Diagonstic() {
    }



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_diagnostique;
    @OneToMany
    @JoinColumn(name ="diagnostique_id" )
    private List<User> UserList ;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "question_diagnostique", joinColumns = {
            @JoinColumn(name = "diagnostique_id" , referencedColumnName = "id_diagnostique")
    },
            inverseJoinColumns = {
                    @JoinColumn(name = "question_id", referencedColumnName = "id_qst")
            }
    )
    private Set<Question> question ;

    public Long getId_diagnostique() {
        return id_diagnostique;
    }

    public void setId_diagnostique(Long id_diagnostique) {
        this.id_diagnostique = id_diagnostique;
    }

  
    public List<User> getUserList() {
        return UserList;
    }

    public void setUserList(List<User> userList) {
        UserList = userList;
    }

    public Set<Question> getQuestion() {
        return question;
    }

    public void setQuestion(Set<Question> question) {
        this.question = question;
    }
}
