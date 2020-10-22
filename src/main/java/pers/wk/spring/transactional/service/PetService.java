package pers.wk.spring.transactional.service;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pers.wk.spring.transactional.Pet;
import pers.wk.spring.transactional.PetMapper;
import pers.wk.spring.transactional.common.PetException;

import java.util.Date;

@Service
public class PetService {

    @Autowired
    private PetMapper petMapper;

    @Autowired
    private PetHelper petHelper;

    @Transactional(propagation = Propagation.REQUIRED)
    public int updatePet(Pet pet) throws PetException {
        pet.setName(DateFormatUtils.format(new Date(), "HH:mm:ss"));
        petMapper.updatePet(pet);

        pet.setName(DateFormatUtils.format(DateUtils.addHours(new Date(), 1), "HH:mm:ss"));
        petHelper.updatePet(pet);

        if (true) {
            throw new RuntimeException();
        }
        return 1;
    }

    @Transactional
    protected int updateName(Pet pet) throws PetException {
        return petMapper.updatePet(pet);
    }

    public Pet selectById(int id) {
        return petMapper.getPet(id);
    }
}
