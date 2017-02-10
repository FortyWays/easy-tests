package easytests.mappers;


import easytests.entities.Area;
import easytests.entities.Dweller;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * Created by fortyways on 06.02.17.
 */
@Mapper
public interface AreasMapper {

    @Select("SELECT * FROM areas ")///where id=#{id}
    @Results(value =
            {
                    @Result(property = "id", column = "id"),
                    @Result(property = "name", column = "area_name"),
                    @Result(property = "xCoord", column = "x_coord"),
                    @Result(property = "yCoord", column = "y_coord"),
                    @Result(property = "width", column = "width"),
                    @Result(property = "length", column = "height"),
                    @Result(property = "habitants", javaType = List.class, column = "id", many = @Many(select = "FindDwellers"))
            })
    List<Area> FindAllAreas();

    @Select("SELECT * FROM areas where id=#{id}")
    @Results(value =
            {
                    @Result(property = "id", column = "id"),
                    @Result(property = "name", column = "area_name"),
                    @Result(property = "xCoord", column = "x_coord"),
                    @Result(property = "yCoord", column = "y_coord"),
                    @Result(property = "width", column = "width"),
                    @Result(property = "length", column = "height"),
                    @Result(property = "habitants", javaType = List.class, column = "id", many = @Many(select = "FindDwellers"))
            })
    Area FindAreaById(int id);

    @Select("select * from dwellers where area_id=#{id}")
    @Results(value =
            {@Result(property = "firstName", column = "first_name"),
                    @Result(property = "lastName", column = "last_name"),
                    @Result(property = "surname", column = "surname")
                    })
    List<Dweller> FindDwellers(int id);

}
