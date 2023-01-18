package bg.softuni.springbootconsoleapp;

import bg.softuni.springbootconsoleapp.service.impl.CategoryServiceImpl;
import bg.softuni.springbootconsoleapp.utills.MenuOptions;
import bg.softuni.springbootconsoleapp.utills.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryServiceImpl categoryService;

    @Autowired
    public CommandLineRunnerImpl(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
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
                    break;
                case "3":
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
