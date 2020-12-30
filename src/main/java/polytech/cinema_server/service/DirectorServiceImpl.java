package polytech.cinema_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import polytech.cinema_server.model.Director;
import polytech.cinema_server.repository.DirectorRepository;

import javax.persistence.EntityNotFoundException;

@Service
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorServiceImpl(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public Director findByIdDirector(Integer id) throws EntityNotFoundException {
        return directorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Director with id " + id + " not found")
        );
    }
}