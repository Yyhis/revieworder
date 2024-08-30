package net.yyhis.revieworder.entity.store;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import net.yyhis.revieworder.entity.BaseModel;

@Getter
@Setter
@Entity
@Table(name = "menu_items")
public class Menu extends BaseModel {
    @Column(nullable = false)
    private String itemName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Boolean availability;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

}
