package com.example.reto3.Repository;

import com.example.reto3.Model.Client;
import com.example.reto3.Model.DTOS.TotalAndClient;
import com.example.reto3.Model.Reservation;
import com.example.reto3.Repository.CRUD.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> findAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

    //Reto 5
    public List<Reservation> getReservationBetweenDates(Date fechaA, Date fechaB){
        return reservationCrudRepository.findAllByStartDateAfterAndDevolutionDateBefore(fechaA,fechaB);
    }
    public List<Reservation> getReservationByStatus(String Status){
        return reservationCrudRepository.findAllByStatus(Status);
    }
    public List<Object[]> getTotalReservationByClient(){
        return reservationCrudRepository.getTopClientsReport();
    }



}
