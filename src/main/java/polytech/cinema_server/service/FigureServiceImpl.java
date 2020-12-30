package polytech.cinema_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import polytech.cinema_server.repository.FigureRepository;

@Service
public class FigureServiceImpl implements FigureService {

    private final FigureRepository figureRepository;

    @Autowired
    public FigureServiceImpl(FigureRepository figureRepository) {
        this.figureRepository = figureRepository;
    }
}