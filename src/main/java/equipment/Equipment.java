package equipment;

import constant.Quality;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PandaLin on 2019/3/19.
 */
public abstract class Equipment {
    private Quality quality;
    private List<GemValue> decorators;

    Equipment(Quality quality) {
        this.quality = quality;
    }

    public abstract Capability getCapability();

    public List<GemValue> getDecorators(){
        this.decorators = new ArrayList<GemValue>();
        return decorators;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    Quality getQuality() {
        return quality;
    }




}
