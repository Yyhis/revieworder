package net.yyhis.revieworder.entity.order;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import net.yyhis.revieworder.entity.BaseModel;
import net.yyhis.revieworder.entity.User;
import net.yyhis.revieworder.entity.store.Store;
import net.yyhis.revieworder.util.type.order_status;

import java.util.List;

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

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @Column(nullable = false)
    @ColumnDefault("'pending'")
    private order_status status;
}
