package polytech.cinema_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import polytech.cinema_server.model.Figure;
import polytech.cinema_server.model.FigurePK;
import polytech.cinema_server.repository.FigureRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class FigureServiceImpl implements FigureService {

    private final FigureRepository figureRepository;

    @Autowired
    public FigureServiceImpl(FigureRepository figureRepository) {
        this.figureRepository = figureRepository;
    }

    @Override
    public Figure saveFigure(Figure figure) {
        return figureRepository.save(figure);
    }

    @Override
    public List<Figure> getAll() {
        return figureRepository.findAll();
    }

    @Override
    public Figure findByIdFigure(FigurePK id) throws EntityNotFoundException {
        return figureRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Figure with id " + id + " not found.")
        );
    }

    @Override
    public Figure updateByIdFigure(FigurePK id, Figure figureDetails) throws EntityNotFoundException {
        Figure figure = findByIdFigure(id);
        this.deleteByIdFigure(id);

        figure.setActor(figureDetails.getActor());
        figure.setMovie(figureDetails.getMovie());
        figure.setName(figureDetails.getName());

        return figureRepository.save(figure);
    }

    @Override
    public Figure deleteByIdFigure(FigurePK id) throws EntityNotFoundException {
        Figure figure = findByIdFigure(id);
        figureRepository.deleteById(id);
        return figure;
    }
}