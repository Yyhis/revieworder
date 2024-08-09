package net.yyhis.revieworder.store.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import net.yyhis.revieworder.bible.model.BaseModel;

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
