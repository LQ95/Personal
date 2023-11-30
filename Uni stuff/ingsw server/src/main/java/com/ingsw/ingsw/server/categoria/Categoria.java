package com.ingsw.ingsw.server.categoria;

import com.ingsw.ingsw.server.pietanza.Pietanza;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table
public class Categoria {

    @Id
    @SequenceGenerator(
            name = "categoria_sequence",
            sequenceName = "categoria_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "categoria_sequence"
    )

    @NotNull
    private long Id;

    private String nome;

    public List<Pietanza> getPietanze() {
        return Pietanze;
    }

    public void setPietanze(List<Pietanza> pietanze) {
        Pietanze = pietanze;
    }

    @ManyToMany
    @JoinTable(
            name = "Pietanze_categorie",
            joinColumns = @JoinColumn(name = "categoriaId"),
            inverseJoinColumns = @JoinColumn(name = "pietanzaId")
    )
    private List<Pietanza> Pietanze;

    public Categoria() {
    }

    public Categoria(String nome, List<Pietanza> pietanze) {
        this.nome = nome;
        Pietanze = pietanze;
    }

    public Categoria(String nome, Long id, List<Pietanza> pietanze) {
        this.nome = nome;
        Id = id;
        Pietanze = pietanze;
    }

    public Categoria(String nome, Long id) {
        this.nome = nome;
        Id = id;
    }
    public Categoria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "nome='" + nome + '\'' +
                ", Id=" + Id +
                '}';
    }
}
