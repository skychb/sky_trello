package com.example;

import org.springframework.data.repository.CrudRepository;

import com.example.Card;

public interface CardRepository extends CrudRepository<Card, Long> {

}
