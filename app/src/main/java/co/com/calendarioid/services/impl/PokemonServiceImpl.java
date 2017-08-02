package co.com.calendarioid.services.impl;

import org.json.JSONObject;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import co.com.calendarioid.persistence.model.Pokemon;
import co.com.calendarioid.services.iface.IPokemonService;

/**
 * Created by desarrollo on 04/07/2017.
 */

public class PokemonServiceImpl implements IPokemonService {

    public Pokemon pruebaWebService(Pokemon entidad) throws Exception {

        //Prueba
        String urlString = "http://pokeapi.co/api/v2/pokemon-form/1/";

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new FormHttpMessageConverter());
        messageConverters.add(new StringHttpMessageConverter());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(messageConverters);
        String result = restTemplate.getForObject(urlString, String.class);

        JSONObject respJSON = new JSONObject(result);
        String nombrePoke = respJSON.getString("name");
        String orden = respJSON.getString("order");
        Pokemon pokemon = new Pokemon();
        pokemon.setDescripcion(nombrePoke);
        pokemon.setId(Integer.valueOf(orden));

        return pokemon;
    }
}
