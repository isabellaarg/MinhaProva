package com.example.NoticiasAPI.service;

import com.example.NoticiasAPI.model.NoticiasEntity;
import com.example.NoticiasAPI.repository.NoticiasRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONArray;

import java.util.List;
@Service
public class NoticiasService {
    @Autowired(required = true)
    private NoticiasRepository noticiasRepository;

    public List<NoticiasEntity> obter() {
        return noticiasRepository.findAll();
    }

   public NoticiasEntity inserir(NoticiasEntity noticia){ return noticiasRepository.save(noticia); }

    public String obterTodos() {
        String dadosNoticiasEReleases = "";
        String apiUrl = "https://servicodados.ibge.gov.br/api/v3/noticias";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Codigo de status: " + responseEntity.getStatusCode());
            dadosNoticiasEReleases = responseEntity.getBody();
        } else {
            dadosNoticiasEReleases = "Falhas ao obter as noticias e releases. Codigo de Status: " + responseEntity.getStatusCode();

        }
        return dadosNoticiasEReleases;
    }

    public String obterNoticias() {
        String apiUrl = "https://servicodados.ibge.gov.br/api/v3/noticias";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            String responseBody = responseEntity.getBody();
            NoticiasEntity noticiasEntity = new NoticiasEntity();
            noticiasEntity.setResponseBody(responseBody);
            noticiasRepository.save(noticiasEntity);
            return "Noticias salvas com sucesso";
        } else {
            return "Falha ao obter dados. Codigo de status: " + responseEntity.getStatusCode();
        }
    }

    public String obterReleases() {
        String apiUrl = "https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=release";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            String responseBody = responseEntity.getBody();
            NoticiasEntity noticiasEntity = new NoticiasEntity();
            noticiasEntity.setResponseBody(responseBody);
            noticiasRepository.save(noticiasEntity);
            return "Releases salvas com sucesso";
        } else {
            return "Falha ao obter dados. Codigo de status: " + responseEntity.getStatusCode();
        }
    }
    public NoticiasEntity inserirNoticias(NoticiasEntity dadosNoticias){
        return noticiasRepository.save(dadosNoticias);
    }
}

