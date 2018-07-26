package com.yhc.leagueoflegends.dao;


import com.yhc.leagueoflegends.domain.league;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface leaguedao extends JpaRepository<league, String> {
    @Query("select l from league l where l.id = :id")
    league findByid (@Param("id") String id);

//    @Query("select l from league l where l.nickname = :nickname")
    league findByNickname(@Param("nickname") String nickname);
//
//    @Query("select l from league l where l.name = :name")
    league findByName(@Param("name") String name);
//
//    @Query("select l from league l where l.gender = :gender")
    List<league> findByGender(@Param("gender") String gender);
//
//    @Query("select l from league l where l.slogan = :slogan")
    league findBySlogan(@Param("slogan") String slogan);
//
//    @Query("select l from league l where l.classification like %:classification%")
    List<league> findByClassification(@Param("classification") String classification);

    @Query("select l from league l where l.location like %:location%")
    List<league> findByLocationLike(@Param("location") String location);

    @Query("select l from league l where l.nickname like %:msg% or l.name like %:msg% or l.slogan like %:msg%")
    List<league> FuzzySearch(@Param("msg") String msg);

    @Query("truncate table league")
    void Truncate();

    @Transactional
    @Modifying
    @Query("update league set nickname=:nickname, name=:name, gender=:gender, slogan=:slogan, classification=:classification, location=:location where id=:id")
    void setById (@Param("nickname") String nickname, @Param("name") String name, @Param("gender") String gender, @Param("slogan") String slogan, @Param("classification") String classification, @Param("location") String location, @Param("id") String id);
}
