package com.ingsw.ingsw.server.pietanza;

import com.ingsw.ingsw.server.categoria.Categoria;
import com.ingsw.ingsw.server.ordinazione.Ordinazione;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table
public class Pietanza {


    @Id
    @SequenceGenerator(
            name = "pietanza_sequence",
            sequenceName = "pietanza_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pietanza_sequence"
    )

    private Long Id;
    @NotEmpty(message = "Questo campo non può essere vuoto")
    @Column(unique = true)
    private String name;
    private String descrizione;

    public Pietanza() {
    }

    private String allergeni;
    @NotNull(message = "Questo campo non può essere null")
    @DecimalMin(value = "0.01", message = "Il costo deve essere sempre maggiore di 0")
    private Float costo;

    @ManyToMany(mappedBy = "Pietanze")
    List<Categoria> Categorie;
    @ManyToMany(mappedBy = "Pietanze") //se causa problemi cambiare nome nella classe Ordinazione
    private List<Ordinazione>Ordinazioni;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getAllergeni() {
        return allergeni;
    }

    public void setAllergeni(String allergeni) {
        this.allergeni = allergeni;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public Pietanza(String name, String descrizione, Float costo) {
        this.name = name;
        this.descrizione = descrizione;
        this.costo = costo;
    }

    public Pietanza(String name, String descrizione, String allergeni, Float costo) {
        this.name = name;
        this.descrizione = descrizione;
        this.allergeni = allergeni;
        this.costo = costo;
    }

    public Pietanza(Long id, String name, String descrizione, String allergeni, Float costo) {
        Id = id;
        this.name = name;
        this.descrizione = descrizione;
        this.allergeni = allergeni;
        this.costo = costo;
    }
    @Override
    public String toString() {
        return "Pietanza{" +
                "name='" + name + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", allergeni='" + allergeni + '\'' +
                ", costo=" + costo +
                '}';
    }
}
