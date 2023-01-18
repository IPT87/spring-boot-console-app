package bg.softuni.springbootconsoleapp.service;

import bg.softuni.springbootconsoleapp.domain.entity.Shop;

public interface ShopService {

    boolean isShopImported(String shopInfo);
    boolean isExistingTown(String shopInfo);
    void importShop(String shopInfo);
    Shop getShopByName(String shopName);

}
