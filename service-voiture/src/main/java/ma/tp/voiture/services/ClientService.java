package ma.tp.voiture.services;

import ma.tp.voiture.models.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SERVICE-CLIENT")
public interface ClientService {

    @GetMapping(path = "/client/{id}")
    Client clientById(@PathVariable("id") Long id);
}

