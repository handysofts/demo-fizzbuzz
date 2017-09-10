package com.serviceflow.demofizzbuzz.stereotypes.controllers.api;

import com.serviceflow.demofizzbuzz.enums.Errors;
import com.serviceflow.demofizzbuzz.models.MyError;
import com.serviceflow.demofizzbuzz.models.api.Res;
import com.serviceflow.demofizzbuzz.models.api.Res4GamePlay;
import com.serviceflow.demofizzbuzz.stereotypes.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vasif Mustafayev on 2017-09-09 14:52
 * vmustafayev@gmail.com
 */
@RestController
@RequestMapping("/api/v1/game")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }


    /**
     * Gets number as 1,2,3,4,5 and returns fizz buzzed data
     *
     * @param request
     * @param numbers - number or comma separated numbers
     * @return
     */
    @GetMapping(value = "/play/numbers/{numbers}")
    public Res play(HttpServletRequest request, @PathVariable String numbers){

        Res4GamePlay res = new Res4GamePlay(new MyError(Errors.OK));
        res.setFizzBuzzed(gameService.getFizzBuzzed(numbers));
        return res;
    }

}
