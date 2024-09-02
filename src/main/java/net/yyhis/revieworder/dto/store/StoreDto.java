package net.yyhis.revieworder.dto.store;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class StoreDto {
    private UUID storeId;
    private String name;
    private String address;
}
