package AlienDestruction;

import javafx.scene.input.KeyCode;

/**De Helper klasse is een hulpklasse die statische constanten groepeert voor verschillende game-elementen.
 * Deze constanten zijn bedoeld om de leesbaarheid en onderhoudbaarheid van de code te verbeteren door magische waarden te vermijden.
 * Deze Helper klasse bevat subclasses: SceneIds, KeyStroke, Direction en Speed.
 * Alle constanten in deze klasse zijn static en final:
 * Dit betekend: dat ze gedeeld worden tussen alle instanties van de Helper klasse en niet kunnen worden gewijzigd na initialisatie.
 */
public class Helper {

    public static class SceneIds {
        public static final int StartScreen = 0;
        public static final int GameScreen = 1;
        public static final int EndScreen = 2;
        public static final int GameMenu = 3;
    }

    public static class KeyStroke {
        public static final KeyCode LEFT = KeyCode.A;
        public static final KeyCode RIGHT = KeyCode.D;
        public static final KeyCode BOOST = KeyCode.W;
        public static final KeyCode LEFTBOOST = KeyCode.Q;
        public static final KeyCode RIGHTBOOST = KeyCode.E;
        public static final KeyCode FIRE = KeyCode.SPACE;
    }

    public static class Direction {
        public static final double GOLEFT = 270;
        public static final double GORIGHT = 90;
        public static final double GOUP = 180;
        public static final double DOWN = 0;
        public static final double GOLEFTUP = 225;
        public static final double GORIGHTUP = 135;
        public static final double GOLEFTDOWN = 315;
        public static final double GORIGHTDOWN = 45;
    }

    public static class Speed {
        public static final double LOW = 1.5;
        public static final double MEDIUM = 1.5;
        public static final double HIGH = 1.5;
        public static final double TESTPLAYER3 = 3;
        public static final double TESTPLAYER5 = 5;
    }
}
