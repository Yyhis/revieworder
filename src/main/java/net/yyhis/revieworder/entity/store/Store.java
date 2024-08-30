package net.yyhis.revieworder.entity.store;

import lombok.Getter;
import lombok.Setter;
import net.yyhis.revieworder.entity.BaseModel;
import jakarta.persistence.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "stores")
public class Store extends BaseModel {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

}