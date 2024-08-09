package net.yyhis.revieworder.review.model;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import net.yyhis.revieworder.bible.model.BaseModel;

import net.yyhis.revieworder.order.model.Order;
import net.yyhis.revieworder.user.model.User;

@Getter
@Setter
@Entity
@Table(name = "reviews")
public class Review extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(nullable = false)
    private String content;

    @Min(0)
    @Max(5)
    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer rating;
}
