package com.example.NoticiasAPI.controller;

import com.example.NoticiasAPI.model.NoticiasEntity;
import com.example.NoticiasAPI.service.NoticiasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/noticias")
public class NoticiasController {
    @Autowired
    NoticiasService service = new NoticiasService();
    @GetMapping("/noticiasereleases")
    public String obterTodos(){
        return service.obterTodos();
    }

    @GetMapping()
    public String obterNoticias(){
        return service.obterNoticias();
    }
    @GetMapping("/releases")
    public String obterReleases(){
        return service.obterReleases();
    }
    @PostMapping
    public NoticiasEntity inserir(@RequestBody NoticiasEntity clima){return service.inserir(clima);}
}
