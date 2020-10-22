package pers.wk.spring.transactional;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PetMapper {

    @Select("SELECT * FROM pet WHERE id = #{id}")
    Pet getPet(@Param("id") int id);

    int updatePet(Pet pet);
}
