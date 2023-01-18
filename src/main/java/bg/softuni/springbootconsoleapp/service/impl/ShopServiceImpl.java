package bg.softuni.springbootconsoleapp.service.impl;

import bg.softuni.springbootconsoleapp.domain.dto.ShopDto;
import bg.softuni.springbootconsoleapp.domain.entity.Shop;
import bg.softuni.springbootconsoleapp.domain.entity.Town;
import bg.softuni.springbootconsoleapp.repository.ShopRepository;
import bg.softuni.springbootconsoleapp.service.ShopService;
import bg.softuni.springbootconsoleapp.utills.Messages;
import bg.softuni.springbootconsoleapp.utills.ValidationUtilsImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;
    private final TownServiceImpl townService;
    private final ModelMapper mapper;
    private final ValidationUtilsImpl validator;
    private String[] shopData;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository, TownServiceImpl townService, ModelMapper mapper, ValidationUtilsImpl validator) {
        this.shopRepository = shopRepository;
        this.townService = townService;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public boolean isShopImported(String shopInfo) {
        shopData = shopInfo.split(" ");
        String shopName = shopData[0];
        return this.shopRepository.findShopByName(shopName).isPresent();
    }

    @Override
    public boolean isExistingTown(String shopInfo) {
        shopData = shopInfo.split(" ");
        String townName = shopData[2];

        return this.townService.isTownImported(townName);
    }

    @Override
    public void importShop(String shopInfo) {

        shopData = shopInfo.split(" ");
        String shopName = shopData[0];
        String shopAddress = shopData[1];
        String townName = shopData[2];

        if (isShopImported(shopName)) {
            System.out.println(Messages.SHOP_EXISTS);
        } else {

            if (isExistingTown(shopInfo)) {

                ShopDto shopDto = new ShopDto(shopAddress, shopName);
                Town town = this.townService.getTownByName(townName);
                Shop shop = mapper.map(shopDto, Shop.class);
                boolean isValidShop = validator.isValid(shop);
                boolean isValidTown = validator.isValid(town);

                if (isValidShop && isValidTown) {
                    shop.setTown(town);
                    this.shopRepository.save(shop);
                    System.out.println(Messages.SUCCESSFULLY_ADDED_SHOP);
                } else {
                    System.out.println(Messages.INVALID_SHOP_OR_ADDRESS_NAME);
                }

            } else {
                System.out.println(Messages.TOWN_NOT_EXISTS);
            }

        }

    }
}
