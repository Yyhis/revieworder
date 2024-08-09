package net.yyhis.revieworder.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import net.yyhis.revieworder.bible.model.BaseModel;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseModel {
    @Column(nullable = false, unique = true)
    private String username;
}
