package easytests.services;

import easytests.entities.Area;
import easytests.entities.Dweller;
import easytests.mappers.AreasMapper;
import easytests.mappers.DwellersMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author fortyways on 17.02.17.
 */
@Service
public class AreaService {

    @Autowired
    private AreasMapper areasMapper;

    @Autowired
    private DwellersMapper dwellersMapper;

    public void save(Area area) {

        if (areasMapper.findAreaById(area.getId()) == null) {

            areasMapper.insert(area);
            for (Dweller dweller: area.getHabitants()) {
                dwellersMapper.insert(dweller);
            }
        } else {
            final List<Dweller> curHabs = dwellersMapper.findDwellersByAreaId(area.getId());
            areasMapper.update(area);

            for (Dweller dweller: curHabs) {
                dwellersMapper.delete(dweller);
            }
            for (Dweller dweller: area.getHabitants()) {
                dwellersMapper.insert(dweller);
            }

        }
    }

    public void delete(Area area) {
        final List<Dweller> habitants = area.getHabitants();

        for (Dweller dweller: habitants) {
            dwellersMapper.delete(dweller);
        }
        areasMapper.delete(area);
    }

    public Area getById(int id) {
        return areasMapper.findAreaById(id);
    }

    public List<Area> getAll() {
        return areasMapper.findAllAreas();
    }

}
