package com.ingsw.ingsw.server.utente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(path = "api/v1/utente")
public class UtenteController {
    private final UtenteService utenteService;

    @Autowired
    public UtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @GetMapping()
    public List<Utente> getUtente() {
        return utenteService.getUtente();
    }

    @PostMapping()
    public ResponseEntity registerNewUtente(@RequestBody Utente utente) {
        HttpStatus stat= HttpStatus.OK;;
        try {
            utenteService.addNewUtente(utente);
        } catch (DataIntegrityViolationException e){
            stat = HttpStatus.BAD_REQUEST;
        }
        System.out.println("ritorno:"+stat.toString());
        return new ResponseEntity(stat);
    }

    @DeleteMapping(path = "{utenteId}")
    public void deleteUtente(@PathVariable("utenteID") Long utenteId){
        utenteService.deleteUtente(utenteId);
    }

    @GetMapping(path = "/auth")
    public ResponseEntity<String> authUtente(@RequestParam String username, @RequestParam String password){
        Utente auth = utenteService.authenticateUtente(username,password);

        if (auth == null)
        {
            return new ResponseEntity<String>("user not found",HttpStatus.NOT_FOUND);
        }
        else{
            HttpHeaders responseHeaders= new HttpHeaders();
            responseHeaders.set("ruolo",auth.getRuolo().toString());
            responseHeaders.set("primo_accesso", String.valueOf(auth.isFirstAccess()));
            responseHeaders.set("id", auth.getId().toString());
            System.out.print(responseHeaders.toString());
            return new ResponseEntity<String>(responseHeaders, HttpStatus.OK);
        }

    }

    @GetMapping(path = "/init")
    public ResponseEntity<String> checkInit(){
        List<Utente> Utenti= utenteService.getUtente();
        if (Utenti.isEmpty())
        {
            return new ResponseEntity<>("user not found",HttpStatus.NOT_FOUND);
        }
        else return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping(path ="/firstupdate")
    public void updateAfterFirstAccess(@RequestBody Utente updatedUser){
        updatedUser.setFirstAccess(false);
        utenteService.updateAfterFirstAccess(updatedUser);

    }
}
