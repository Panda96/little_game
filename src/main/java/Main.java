import com.sun.xml.internal.messaging.saaj.soap.impl.ElementFactory;
import constant.Element;
import constant.HeroType;
import constant.Quality;
import equipment.*;
import game.Game;

import java.util.List;

/**
 * Created by PandaLin on 2019/3/18.
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game(HeroType.SHOOTER);
        game.show();

        while(!(game.getState().equals(game.getGameOverState()))){
            game.heroAttack();
            game.monsterAttack();
            game.show();
            game.prepare();
            System.out.println("----------------------------------------------------");
        }
//        int i = 0;
//        while (i<5) {
//            game.heroAttack();
//            game.monsterAttack();
//            game.show();
//            game.prepare();
//            i+=1;
//        }
    }
}
