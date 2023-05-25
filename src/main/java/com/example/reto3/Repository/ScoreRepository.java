package com.example.reto3.Repository;

import com.example.reto3.Model.Score;
import com.example.reto3.Repository.CRUD.ScoreCrudReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudReservation scoreCrudReservation;

    public List<Score> findAll(){
        return (List<Score>) scoreCrudReservation.findAll();
    }
    public Optional<Score> getScore(int id){
        return scoreCrudReservation.findById(id);
    }
    public Score save(Score score){
        return scoreCrudReservation.save(score);
    }
    public void delete(Score score){
        scoreCrudReservation.delete(score);
    }
}
