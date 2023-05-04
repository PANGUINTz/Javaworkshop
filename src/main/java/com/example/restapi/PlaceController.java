package com.example.restapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PlaceController {
    @GetMapping ("/place")
    Place getPlace(){
        RestTemplate rt = new RestTemplate();
        Place p = rt.getForObject(
                "https://maps.googleapis.com/maps/api/place/details/json?fields=name,rating,adr_address,formatted_phone_number&place_id=ChIJub5EgZ2e4jARLaoj7sHy4GY&key=AIzaSyCWQ8-0rah_yBB8k8OkwSj1Ut2W4zoi_8w",
                Place.class);
        return p;
    }

    @GetMapping("/place2")
    String getPlace2() throws JsonProcessingException {
        RestTemplate rt = new RestTemplate();
        String url = "https://maps.googleapis.com/maps/api/place/details/json?fields=name,rating,adr_address,formatted_phone_number&place_id=ChIJub5EgZ2e4jARLaoj7sHy4GY&key=AIzaSyCWQ8-0rah_yBB8k8OkwSj1Ut2W4zoi_8w";
        ResponseEntity<String> res= rt.getForEntity(url, String.class);
        System.out.println("status -->" + res.getStatusCode());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(res.getBody());
        JsonNode name = root.path("result");
        return name.toString();
    }

    @GetMapping("/emp")
    String getEmp() throws JsonProcessingException {
        RestTemplate rt = new RestTemplate();
        String url = "http://localhost:9000/employees";
        HttpEntity<Employee> request = new HttpEntity<Employee>(new Employee("Pete Sampras","CTO"));
        Employee emp = rt.postForObject(url, request, Employee.class);

        return "Add Employee Successfully!";
    }

}
