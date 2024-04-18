package fr.mattkds.starterjavaapi.domains;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * The persistent class for the inventory database table.
 *
 */
@Entity
@Data
@Table(name="inventory")
@NamedQuery(name="Inventory.findAll", query="SELECT i FROM Inventory i")
public class Inventory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="inventory_id", unique=true, nullable=false)
    private int inventoryId;

    @Column(name="last_update", nullable=false)
    private Timestamp lastUpdate;

    //bi-directional many-to-one association to Film
    @ManyToOne
    @JoinColumn(name="film_id", nullable=false)
    private Film film;

    @JoinColumn(name="store_id", nullable=false)
    private Integer storeId;
}