package com.example.reto3.Service;

import com.example.reto3.Model.Car;
import com.example.reto3.Repository.CarReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarReposiroty carReposiroty;

    public List<Car> getAll(){
        return carReposiroty.findAll();
    }

    public Optional<Car> getCar(int id){
        return carReposiroty.getCar(id);
    }

    public Car save(Car car){
        if (car.getIdCar()==null){
            return carReposiroty.save(car);
        } else{
            Optional<Car> carEncontrado = getCar(car.getIdCar());
            if (carEncontrado.isEmpty()){
                return carReposiroty.save(car);
            }else{
                return car;
            }
        }
    }

    public Car update(Car car){
        if (car.getIdCar()!= null){
            Optional<Car> carEncontrado = getCar(car.getIdCar());
            if (carEncontrado.isPresent()) {
                if (car.getBrand() != null) {
                    carEncontrado.get().setBrand(car.getBrand());
                }
                if (car.getName() !=null) {
                    carEncontrado.get().setName(car.getName());
                }
                if (car.getGama() !=null) {
                    carEncontrado.get().setGama(car.getGama());
                }
                if (car.getYear() !=null ){
                    carEncontrado.get().setYear(car.getYear());
                }
                if (car.getDescription()!=null) {
                    carEncontrado.get().setDescription(car.getDescription());
                }
                return carReposiroty.save(carEncontrado.get());
            }else{
                return car;
            }
        }else{
            return car;
        }
    }
    public boolean deleteCar(int id){
        Boolean respuesta = getCar(id).map(car -> {
            carReposiroty.delete(car);
            return true;
        }).orElse(false);
        return respuesta;
    }
}






