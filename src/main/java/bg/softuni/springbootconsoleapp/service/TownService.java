package bg.softuni.springbootconsoleapp.service;

import bg.softuni.springbootconsoleapp.domain.entity.Town;

public interface TownService {

    boolean isTownImported(String townName);
    void importTown(String townName);
    Town getTownByName(String townName);

}
