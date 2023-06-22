package br.com.happycode.desafiofrete.mongo.ClienteApiTerceirosMongo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Component
public class ClienteApiTerceirosMongo {

    public DadosEnderecosDTOMongo obterDadosEnderecosDTOMongo(String cep) throws IOException, URISyntaxException {
        HttpClient httpClient = HttpClientBuilder.create().build();

        String apiUrl = "https://api-de-ceps.com/cep/";
        URI uri = new URI(apiUrl + cep);
        HttpGet httpGet = new HttpGet(uri);

        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            String responseBody = EntityUtils.toString(entity);

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(responseBody, DadosEnderecosDTOMongo.class);
        }

        return null;
    }
}
