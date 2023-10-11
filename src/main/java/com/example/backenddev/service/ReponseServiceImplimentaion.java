package com.example.backenddev.service;

import com.example.backenddev.model.Question;
import com.example.backenddev.model.Reponse;
import com.example.backenddev.model.User;
import com.example.backenddev.repository.ReponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class ReponseServiceImplimentaion  implements  ReponseService{
    @Autowired
    ReponseRepository reponseRepository;


    @Override
    public List<Reponse> getAllReponse() {
        return reponseRepository.findAll();
    }

    @Override
    public void deleteReponseByid(Long id) {
       reponseRepository.deleteById(id);
    }

    @Override
    public Reponse getReponse(Long id) {
        return reponseRepository.findById(id).get();
    }

    @Override
    public Reponse saveReponse(Reponse R) {
        return reponseRepository.save(R);
    }

    @Override
    public List<Reponse> getallreponseByid(Long id) {
        return reponseRepository.findAllById(Collections.singleton(id));
    }

    @Autowired
QuestionService  questionServicel;
    @Autowired
    ReponseService reponseService;

    User user;

    @Override
    public Double getScore(Long id) {
        double score=0;
 List<Reponse> reponseuser ;
 List<Question> questions;
 reponseuser=reponseService.getallreponseByid(id);
 questions=questionServicel.getAllQuestion();
 for(int i=0 ; i<reponseuser.size();i++){
     if (reponseuser.get(i).getResponse()==questions.get(i).getCon_vraie()){score++ ;}
 }
 return  score;}
}
