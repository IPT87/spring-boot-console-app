package bg.softuni.springbootconsoleapp.service.impl;

import bg.softuni.springbootconsoleapp.domain.dto.TownDto;
import bg.softuni.springbootconsoleapp.domain.entity.Town;
import bg.softuni.springbootconsoleapp.repository.TownRepository;
import bg.softuni.springbootconsoleapp.service.TownService;
import bg.softuni.springbootconsoleapp.utills.Messages;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final ModelMapper mapper;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, ModelMapper mapper) {
        this.townRepository = townRepository;
        this.mapper = mapper;
    }

    @Override
    public boolean isTownImported(String townName) {
        return this.townRepository.findTownByName(townName).isPresent();
    }

    @Override
    public void importTown(String townName) {
        if (isTownImported(townName)) {
            System.out.println(Messages.TOWN_EXISTS);
        } else {

            TownDto townDto = new TownDto(townName);
            Town town = mapper.map(townDto, Town.class);

            this.townRepository.save(town);
            System.out.println(Messages.SUCCESSFULLY_ADDED_TOWN);

        }
    }

    @Override
    public Town getTownByName(String townName) {
        return this.townRepository.findTownByName(townName).orElse(null);
    }
}
