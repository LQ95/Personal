package com.ingsw.ingsw.server.utente;

import com.ingsw.ingsw.server.messaggio.Messaggio;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Utente {
    @Id
    @SequenceGenerator(
            name = "utente_sequence",
            sequenceName = "utente_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "utente_sequence"
    )
    private Long id;

    @NotEmpty(message = "Questo campo non può essere vuoto")
    @Column(unique = true)
    private String nome;
    @NotEmpty(message = "Questo campo non può essere vuoto")
    private String password;
    @NotNull(message = "Questo campo non può essere null")
    private RuoliUtente ruolo;  // 0) Amministratore; 1) Supervisore; 2) Addetto alla Sala; 3) Addetto alla Cucina.

    @NotNull(message = "Questo campo non può essere null")
    private boolean firstAccess;
    @ManyToMany
    @JoinTable(name ="Messaggi_letti", joinColumns= @JoinColumn(name = "UtenteId"),
            inverseJoinColumns = @JoinColumn(name = "messaggioId"))
    private List<Messaggio> messaggiLetti;

    public Utente() {
        this.firstAccess=true;
    }

    public Utente(Long id, String nome, String password, RuoliUtente ruolo) {
        this.id = id;
        this.nome = nome;
        this.password = password;
        this.ruolo = ruolo;
        this.firstAccess=true;
    }

    public Utente(String nome, String password, RuoliUtente ruolo, boolean firstAccess) {
        this.nome = nome;
        this.password = password;
        this.ruolo = ruolo;
        this.firstAccess = firstAccess;
    }

    public Utente(String nome, String password, RuoliUtente ruolo) {
        this.nome = nome;
        this.password = password;
        this.ruolo = ruolo;
        this.firstAccess=true;
    }

    public Utente(String nome, String password, String ruolo) {
        this.nome = nome;
        this.password = password;
        this.ruolo = RuoliUtente.valueOf(ruolo);
        this.firstAccess=true;
    }
    public Utente(String nome, String password, String ruolo,Long id) {
        this.id = id;
        this.nome = nome;
        this.password = password;
        this.ruolo = RuoliUtente.valueOf(ruolo);
        this.firstAccess=true;
    }
    public Utente(String nome, String password, String ruolo,String id) {
        this.id = Long.valueOf(id);
        this.nome = nome;
        this.password = password;
        this.ruolo = RuoliUtente.valueOf(ruolo);
        this.firstAccess=true;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RuoliUtente getRuolo() {
        return ruolo;
    }

    public void setRuolo(RuoliUtente ruolo) {
        this.ruolo = ruolo;
    }

    public boolean isFirstAccess() {
        return firstAccess;
    }

    public void setFirstAccess(boolean firstAccess) {
        this.firstAccess = firstAccess;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", password='" + password + '\'' +
                ", ruolo=" + ruolo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utente utente = (Utente) o;
        return Objects.equals(nome, utente.nome) && Objects.equals(password, utente.password);
    }


}
