package bg.softuni.springbootconsoleapp.service.impl;

import bg.softuni.springbootconsoleapp.domain.dto.SellerDto;
import bg.softuni.springbootconsoleapp.domain.entity.Seller;
import bg.softuni.springbootconsoleapp.domain.entity.Shop;
import bg.softuni.springbootconsoleapp.repository.SellerRepository;
import bg.softuni.springbootconsoleapp.service.SellerService;
import bg.softuni.springbootconsoleapp.utills.Messages;
import bg.softuni.springbootconsoleapp.utills.ValidationUtilsImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;
    private final ShopServiceImpl shopService;
    private final ModelMapper mapper;
    private final ValidationUtilsImpl validator;
    private String[] sellerData;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository, ShopServiceImpl shopService, ModelMapper mapper, ValidationUtilsImpl validator) {
        this.sellerRepository = sellerRepository;
        this.shopService = shopService;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public boolean isSellerImported(String sellerInfo) {
        sellerData = sellerInfo.split(" ");
        String sellerFirstName = sellerData[0];
        String sellerLastName = sellerData[1];
        return this.sellerRepository.findSellerByFirstNameAndLastName(sellerFirstName, sellerLastName).isPresent();
    }

    @Override
    public void importSeller(String sellerInfo) {

        sellerData = sellerInfo.split(" ");
        String sellerFirstName = sellerData[0];
        String sellerLastName = sellerData[1];
        int age = Integer.parseInt(sellerData[2]);
        BigDecimal salary = BigDecimal.valueOf(Long.parseLong(sellerData[3]));
        String shopName = sellerData[4];

        if (isSellerImported(sellerInfo)) {
            System.out.println(Messages.SELLER_EXISTS);
        } else {

            if (isExistingShop(sellerInfo)) {

                SellerDto sellerDto = new SellerDto(sellerFirstName, sellerLastName, age, salary);
                Shop shop = this.shopService.getShopByName(shopName);
                Seller seller = mapper.map(sellerDto, Seller.class);
                boolean isValidSeller = validator.isValid(seller);
                boolean isValidShop = validator.isValid(shop);

                if (isValidSeller && isValidShop) {
                    seller.setShop(shop);
                    this.sellerRepository.save(seller);
                    System.out.println(Messages.SUCCESSFULLY_ADDED_SELLER);
                } else {
                    System.out.println(Messages.INVALID_SELLER_INFO);
                }

            } else {
                System.out.println(Messages.SHOP_NOT_EXISTS);
            }

        }

    }

    @Override
    public boolean isExistingShop(String sellerInfo) {
        sellerData = sellerInfo.split(" ");
        String shopName = sellerData[4];
        return this.shopService.isShopImported(shopName);
    }
}
