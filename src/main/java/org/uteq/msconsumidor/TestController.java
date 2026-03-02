package org.uteq.msconsumidor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @GetMapping("/probar-conexion")
    public String probar() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://ms-usuarios-service/api/entregas";

        try {
            String response = restTemplate.getForObject(url, String.class);
            return "Conexión Exitosa. El Microservicio Principal respondió: " + response;
        } catch (Exception e) {
            return "Error al conectar con el Microservicio Principal: " + e.getMessage();
        }
    }
}