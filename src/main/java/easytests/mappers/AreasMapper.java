package easytests.mappers;

import easytests.entities.Area;
import easytests.entities.Dweller;
import java.util.List;
import org.apache.ibatis.annotations.*;

/**
 * @author fortyways  06.02.17.
 */
@Mapper
public interface AreasMapper {

    @Select("SELECT * FROM areas")
    @Results(value =
            {
                    //@Result(property = "id", column = "id"),
                    @Result(property = "name", column = "area_name"),
                    @Result(property = "xCoord", column = "x_coord"),
                    @Result(property = "yCoord", column = "y_coord"),
                    @Result(property = "width", column = "width"),
                    @Result(property = "length", column = "height"),
                    @Result(property = "habitants", javaType = List.class,
                            column = "id", many = @Many(select = "findDwellers"))
            })
    List<Area> findAllAreas();

    @Select("SELECT * FROM areas where id=#{id}")
    @Results(value =
            {
                    //@Result(property = "id", column = "id"),
                    @Result(property = "name", column = "area_name"),
                    @Result(property = "xCoord", column = "x_coord"),
                    @Result(property = "yCoord", column = "y_coord"),
                    @Result(property = "width", column = "width"),
                    @Result(property = "length", column = "height"),
                    @Result(property = "habitants", javaType = List.class,
                            column = "id", many = @Many(select = "findDwellers"))
            })
    Area findAreaById(int id);

    @Select("select * from dwellers where area_id=#{id}")
    @Results(value =
            {@Result(property = "firstName", column = "first_name"),
                    @Result(property = "lastName", column = "last_name"),
                    @Result(property = "surname", column = "surname")
                    })
    List<Dweller> findDwellers(int id);

    @Insert("INSERT INTO areas(area_name, x_coord, y_coord, width, height) VALUES(#{name}, #{xCoord}, #{yCoord}," +
            " #{width}, #{length})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    void create(Area area);

    @Delete("DELETE FROM areas WHERE id=#{id}")
    void delete(Area area);

    @Update("UPDATE areas SET area_name=#{name}, x_coord=#{xCoord}, y_coord=#{yCoord}, width=#{width}, height=#{length} WHERE id=#{id}")
    void update(Area area);
}
