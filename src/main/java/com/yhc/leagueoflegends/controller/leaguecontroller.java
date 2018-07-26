package com.yhc.leagueoflegends.controller;

import com.yhc.leagueoflegends.domain.league;
import com.yhc.leagueoflegends.service.heroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class leaguecontroller {
    @Autowired
    private heroService service;

    @RequestMapping("/all")
    public String all(Model model){
        List<league> heroes = service.findAll();
        model.addAttribute("heroes", heroes);
        return "all";
    }

    @RequestMapping("/search")
    public String search(Model model, String msg){
        List<league> heroes = service.FuzzySearch(msg);
        model.addAttribute("heroes", heroes);
        return "all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        service.delete(id);
        return "redirect:/all";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        league hero = service.findById(id);
        model.addAttribute("hero", hero);
        return "edit";
    }

    @RequestMapping(value = "/edit_success/{id}", method = RequestMethod.POST)
    public String edit_success(league hero, @PathVariable("id") String id){
        service.setByid(hero.getNickname(), hero.getName(), hero.getGender(), hero.getSlogan(), hero.getClassification(), hero.getLocation(), id);
        System.out.println(hero.getId());
        return "redirect:/all";
    }



    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(league hero){
        service.save(hero);
        return "redirect:/all";
    }

    @RequestMapping("/add_page")
    public String add(Model model){
        model.addAttribute("hero", new league());
        return "add_page";
    }


}
