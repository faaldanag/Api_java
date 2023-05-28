package com.example.reto3.Repository.CRUD;

import com.example.reto3.Model.Reservation;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {

    //Reporte 1
    //select * from reservation where startDate AFTER fechaA AND devolutionDate BEFORE fechaB
    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date fechaA,Date fechaB);
    //Reporte 2
    //SELECT * FROM Reservation where status = "valorNecesito"
    public List<Reservation> findAllByStatus(String status);
    //Reporte 3
    // SELECT cliente,COUNT(client) FROM Reservation GROUP BY client Order by COUNT(client) DESC;
    //Lista de pareja de 2 valores
    //
    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c GROUP BY c.client order by  COUNT(c.client) DESC")
    public List<Object[]> getTopClientsReport();


}
