package util;

import constant.Element;
import constant.Quality;

/**
 * Created by PandaLin on 2019/3/21.
 */
public class Generator {
    public static Quality getRandomQuality() {
        Quality[] qualities = Quality.values();
        int num = qualities.length;
        int id = 0;
        while (id == 0){
            id = getRandomNum(num);
        }
        return qualities[id];
    }

    public static Element getRandomElement() {
        Element[] elements = Element.values();
        int num = elements.length;
        int id = getRandomNum(num);
        return elements[id];
    }

    public static int getRandomNum(int num) {
        return (int) (Math.random() * num);
    }

}
