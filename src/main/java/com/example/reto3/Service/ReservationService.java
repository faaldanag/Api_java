package com.example.reto3.Service;

import com.example.reto3.Model.Client;
import com.example.reto3.Model.DTOS.CompletedAndcancelled;
import com.example.reto3.Model.DTOS.TotalAndClient;
import com.example.reto3.Model.Reservation;
import com.example.reto3.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation reservation){
        if (reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        } else{
            Optional<Reservation> reservationEncontrado = getReservation(reservation.getIdReservation());
            if (reservationEncontrado.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation){
        if (reservation.getIdReservation()!= null){
            Optional<Reservation> reservationEncontrado = getReservation(reservation.getIdReservation());
            if (reservationEncontrado.isPresent()) {
                if (reservation.getStartDate() != null) {
                    reservationEncontrado.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    reservationEncontrado.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    reservationEncontrado.get().setStatus(reservation.getStatus());
                }
                return reservationRepository.save(reservationEncontrado.get());
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
    public boolean deleteReservation(int id){
        Boolean respuesta = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return respuesta;
    }
    // Reto 5

    public List<Reservation> getReservartionBetweenDatesReport(String fechaA,String fechaB){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

        Date a = new Date();
        Date b = new Date();
        try{
            a = parser.parse(fechaA);
            b = parser.parse(fechaB);

        }catch (ParseException exception){
            exception.printStackTrace();
        }
        if (a.before(b)){
            return reservationRepository.getReservationBetweenDates(a,b);
        }else{
            return new ArrayList<>();
        }
    }

    public CompletedAndcancelled getReservationStatusReport(){
        List<Reservation> completed = reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");

        Long cantidadCompletada = (long) completed.size();
        Long cantidadCancelada = (long) cancelled.size();

        CompletedAndcancelled respuesta = new CompletedAndcancelled(cantidadCompletada,cantidadCancelada);
        return respuesta;
    }

    public List<TotalAndClient> getTopClientsReport(){
        List<TotalAndClient> respuesta = new ArrayList<>();
        List<Object[]> reporte = reservationRepository.getTotalReservationByClient();
        for (Object[] pareja : reporte) {
            Client client = (Client) pareja[0];
            Long total = (Long) pareja[1];

            TotalAndClient totalAndClient = new TotalAndClient(total,client);
            totalAndClient.setTotal(total);
            totalAndClient.setClient(client);

            respuesta.add(totalAndClient);
        }
        return respuesta;
    }
}
