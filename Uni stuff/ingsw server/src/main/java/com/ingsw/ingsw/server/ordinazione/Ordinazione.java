package com.ingsw.ingsw.server.ordinazione;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.ingsw.ingsw.server.pietanza.Pietanza;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Entity
@Table
public class Ordinazione {
    @Id
    @SequenceGenerator(
            name = "ordinazione_sequence",
            sequenceName = "ordinazione_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ordinazione_sequence"
    )
    private Long id;
    @NotNull(message = "Questo campo non può essere null")
    @Temporal(TemporalType.DATE) //Considera solo il giorno e non l'orario
    private Date data;
    @NotNull(message = "Questo campo non può essere null")
    private Float conto;
    @NotNull(message = "Questo campo non può essere null")
    private Boolean aperta = true; //True indica ordinazione aprerta, false chiusa
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "idTavolo")
//    private Tavolo tavolo;
    long tavolo;

    @ManyToMany
    @JoinTable(name ="Pietanze_ordinazioni", joinColumns= @JoinColumn(name = "pietanzaId", referencedColumnName = "Id" ),
    inverseJoinColumns = @JoinColumn(name = "ordinazioneId", referencedColumnName = "id"))
    private List<Pietanza> Pietanze; //se causa problemi cambiare nome
    public Ordinazione() {
    }

    @JsonCreator
    public Ordinazione(long tavolo) {
        this.tavolo = tavolo;
        this.data = new Date();
        this.aperta = true;
        this.conto = 0.0F;
    }

    public Ordinazione(long tavolo, boolean status) {
        this.tavolo = tavolo;
        this.data = new Date();
        this.aperta = status;
        this.conto = 0.0F;
    }

    public Ordinazione(Long id, Float conto, Boolean aperta, long tavolo) {
        this.id = id;
        this.data = new Date();
        this.conto = conto;
        this.aperta = aperta;
        this.tavolo = tavolo;
    }

    public Ordinazione(Float conto, Boolean aperta, long tavolo) {
        this.data = new Date();
        this.conto = conto;
        this.aperta = aperta;
        this.tavolo = tavolo;
    }

    public Ordinazione(Float conto, Boolean aperta, long tavolo, List<Pietanza> pietanze) {
        this.data = new Date();
        this.aperta = aperta;
        this.tavolo = tavolo;
        this.Pietanze = pietanze;

        // Calcola la somma dei costi delle pietanze
        float sommaCosti = 0.0f;
        for (Pietanza pietanza : pietanze) {
            sommaCosti += pietanza.getCosto();
        }
        this.conto = sommaCosti;
    }

    public Ordinazione(long tavolo, Boolean aperta, List<Pietanza> pietanze) {
        this.data = new Date();
        this.aperta = aperta;
        this.tavolo = tavolo;
        this.Pietanze = pietanze;

        // Calcola la somma dei costi delle pietanze
        float sommaCosti = 0.0f;
        for (Pietanza pietanza : pietanze) {
            sommaCosti += pietanza.getCosto();
        }
        this.conto = sommaCosti;
    }

    //Costruttore con data
    public Ordinazione(long tavolo, Boolean aperta, List<Pietanza> pietanze, Date data) {
        this.data = data;
        this.aperta = aperta;
        this.tavolo = tavolo;
        this.Pietanze = pietanze;

        // Calcola la somma dei costi delle pietanze
        float sommaCosti = 0.0f;
        for (Pietanza pietanza : pietanze) {
            sommaCosti += pietanza.getCosto();
        }
        this.conto = sommaCosti;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Float getConto() {
        return conto;
    }

    public void setConto(Float conto) {
        this.conto = conto;
    }

    public Boolean getAperta() {
        return aperta;
    }

    public void setAperta(Boolean aperta) {
        this.aperta = aperta;
    }

    public long getTavolo() {
        return tavolo;
    }

    public void setTavolo(long tavolo) {
        this.tavolo = tavolo;
    }

    public List<Pietanza> getPietanze() {
        return Pietanze;
    }

    public void setPietanze(List<Pietanza> pietanze) {
        Pietanze = pietanze;
    }

    @Override
    public String toString() {
        return "Ordinazione{" +
                "id=" + id +
                ", data=" + data +
                ", conto=" + conto +
                ", status=" + aperta +
                ", tavolo=" + tavolo +
                '}';
    }
}
