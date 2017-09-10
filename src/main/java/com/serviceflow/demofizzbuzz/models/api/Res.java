package com.serviceflow.demofizzbuzz.models.api;

import com.serviceflow.demofizzbuzz.models.MyError;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Res implements Serializable {

    private MyError error;

    public Res(MyError error) {
        super();
        this.error = error;
    }

}
