package bg.softuni.springbootconsoleapp.utills;

public interface Messages {

    String ENTER_CATEGORY_NAME = "Enter category name:\n";
    String CATEGORY_EXISTS = "The category already exists in the database!\n";
    String SUCCESSFULLY_ADDED_CATEGORY = "Successfully added category!\n==================================\n";
    String INVALID_CATEGORY_NAME = "Name must be minimum two characters!\n";
    String ENTER_TOWN_NAME = "Enter town name:\n";
    String SUCCESSFULLY_ADDED_TOWN = "Successfully added town!\n";
    String ENTER_SHOP_DETAILS = "Enter shop details in format: name address town\n";
    String SUCCESSFULLY_ADDED_SHOP = "Successfully added shop!\n";
    String ENTER_SELLER_DETAILS = "Enter seller details in format: firstName lastName age salary shopName\n";
    String SUCCESSFULLY_ADDED_SELLER = "Successfully added seller!\n";
    String ENTER_PRODUCT_DETAILS = "Enter seller details in format: name price bestBefore(dd-MM-yyyy) category\n";
    String SUCCESSFULLY_ADDED_PRODUCT = "Successfully added product!\n";
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
