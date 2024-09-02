package net.yyhis.revieworder.dto.store;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuDto {
    private UUID menuId;
    private String name;
    private double price;
}
