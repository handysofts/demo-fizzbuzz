package com.serviceflow.demofizzbuzz.stereotypes.services;

import com.serviceflow.demofizzbuzz.enums.Errors;
import com.serviceflow.demofizzbuzz.enums.FizzBuzzConditionStatus;
import com.serviceflow.demofizzbuzz.exceptions.IncorrectRequestException;
import com.serviceflow.demofizzbuzz.models.FizzBuzzCondition;
import com.serviceflow.demofizzbuzz.stereotypes.repositories.FizzBuzzConditionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.serviceflow.demofizzbuzz.utils.ConstantHolder.REGEX_FIZZ_BUZZ_NUMBERS;
import static com.serviceflow.demofizzbuzz.utils.ConstantHolder.SPLITTER_4_FIZZ_BUZZ_NUMBERS;

/**
 * Created by Vasif Mustafayev on 2017-09-09 15:02
 * vmustafayev@gmail.com
 */
@Service
public class GameServiceImpl implements GameService {
    private Logger logger = LoggerFactory.getLogger(GameService.class);


    private final FizzBuzzConditionRepository fizzBuzzConditionRepository;
    private Pattern patternNumbers;


    @Autowired
    public GameServiceImpl(FizzBuzzConditionRepository fizzBuzzConditionRepository) {
        this.fizzBuzzConditionRepository = fizzBuzzConditionRepository;
    }


    @PostConstruct
    public void init(){
        patternNumbers = Pattern.compile(REGEX_FIZZ_BUZZ_NUMBERS);
    }







    /**
     * Gets list of numbers and returns replaced by fizz buzz if condition meet
     *
     * @param numbers
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public String getFizzBuzzed(String numbers) {
        numbers = numbers.trim();
        if (logger.isDebugEnabled())
            logger.debug("Fizz Buzz requested {} number chain", numbers);

        if (!patternNumbers.matcher(numbers).matches())
            throw new IncorrectRequestException(Errors.INCORRECT_FIZZ_BUZZ_NUMBERS);

        List<FizzBuzzCondition> fizzBuzzConditions = fizzBuzzConditionRepository.findByStatus(FizzBuzzConditionStatus.ACTIVE.getValue());
        String[] nums = numbers.split(SPLITTER_4_FIZZ_BUZZ_NUMBERS);
        String fizzBUzzedResult = Arrays.stream(nums).map(n->{
            StringBuilder sb = new StringBuilder();
            Integer num = Integer.valueOf(n);

            fizzBuzzConditions.forEach(c->{
                if (num % c.getDivider() == 0)
                    sb.append(c.getWord());
            });

            return sb.length() > 0? sb.toString():n;
        }).collect(Collectors.joining(SPLITTER_4_FIZZ_BUZZ_NUMBERS));


        logger.info("Fizz Buzz resutl for {} number chain is {}", numbers, fizzBUzzedResult);
        return fizzBUzzedResult;
    }
}
