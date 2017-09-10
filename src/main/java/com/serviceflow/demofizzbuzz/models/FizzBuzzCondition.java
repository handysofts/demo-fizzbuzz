package com.serviceflow.demofizzbuzz.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Vasif Mustafayev on 2017-09-10 14:36
 * vmustafayev@gmail.com
 */
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "fizz_buzz_conditions")
@Getter
@Setter
@ToString
public class FizzBuzzCondition {
    @Id
    @Column(name = "id_")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String word;

    private int divider;

    @JsonIgnore
    @Column(insertable = false)
    private int status;

    @JsonIgnore
    @Column(name = "upd_time")
    @LastModifiedDate
    private Date updTime;
}
