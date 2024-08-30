package net.yyhis.revieworder.entity.order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import net.yyhis.revieworder.entity.BaseModel;
import net.yyhis.revieworder.entity.User;
import net.yyhis.revieworder.entity.store.Menu;

@Getter
@Setter
@Entity
@Table(name = "shopping_carts")
public class Cart extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "menu_item_id", nullable = false)
    private Menu menuItem;

    @Min(0)
    @Column(nullable = false)
    private Integer quantity;
}
