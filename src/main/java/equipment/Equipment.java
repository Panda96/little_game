package equipment;

import constant.EquipmentType;
import constant.Quality;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PandaLin on 2019/3/19.
 */
public abstract class Equipment {
    private Quality quality;
    private List<GemValue> decorators = new ArrayList<GemValue>();
    private EquipmentType type;

    public Equipment(Quality quality) {
        this.quality = quality;
    }

    public abstract Capability getCapability();

    public List<GemValue> getDecorators(){
        return decorators;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setDecorators(List<GemValue> decorators) {
        this.decorators = decorators;
    }

    public EquipmentType getType() {
        return type;
    }

    public void setType(EquipmentType type) {
        this.type = type;
    }
}
