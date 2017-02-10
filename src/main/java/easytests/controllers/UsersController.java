package easytests.controllers;

import easytests.entities.Area;
import easytests.entities.Dweller;
import easytests.mappers.AreasMapper;
import easytests.mappers.DwellersMapper;
import easytests.mappers.OccupationsMapper;
import easytests.mappers.UsersMapper;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author malinink
 */
@Controller
@RequestMapping("/")
public class UsersController {


    private AreasMapper areasMapper;
    private final Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping("/users")

    public String list(Model model) {
        List<Area> areas = areasMapper.FindAllAreas();
        logger.info("Total areas=" + areas.size());
        for (int i = 0; i < areas.size(); i++) {
            for (int j = 0; j < areas.get(i).getHabitants().size(); j++) {
                Dweller dweller = areas.get(i).getHabitants().get(j);

                logger.info(dweller.getFirstName() + " " + dweller.getLastName() + " " + dweller.getSurname() + " lives in " + areas.get(i).getName());
            }
        }

        return "users/list";
    }
}
