package com.yhc.leagueoflegends.service;

import com.yhc.leagueoflegends.dao.leaguedao;
import com.yhc.leagueoflegends.domain.league;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class heroService {
    @Autowired
    private leaguedao hero;

    public List<league> findAll(){
        return hero.findAll();
    }

    public league findById(String id){
        return hero.findByid(id);
    }

    public void delete(String id){
        hero.deleteById(id);
        hero.Truncate();
    }

    public league findByNickName(String nickname){
        return hero.findByNickname(nickname);
    }

    public league findByName(String name){
        return hero.findByName(name);
    }

    public List<league> findByGender(String gender){
        return hero.findByGender(gender);
    }

    public league findBySlogan(String slogan){
        return hero.findBySlogan(slogan);
    }

    public List<league> findByClassification(String classification){
        return hero.findByClassification(classification);
    }

    public List<league> findByLocationLike(String location){
        return hero.findByLocationLike(location);
    }

    public void save(league league){
        hero.saveAndFlush(league);
    }

    public void setByid(String nickname, String name, String gender, String slogan, String classification, String location, String id){
        hero.setById(nickname, name, gender, slogan, classification, location, id);
    }

    public List<league> FuzzySearch(String msg){
        return hero.FuzzySearch(msg);
    }
}

