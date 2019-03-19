package equipment;

import constant.Element;
import constant.Quality;

import java.util.List;

/**
 * Created by PandaLin on 2019/3/18.
 */
public abstract class EquipmentDecorator extends Equipment{


    EquipmentDecorator(Quality quality) {
        super(quality);
    }

    public abstract List<GemValue> getDecorators();


}
