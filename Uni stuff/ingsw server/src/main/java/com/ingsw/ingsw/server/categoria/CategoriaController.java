package com.ingsw.ingsw.server.categoria;

import com.ingsw.ingsw.server.pietanza.Pietanza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/categoria")
public class CategoriaController {

    private final CategoriaService cat_service;

    @Autowired
    public CategoriaController(CategoriaService cat_service) {
        this.cat_service = cat_service;
    }

    @GetMapping()
    List<Categoria> getCategorie(){
        return cat_service.getCategorie();
    }

    @PostMapping
    public void addNewCategoria(@RequestBody Categoria cat){
        cat_service.addNewCategoria(cat);
    }
    @DeleteMapping(path = "delete/{categoriaId}")
    public void deleteCategoria(@PathVariable("categoriaId") Long Id) {
        cat_service.deleteCategoria(Id);
    }

    @GetMapping(path="/pietanze")
    List<Pietanza> getPietanze(@RequestParam long catId){
        return cat_service.getPietanze(catId);
    }

    @PutMapping(path = "/addpietanza")
    void addPietanza(@RequestParam long pietanzaId, @RequestParam long catId){
        cat_service.addPietanza(pietanzaId,catId);

    }

    @DeleteMapping (path = "/delpietanza")
    void deletePietanza(@RequestParam long pietanzaId, @RequestParam long catId){
        cat_service.deletePietanza(pietanzaId,catId);
    }

}
