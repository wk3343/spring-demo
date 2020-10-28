package pers.wk.spring.transactional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pers.wk.spring.transactional.common.PetException;
import pers.wk.spring.transactional.service.PetService;

public class TransactionalDemo {

    public static void main(String[] args) throws PetException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        PetMapper petMapper = context.getBean(PetMapper.class);
        PetService petService = context.getBean(PetService.class);


        Pet pet = petService.selectById(94);
        System.out.println(pet);

        pet.setName("test");
        System.out.println(petService.updatePet(pet));

        Pet pet2 = petService.selectById(94);
        System.out.println(pet2);
    }
}
