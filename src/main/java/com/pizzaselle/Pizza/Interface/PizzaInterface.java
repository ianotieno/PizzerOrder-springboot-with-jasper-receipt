package com.pizzaselle.Pizza.Interface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzaselle.Pizza.model.Pizza;

public interface PizzaInterface extends JpaRepository<Pizza,Integer>{

}
