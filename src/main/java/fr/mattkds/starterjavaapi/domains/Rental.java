package fr.mattkds.starterjavaapi.domains;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "rental")
public class Rental implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id", nullable = false)
    private Integer rentalId;

    @Column(name = "rental_date", nullable = false)
    private Timestamp rentalDate;

    @Column(name = "return_date")
    private Timestamp returnDate;

    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

    @ManyToOne
    @JoinColumn(name = "inventory_id", nullable = false)
    private Inventory inventory;

    @Column(name = "customer_id", nullable = false)
    private Integer customer;
    @Column(name = "staff_id", nullable = false)
    private Integer staff;

}

