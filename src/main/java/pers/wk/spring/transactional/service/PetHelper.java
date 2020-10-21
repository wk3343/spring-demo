package pers.wk.spring.transactional.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pers.wk.spring.transactional.Pet;
import pers.wk.spring.transactional.PetMapper;
import pers.wk.spring.transactional.common.PetException;

@Service
public class PetHelper {

    @Autowired
    private PetMapper petMapper;

//    @Transactional(propagation = Propagation.REQUIRED)
    public int updatePet(Pet pet) throws PetException {
        int i = petMapper.updatePet(pet);
        return i;
    }
}
