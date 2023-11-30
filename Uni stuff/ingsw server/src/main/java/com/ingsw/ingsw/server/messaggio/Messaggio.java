package com.ingsw.ingsw.server.messaggio;

import com.ingsw.ingsw.server.utente.Utente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table
public class Messaggio {
    @Id
    @SequenceGenerator(
            name = "messaggio-sequence",
            sequenceName = "messaggio-sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "messaggio-sequence"
    )
    private Long id;

    @NotNull
    private String mittente;

    @NotNull
    @Column(columnDefinition = "VARCHAR(2048)")
    private String corpo;

    public Messaggio(){}

    public Messaggio(Long id, String mittente, String corpo) {
        this.id = id;
        this.mittente = mittente;
        this.corpo = corpo;
    }

    public Messaggio(String mittente, String corpo) {
        this.mittente = mittente;
        this.corpo = corpo;
    }
    @ManyToMany(mappedBy = "messaggiLetti")
    private List<Utente> utentiCheHannoLetto;

    public List<Utente> getLettori() {
        return utentiCheHannoLetto;
    }

    public Long getId() {
        return id;
    }

    public Messaggio(Long id, String mittente, String corpo, List<Utente> utenti) {
        this.id = id;
        this.mittente = mittente;
        this.corpo = corpo;
        utentiCheHannoLetto = utenti;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMittente() {
        return mittente;
    }

    public void setMittente(String mittente) {
        this.mittente = mittente;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }
}

