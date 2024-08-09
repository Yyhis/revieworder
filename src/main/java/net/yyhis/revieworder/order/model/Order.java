package net.yyhis.revieworder.order.model;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import net.yyhis.revieworder.bible.model.BaseModel;
import net.yyhis.revieworder.store.model.Store;
import net.yyhis.revieworder.type.order_status;
import net.yyhis.revieworder.user.model.User;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Column(nullable = false)
    @ColumnDefault("'pending'")
    private order_status status;
}
