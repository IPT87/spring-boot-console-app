package bg.softuni.springbootconsoleapp.utills;

public interface Messages {

    String ENTER_CATEGORY_NAME = "Enter category name:\n";
    String CATEGORY_EXISTS = "The category already exists in the database!\n";
    String SUCCESSFULLY_ADDED_CATEGORY = "Successfully added category!\n==================================\n";
    String INVALID_CATEGORY_NAME = "Name must be minimum two characters!\n";
    String ENTER_TOWN_NAME = "Enter town name:\n";
    String TOWN_EXISTS = "The town already exists in the database!\n";
    String TOWN_NOT_EXISTS = "The town is not in the database!\n";
    String SUCCESSFULLY_ADDED_TOWN = "Successfully added town!\n";
    String ENTER_SHOP_DETAILS = "Enter shop details in format: name address town\n";
    String SHOP_EXISTS = "The shop already exists in the database!\n";
    String SHOP_NOT_EXISTS = "The shop is not in the database!\n";
    String SUCCESSFULLY_ADDED_SHOP = "Successfully added shop!\n";
    String INVALID_SHOP_OR_ADDRESS_NAME = "Name and address must be minimum two characters!\n";
    String ENTER_SELLER_DETAILS = "Enter seller details in format: firstName lastName age salary shopName\n";
    String SELLER_EXISTS = "The seller already exists in the database!\n";
    String SUCCESSFULLY_ADDED_SELLER = "Successfully added seller!\n";
    String INVALID_SELLER_INFO = "Seller first and last name must be minimum two characters, age must be at least 18 years and salary a positive number!\n";
    String ENTER_PRODUCT_DETAILS = "Enter product details in format: name price bestBefore(dd-MM-yyyy) category\n";
    String SUCCESSFULLY_ADDED_PRODUCT = "Successfully added product!\n";
    String PRODUCT_EXISTS = "The product already exists in the database!\n";
    String INVALID_PRODUCT_DETAILS = "The product name must be minimum two characters and the price an positive number\n";
    String ENTER_SELLER_NAMES = "Enter seller first and last names:\n";
    String ENTER_MANAGER_NAMES = "Enter manager first and last names:\n";
    String SUCCESSFULLY_ADDED_MANAGER = "Successfully added manager!\n";
    String ENTER_PRODUCT_NAME = "Enter product name:\n";
    String ENTER_PRODUCT_DISTRIBUTION = "Enter product distribution in Shops names in format: [shopName1 shopName2 ... ]\n";
    String SUCCESSFULLY_ADDED_PRODUCT_DISTRIBUTION = "Successfully added product distribution!\n";
    String ENTER_SHOP_NAME = "Enter shop name:\n";
    String EXIT_PROGRAM_MESSAGE = "Good bye!";
    String INVALID_INPUT_MESSAGE = "You have to choose an option in range 1-10.\n";

}
