package com.example.reto3.Controller;

import com.example.reto3.Model.Gama;
import com.example.reto3.Service.GamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.POST,RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Gama")
public class GamaController {
    @Autowired
    private GamaService gamaService;

    @GetMapping("/all")
    public List<Gama> getAll(){
        return gamaService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Optional<Gama> getGama(@PathVariable int id){
        return gamaService.getGama(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Gama save (@RequestBody Gama gama){
        return gamaService.save(gama);
    }

    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gama update (@RequestBody Gama gama){
        return gamaService.update(gama);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete (@PathVariable int id){
        return gamaService.deleteGama(id);
    }

}
