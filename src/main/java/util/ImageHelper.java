package util;

/**
 * Created by PandaLin on 2019/3/23.
 */
public class ImageHelper {

    public static int getCenterPosition(int begin, int length1, int length2) {
        return begin + (length1 - length2) / 2;
    }
}
