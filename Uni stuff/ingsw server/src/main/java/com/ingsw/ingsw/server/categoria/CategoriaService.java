package com.ingsw.ingsw.server.categoria;

import com.ingsw.ingsw.server.pietanza.Pietanza;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    public CategoriaService(CategoriaRepository cat_repository) {
        this.cat_repository = cat_repository;
    }

    private final CategoriaRepository cat_repository;
    public List<Categoria> getCategorie() {
        return cat_repository.findAll();
    }

    public void addNewCategoria(Categoria cat) {
    cat_repository.save(cat);
    }
    public void deleteCategoria(Long Id){
        boolean found = cat_repository.existsById(Id);
        if(!found){
            throw new IllegalStateException("Non esiste nessuna categoria con id " + Id);
        }
        else cat_repository.deleteById(Id);
    }

    public List<Pietanza> getPietanze(long catId) {
        Optional<Categoria> cat=cat_repository.findById(catId);
        return cat.get().getPietanze();
    }
    @Transactional
    public void addPietanza(long pietanzaId, long catId) {
       cat_repository.addPietanza(pietanzaId,catId);
    }
    @Transactional
    public void deletePietanza(long pietanzaId, long catId) {
        if(cat_repository.existsById(catId)) cat_repository.deletePietanza(pietanzaId,catId);
    }
}
