package com.pizzaselle.Pizza.controller;

import java.io.FileNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pizzaselle.Pizza.Interface.PizzaInterface;
import com.pizzaselle.Pizza.Service.PizzaService;
import com.pizzaselle.Pizza.model.Pizza;

import net.sf.jasperreports.engine.JRException;

@RestController
public class PizzerController {
	
@Autowired
 private PizzaService service ;
@Autowired
private final PizzaInterface pizzaInterface ;

public PizzerController(PizzaInterface pizzaInterface) {
	this.pizzaInterface=pizzaInterface;
}
@GetMapping(path = "/pizza/all")
public List<Pizza> showAllPizza(){
    return pizzaInterface.findAll();
}

@PostMapping(path = "/pizza/create")
public ResponseEntity<String> createPizza(@RequestBody List<Pizza> pizzas) {
    for (Pizza pizza : pizzas) {
        int totalPrice = pizza.getQuantity() * pizza.getPrice();
        pizza.setTotal(totalPrice);
        pizzaInterface.save(pizza);
    }

    return ResponseEntity.ok("Pizzas created successfully");
}


@GetMapping("/report/{format}")
public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
	return service.exportReport(format);
}

}
