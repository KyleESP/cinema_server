package polytech.cinema_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import polytech.cinema_server.service.FigureService;

@RestController
@RequestMapping("/figure")
public class FigureController {

    private final FigureService figureService;

    @Autowired
    public FigureController(FigureService figureService) {
        this.figureService = figureService;
    }
}

