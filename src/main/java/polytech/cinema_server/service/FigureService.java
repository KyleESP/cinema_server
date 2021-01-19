package polytech.cinema_server.service;

import polytech.cinema_server.model.Figure;
import polytech.cinema_server.model.FigurePK;

import javax.persistence.EntityNotFoundException;

public interface FigureService {
    Figure saveFigure(Figure figure);

    Figure findByIdFigure(FigurePK id) throws EntityNotFoundException;

    Figure updateByIdFigure(FigurePK id, Figure figureDetails) throws EntityNotFoundException;

    Figure deleteByIdFigure(FigurePK id);
}