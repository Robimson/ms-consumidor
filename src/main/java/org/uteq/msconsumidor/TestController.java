package org.uteq.msconsumidor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*")
public class TestController {

    @GetMapping("/")
    public String home() {
        return "Servidor Consumidor Activo. <br> Entra a <a href='/index.html'>/index.html</a> para ver la interfaz.";
    }

    @GetMapping("/api/consumir-datos")
    public String obtenerDatos() {
        RestTemplate restTemplate = new RestTemplate();
        // Usamos el nombre del servicio del Microservicio A
        String url = "http://ms-usuarios-service/api/entregas";
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            return "{\"error\": \"No se pudo conectar con el Microservicio Principal: " + e.getMessage() + "\"}";
        }
    }
}