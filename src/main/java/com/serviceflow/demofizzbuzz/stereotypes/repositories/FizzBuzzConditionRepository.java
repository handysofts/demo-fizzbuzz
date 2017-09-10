package com.serviceflow.demofizzbuzz.stereotypes.repositories;


import com.serviceflow.demofizzbuzz.models.FizzBuzzCondition;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Vasif Mustafayev on 2017-05-08 21:45
 * vmustafayev@gmail.com
 */
public interface FizzBuzzConditionRepository extends CrudRepository<FizzBuzzCondition, Long> {

    List<FizzBuzzCondition> findByStatus(int status);

}
