package bg.softuni.springbootconsoleapp.service;

import bg.softuni.springbootconsoleapp.domain.entity.Seller;
import bg.softuni.springbootconsoleapp.domain.entity.Shop;

import java.util.List;

public interface ShopService {

    boolean isShopImported(String shopInfo);
    boolean isExistingTown(String shopInfo);
    void importShop(String shopInfo);
    Shop getShopByName(String shopName);
    void addProductToShop(String productName, String[] shops);
    void addSellerToShop(String shopName, Seller seller);
    void getSellers(String shopName);

}
