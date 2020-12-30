package polytech.cinema_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import polytech.cinema_server.repository.CharacterRepository;

@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }
}