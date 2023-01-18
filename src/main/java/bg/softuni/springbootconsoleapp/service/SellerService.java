package bg.softuni.springbootconsoleapp.service;

public interface SellerService {

    boolean isSellerImported(String sellerInfo);
    void importSeller(String sellerInfo);
    boolean isExistingShop(String sellerInfo);

}
