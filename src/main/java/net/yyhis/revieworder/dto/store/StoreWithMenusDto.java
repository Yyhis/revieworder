package net.yyhis.revieworder.dto.store;

import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreWithMenusDto {
    private UUID storeId;
    private String storeName;
    private String storeAddress;
    private List<MenuDto> menus;
}