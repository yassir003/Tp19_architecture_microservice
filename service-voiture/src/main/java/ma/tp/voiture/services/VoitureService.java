package ma.tp.voiture.services;

import ma.tp.voiture.entities.Voiture;
import ma.tp.voiture.repositories.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoitureService {

    @Autowired
    private VoitureRepository voitureRepository;

    public Voiture enregistrerVoiture(Voiture voiture) {
        return voitureRepository.save(voiture);
    }

    public List<Voiture> findAll() {
        return voitureRepository.findAll();
    }
}

