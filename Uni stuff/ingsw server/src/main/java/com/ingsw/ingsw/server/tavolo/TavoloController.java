package com.ingsw.ingsw.server.tavolo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/tavolo")
public class TavoloController {
    private final TavoloService tavoloService;

    @Autowired
    public TavoloController(TavoloService tavoloService) { this.tavoloService = tavoloService;}

    @GetMapping()
    public List<Tavolo> getTavolo() { return tavoloService.getTavolo();}

    @PostMapping
    public void registerNewTavolo(@RequestBody Tavolo tavolo) { tavoloService.addNewTavolo(tavolo);}

    @DeleteMapping(path = "{tavoloId}")
    public void deleteTavolo(@PathVariable("tavoloId") Long tavoloId) { tavoloService.deleteTavolo(tavoloId);}

    @DeleteMapping("/deleteHighest")
    public void deleteHighestIdTavolo() {
        tavoloService.deleteHighestIdTavolo();
    }

}
