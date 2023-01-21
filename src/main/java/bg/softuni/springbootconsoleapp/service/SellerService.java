package bg.softuni.springbootconsoleapp.service;

import bg.softuni.springbootconsoleapp.domain.entity.Seller;

public interface SellerService {

    boolean isSellerImported(String sellerInfo);
    void importSeller(String sellerInfo);
    boolean isExistingShop(String sellerInfo);
    Seller getSellerByFirstAndLastNme(String sellerFirstName, String sellerLastName);
    void addManager(String sellerFirstName, String sellerLastName, String managerFirstName, String managerLastName);

}
