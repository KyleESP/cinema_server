package polytech.cinema_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import polytech.cinema_server.model.Figure;
import polytech.cinema_server.model.FigurePK;
import polytech.cinema_server.service.FigureService;

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

    @GetMapping("/{id}")
    ResponseEntity<Figure> findByIdFigure(@PathVariable("id") FigurePK id) {
        Figure figure = figureService.findByIdFigure(id);
        return new ResponseEntity<>(figure, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<Figure> updateByIdFigure(@PathVariable("id") FigurePK id, @RequestBody Figure figureDetails) {
        Figure figureUpdated = figureService.updateByIdFigure(id, figureDetails);
        return new ResponseEntity<>(figureUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Figure> deleteByIdFigure(@PathVariable("id") FigurePK id) {
        Figure figureDeleted = figureService.deleteByIdFigure(id);
        return new ResponseEntity<>(figureDeleted, HttpStatus.OK);
    }
}

