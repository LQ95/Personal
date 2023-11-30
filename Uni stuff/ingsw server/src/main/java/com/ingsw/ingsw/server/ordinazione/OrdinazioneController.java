package com.ingsw.ingsw.server.ordinazione;

import com.ingsw.ingsw.server.pietanza.Pietanza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "api/v1/ordinazione")
public class OrdinazioneController {
    private final OrdinazioneService ordinazioneService;
    @Autowired
    public OrdinazioneController(OrdinazioneService ordinazioneService) { this.ordinazioneService = ordinazioneService;}

    @GetMapping()
    public List<Ordinazione> getOrdinazione() { return ordinazioneService.getOrdinazione(); }

    @PostMapping()
    public void registerNewOrdinazione(@RequestBody Ordinazione ordinazione) { ordinazioneService.addNewOrdinazione(ordinazione);}

    @DeleteMapping(path = "{ordinazioneId}")
    public void deleteOrdinazione(@PathVariable("ordinazioneId") Long ordinazioneId) { ordinazioneService.deleteOrdinazione(ordinazioneId);}

    @PostMapping(path = "/addpietanza")
    public ResponseEntity<String> addPietanzaToOrdinazione(@RequestParam Long pietanzaId,@RequestParam Long OrdinazId)
    {
        try {
            ordinazioneService.addPietanzaToOrdinazione(pietanzaId, OrdinazId);
            return new ResponseEntity<>("Ordinazione aggiunta con successo", HttpStatus.OK);
        }
        catch (RuntimeException  e) {
            return new ResponseEntity<>("Ordinazione non è stata aggiunta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{ordinazioneId}/pietanze")
    public List<Pietanza> getPietanzeByOrdinazioneId(@PathVariable("ordinazioneId") Long ordinazioneId) {
        Ordinazione ordinazione = ordinazioneService.getOrdinazioneById(ordinazioneId);
        return ordinazione.getPietanze();
    }


    @DeleteMapping(path = "/deletefrom{ordinazioneId}")
    public void deletePietanzaFromOrdinazione(@PathVariable("ordinazioneId") Long ordinazioneId,@RequestParam Long pietanzaId)
    {
        ordinazioneService.deletePietanzaFromOrdinazione(pietanzaId,ordinazioneId);
    }

    @GetMapping(path = "/getcurrent")
    public Ordinazione getCurrentOrdinazione(@RequestParam Long tavoloId){

        return ordinazioneService.getCurrentOrdinazione(tavoloId);
    }
    @PutMapping(path = "/closecurrent")
    public void closeCurrentOrdinazione(@RequestParam Long tavoloId){

        ordinazioneService.closeCurrentOrdinazione(tavoloId);
    }

    //Funzione per inviare i dati delle statistiche

    @GetMapping("/statistiche-ordinazioni-chiuse")
    public ResponseEntity<Map<Date, List<Float>>> getClosedOrdinazioni() {
        List<Ordinazione> closedOrdinazioni = ordinazioneService.getOrdinazione().stream()
                .filter(ordinazione -> !ordinazione.getAperta())
                .toList();

        Map<Date, List<Float>> dateAndPrices = new HashMap<>();
        for (Ordinazione ordinazione : closedOrdinazioni) {
            Date data = ordinazione.getData();
            Float conto = ordinazione.getConto();

            if (dateAndPrices.containsKey(data)) {
                List<Float> prices = dateAndPrices.get(data);
                prices.add(conto);
            } else {
                List<Float> prices = new ArrayList<>();
                prices.add(conto);
                dateAndPrices.put(data, prices);
            }
        }

        return new ResponseEntity<>(dateAndPrices, HttpStatus.OK);
    }


    @GetMapping("/statistiche-ordinazioni-by-date")
    public ResponseEntity<Map<Date, List<Float>>> getClosedOrdinazioni(
            @RequestParam("dataInizio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataInizio,
            @RequestParam("dataFine") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataFine) {

        List<Ordinazione> closedOrdinazioni = ordinazioneService.getOrdinazione().stream()
                .filter(ordinazione -> !ordinazione.getAperta())
                .filter(ordinazione -> ordinazione.getData().compareTo(dataInizio) >= 0 && ordinazione.getData().compareTo(dataFine) <= 0)
                .toList();

        Map<Date, List<Float>> dateAndPrices = new HashMap<>();
        for (Ordinazione ordinazione : closedOrdinazioni) {
            Date data = ordinazione.getData();
            Float conto = ordinazione.getConto();

            if (dateAndPrices.containsKey(data)) {
                List<Float> prices = dateAndPrices.get(data);
                prices.add(conto);
            } else {
                List<Float> prices = new ArrayList<>();
                prices.add(conto);
                dateAndPrices.put(data, prices);
            }
        }

        return new ResponseEntity<>(dateAndPrices, HttpStatus.OK);
    }


}
