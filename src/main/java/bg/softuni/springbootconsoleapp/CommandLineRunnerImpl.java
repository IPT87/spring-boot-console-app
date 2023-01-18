package bg.softuni.springbootconsoleapp;

import bg.softuni.springbootconsoleapp.service.impl.CategoryServiceImpl;
import bg.softuni.springbootconsoleapp.service.impl.ShopServiceImpl;
import bg.softuni.springbootconsoleapp.service.impl.TownServiceImpl;
import bg.softuni.springbootconsoleapp.utills.MenuOptions;
import bg.softuni.springbootconsoleapp.utills.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryServiceImpl categoryService;
    private final TownServiceImpl townService;
    private final ShopServiceImpl shopService;

    @Autowired
    public CommandLineRunnerImpl(CategoryServiceImpl categoryService, TownServiceImpl townService, ShopServiceImpl shopService) {
        this.categoryService = categoryService;
        this.townService = townService;
        this.shopService = shopService;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(MenuOptions.menu);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("10")) {

            switch (input) {
                case "1":
                    System.out.println(Messages.ENTER_CATEGORY_NAME);
                    input = scanner.nextLine();
                    this.categoryService.importCategory(input);
                    break;
                case "2":
                    System.out.println(Messages.ENTER_TOWN_NAME);
                    input = scanner.nextLine();
                    this.townService.importTown(input);
                    break;
                case "3":
                    System.out.println(Messages.ENTER_SHOP_DETAILS);
                    input = scanner.nextLine();
                    this.shopService.importShop(input);
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "8":
                    break;
                case "9":
                    break;
                default:
                    System.out.println(Messages.INVALID_INPUT_MESSAGE);
            }

            System.out.println(MenuOptions.menu);
            input = scanner.nextLine();
        }

        System.out.println(Messages.EXIT_PROGRAM_MESSAGE);
        System.exit(0);

    }
}
