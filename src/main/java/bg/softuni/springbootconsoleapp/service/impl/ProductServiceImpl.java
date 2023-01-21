package bg.softuni.springbootconsoleapp.service.impl;

import bg.softuni.springbootconsoleapp.constants.Constants;
import bg.softuni.springbootconsoleapp.domain.dto.ProductDto;
import bg.softuni.springbootconsoleapp.domain.entity.Category;
import bg.softuni.springbootconsoleapp.domain.entity.Product;
import bg.softuni.springbootconsoleapp.repository.ProductRepository;
import bg.softuni.springbootconsoleapp.service.ProductService;
import bg.softuni.springbootconsoleapp.utills.Messages;
import bg.softuni.springbootconsoleapp.utills.ValidationUtilsImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ValidationUtilsImpl validator;
    private final ModelMapper mapper;
    private final CategoryServiceImpl categoryService;
    private String[] productData;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);

    public ProductServiceImpl(ProductRepository productRepository, ValidationUtilsImpl validator, ModelMapper mapper, CategoryServiceImpl categoryService) {
        this.productRepository = productRepository;
        this.validator = validator;
        this.mapper = mapper;
        this.categoryService = categoryService;
    }

    @Override
    public boolean isProductImported(String productName) {
        return this.productRepository.findProductByName(productName).isPresent();
    }

    @Override
    public void importProduct(String productInfo) {

        this.productData = productInfo.split(" ");
        String productName = productData[0];
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(productData[1]));
        LocalDate bestBefore = LocalDate.parse(productData[2], dtf);
        String categoryName = productData[3];

        if (isProductImported(productName)) {
            System.out.println(Messages.PRODUCT_EXISTS);
        } else {

            ProductDto productDto = new ProductDto(bestBefore, productName, price);
            Category category;

            if (!this.categoryService.isCategoryImported(categoryName)) {
                this.categoryService.importCategory(categoryName);
            }

            Product product = mapper.map(productDto, Product.class);

            if (validator.isValid(product)) {
                category = this.categoryService.getCategoryByName(categoryName);
                product.setCategory(category);
                this.productRepository.save(product);
                System.out.println(Messages.SUCCESSFULLY_ADDED_PRODUCT);
            } else {
                System.out.println(Messages.INVALID_PRODUCT_DETAILS);
            }

        }

    }
}
