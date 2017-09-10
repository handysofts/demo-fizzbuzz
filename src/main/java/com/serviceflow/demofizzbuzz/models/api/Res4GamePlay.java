package com.serviceflow.demofizzbuzz.models.api;

import com.serviceflow.demofizzbuzz.models.MyError;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Vasif Mustafayev on 2017-09-09 14:54
 * vmustafayev@gmail.com
 */
@Getter
@Setter
@ToString(callSuper = true)
public class Res4GamePlay extends Res{

    private String fizzBuzzed;

    public Res4GamePlay(MyError error) {
        super(error);
    }
}
