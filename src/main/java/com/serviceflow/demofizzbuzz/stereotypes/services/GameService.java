package com.serviceflow.demofizzbuzz.stereotypes.services;

import javax.transaction.Transactional;

/**
 * Created by Vasif Mustafayev on 2017-09-09 15:01
 * vmustafayev@gmail.com
 */
@Transactional
public interface GameService {

    String getFizzBuzzed(String numbers);

}
