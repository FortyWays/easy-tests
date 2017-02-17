package easytests.mappers;

import easytests.entities.Dweller;
import java.util.List;
import org.apache.ibatis.annotations.*;

/**
 * @author fortyways on 06.02.17.
 */
@Mapper
public interface DwellersMapper {

    @Results(
            {
                    @Result(property = "id", column = "id"),
                    @Result(property = "firstName", column = "first_name"),
                    @Result(property = "lastName", column = "last_name"),
                    @Result(property = "surname", column = "surname"),
                    @Result(property = "area", column = "area_id", one = @One(select = "AreasMapper.FindAreaById"))
            })

    @Select("SELECT id, first_name, last_name, surname FROM dwellers")
    List<Dweller> readAll();

    @Select("select * from dwellers where area_id=#{id}")
    List<Dweller> findDwellersByAreaId(int id);

    @Select("SELECT id, first_name, last_name,surname FROM dwellers WHERE id = #{id}")
    Dweller getDwellerById(int id);

    @Insert("INSERT INTO dwellers (first_name, last_name, surname, area_id) "
            +
            "VALUES(#{firstName}, #{lastName}, #{surname}, #{area.id})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    void insert(Dweller dweller);

    @Delete("DELETE FROM dwellers WHERE id=#{id}")
    void delete(Dweller dweller);

    @Update("UPDATE dwellers SET first_name=#{firstName}, last_name=#{last_name}, surname=#{surname},"
            +
            " area_id=#{areaId} WHERE id=#{id}")
    void update(Dweller dweller);

}
