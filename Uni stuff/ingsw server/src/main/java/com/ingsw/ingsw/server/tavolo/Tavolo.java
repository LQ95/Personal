package com.ingsw.ingsw.server.tavolo;

import jakarta.persistence.*;

@Entity
@Table
public class Tavolo {
    @Id
//    @SequenceGenerator(
//            name = "tavolo-sequence",
//            sequenceName = "tavolo-sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "tavolo-sequence"
//    )
    private long id;

    public Tavolo() {
    }

    public Tavolo(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Tavolo{" +
                "id=" + id +
                '}';
    }
}
