package bg.softuni.springbootconsoleapp.service;

public interface ShopService {

    boolean isShopImported(String shopInfo);
    boolean isExistingTown(String shopInfo);
    void importShop(String shopInfo);

}
