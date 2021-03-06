package polytech.cinema_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import polytech.cinema_server.model.Figure;
import polytech.cinema_server.model.FigurePK;
import polytech.cinema_server.service.FigureService;

import java.util.List;

@RestController
@RequestMapping("/figure")
public class FigureController {

    private final FigureService figureService;

    @Autowired
    public FigureController(FigureService figureService) {
        this.figureService = figureService;
    }

    @PostMapping("")
    ResponseEntity<Figure> saveFigure(@RequestBody Figure figure) {
        Figure figureSaved = figureService.saveFigure(figure);
        return new ResponseEntity<>(figureSaved, HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<Figure>> getFigure() {
        List<Figure> figures = figureService.getAll();
        return new ResponseEntity<>(figures, HttpStatus.OK);
    }

    @GetMapping("/{actor}/{movie}")
    ResponseEntity<Figure> findByIdFigure(FigurePK id) {
        Figure figure = figureService.findByIdFigure(id);
        return new ResponseEntity<>(figure, HttpStatus.OK);
    }

    @PutMapping("/{actor}/{movie}")
    ResponseEntity<Figure> updateByIdFigure(FigurePK id, @RequestBody Figure figureDetails) {
        Figure figureUpdated = figureService.updateByIdFigure(id, figureDetails);
        return new ResponseEntity<>(figureUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{actor}/{movie}")
    ResponseEntity<Figure> deleteByIdFigure(FigurePK id) {
        Figure figureDeleted = figureService.deleteByIdFigure(id);
        return new ResponseEntity<>(figureDeleted, HttpStatus.OK);
    }
}

