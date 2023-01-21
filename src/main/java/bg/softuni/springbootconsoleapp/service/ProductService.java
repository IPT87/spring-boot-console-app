package bg.softuni.springbootconsoleapp.service;

import bg.softuni.springbootconsoleapp.domain.entity.Product;
import bg.softuni.springbootconsoleapp.repository.ProductRepository;

public interface ProductService {

    boolean isProductImported(String productName);
    void importProduct(String productInfo);
    Product getProductByName(String productName);

}
