package ma.tp.voiture;

import ma.tp.voiture.entities.Voiture;
import ma.tp.voiture.models.Client;
import ma.tp.voiture.repositories.VoitureRepository;
import ma.tp.voiture.services.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class VoitureApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoitureApplication.class, args);
    }

    @Bean
    CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository, ClientService clientService) {
        return args -> {
            try {
                Client c1 = clientService.clientById(2L);
                Client c2 = clientService.clientById(1L);
                System.out.println("Id est :" + (c2 != null ? c2.getId() : "null"));
                System.out.println("Nom est :" + (c2 != null ? c2.getNom() : "null"));
                System.out.println("**************************");
                System.out.println("Id est :" + (c1 != null ? c1.getId() : "null"));
                System.out.println("Nom est :" + (c1 != null ? c1.getNom() : "null"));
                System.out.println("Age est :" + (c1 != null ? c1.getAge() : "null"));
                System.out.println("**************************");

                voitureRepository.save(new Voiture(null, "Toyota", "A 25 333", "Corolla", 1L, c2));
                voitureRepository.save(new Voiture(null, "Renault", "B 6 3456", "Megane", 1L, c2));
                voitureRepository.save(new Voiture(null, "Peugeot", "A 55 4444", "301", 2L, c1));
            } catch (Exception e) {
                System.err.println("Note: SERVICE-CLIENT non prêt au démarrage initial : " + e.getMessage());
                voitureRepository.save(new Voiture(null, "Toyota", "A 25 333", "Corolla", 1L, null));
                voitureRepository.save(new Voiture(null, "Renault", "B 6 3456", "Megane", 1L, null));
                voitureRepository.save(new Voiture(null, "Peugeot", "A 55 4444", "301", 2L, null));
            }
        };
    }
}

