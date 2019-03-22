package equipment;

import constant.Element;
import constant.Quality;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class GemValue {
    private Quality quality;
    private Element element;

    public GemValue(Quality quality, Element element) {
        this.quality = quality;
        this.element = element;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public String toString(){
        return (this.element.getName() + (this.quality.toString()).charAt(0));
    }
}
