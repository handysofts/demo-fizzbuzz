package com.serviceflow.demofizzbuzz.services;

import com.serviceflow.demofizzbuzz.enums.Errors;
import com.serviceflow.demofizzbuzz.exceptions.IncorrectRequestException;
import com.serviceflow.demofizzbuzz.stereotypes.services.GameService;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Vasif Mustafayev on 2017-09-10 17:23
 * vmustafayev@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class GameServiceTest {

    @Autowired private GameService gameService;

    @Rule
    public ExpectedException exception = ExpectedException.none();


    @Test
    public void normalPlay(){
        String fizzedBuzzedRes = gameService.getFizzBuzzed("1,2,3,5,10,15,16");
        Assert.assertEquals("1,2,fizz,buzz,buzz,fizzbuzz,16", fizzedBuzzedRes);
    }


    @Test
    public void wrongCharacterPlay(){
        exception.expect(IncorrectRequestException.class);
        exception.expectMessage(Errors.INCORRECT_FIZZ_BUZZ_NUMBERS.getText());

        gameService.getFizzBuzzed("1,3,a,5");
    }

}
