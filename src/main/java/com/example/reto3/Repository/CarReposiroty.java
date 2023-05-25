package com.example.reto3.Repository;

import com.example.reto3.Model.Car;
import com.example.reto3.Repository.CRUD.carCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class CarReposiroty {
    @Autowired
    private carCrudRepository carCrudRepository;
    public List<Car> findAll(){
        return (List<Car>) carCrudRepository.findAll();
    }

    public Optional<Car> getCar(int id){
        return carCrudRepository.findById(id);
    }
    public Car save(Car car){
        return carCrudRepository.save(car);
    }
    public void delete(Car car){
         carCrudRepository.delete(car);
    }
}
