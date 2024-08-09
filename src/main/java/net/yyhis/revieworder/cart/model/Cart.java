package net.yyhis.revieworder.cart.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import net.yyhis.revieworder.bible.model.BaseModel;
import net.yyhis.revieworder.store.model.Menu;
import net.yyhis.revieworder.user.model.User;

@Getter
@Setter
@Entity
@Table(name = "shopping_carts")
public class Cart extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "menu_item_id", nullable = false)
    private Menu menuItem;
}
