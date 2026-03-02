package org.uteq.msconsumidor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*")
public class TestController {


    @GetMapping("/api/consumir-datos")
    public String obtenerDatos() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://ms-usuarios-service/api/entregas";
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            return "{\"error\": \"No se pudo conectar: " + e.getMessage() + "\"}";
        }
    }
}