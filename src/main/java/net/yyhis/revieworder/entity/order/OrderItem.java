package net.yyhis.revieworder.entity.order;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import net.yyhis.revieworder.entity.BaseModel;
import net.yyhis.revieworder.entity.store.Menu;

@Getter
@Setter
@Entity
@Table(name = "order_items")
public class OrderItem extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "menu_item_id", nullable = false)
    private Menu menuItem;

    @Min(0)
    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double price;
}
