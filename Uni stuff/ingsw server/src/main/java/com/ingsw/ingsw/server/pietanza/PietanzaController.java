package com.ingsw.ingsw.server.pietanza;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/pietanza")
public class PietanzaController {
    private final PietanzaService pietanzaService;

    @Autowired
    public PietanzaController(PietanzaService pietanzaService) {
        this.pietanzaService = pietanzaService;
    }

    @GetMapping
    public List<Pietanza> getPietanze() { return pietanzaService.getPietanze();}

    @PostMapping
    public void addNewPietanza(@RequestBody Pietanza pietanza) { pietanzaService.addNewPietanza(pietanza);}

    @PutMapping
    public void updatePietanza(@RequestBody Pietanza pietanza) {pietanzaService.updatePietanza(pietanza);}

    @DeleteMapping(path = "delete/{pietanzaId}")
    public void deletePietanza(@PathVariable("pietanzaId") Long pietanzaId){
        pietanzaService.deletePietanza(pietanzaId);
    }
}
