package AlienDestruction;

import javafx.scene.input.KeyCode;

/**De Helper klasse is een hulpklasse die statische constanten groepeert voor verschillende game-elementen.
 * Deze constanten zijn bedoeld om de leesbaarheid en onderhoudbaarheid van de code te verbeteren door magische waarden te vermijden.
 * Deze Helper klasse bevat subclasses: SceneIds, KeyStroke, Direction en Speed.
 * Alle constanten in deze klasse zijn static en final:
 * Dit betekend: dat ze gedeeld worden tussen alle instanties van de Helper klasse en niet kunnen worden gewijzigd na initialisatie.
 */
public class Helper {
    /**
     * De inner-class SceneIds definieert de numerieke constanten(identificatienummers) die gebruikt kunnen worden om te refereren naar verschillende schermen (scenes) in het spel.
     * De constanten vertegenwoordigen de ID's van de schermen.
     */
    public static class SceneIds {
        public static final int StartScreen = 0;
        public static final int GameScreen = 1;
        public static final int EndScreen = 2;
        public static final int GameMenu = 3;
    }

    /**
     * De inner class KeyStroke definieert constanten die de key codes vertegenwoordigen voor verschillende toetsenbord aanslagen die gebruikt worden in het spel.
     * De constanten gebruiken de KeyCode enum uit JavaFX.
     */
    public static class KeyStroke {
        public static final KeyCode LEFT = KeyCode.A;
        public static final KeyCode RIGHT = KeyCode.D;
        public static final KeyCode BOOST = KeyCode.W;
        public static final KeyCode LEFTBOOST = KeyCode.Q;
        public static final KeyCode RIGHTBOOST = KeyCode.E;
        public static final KeyCode FIRE = KeyCode.SPACE;
    }

    /**
     * De inner class Direction definieert numerieke constanten die verschillende richtingen in het spel vertegenwoordigen.
     * De waarden worden gebruikt in graden (bijv., GOLEFT = 270).
     */
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

    /**
     * De inner class Speed definieert numerieke constanten die verschillende snelheden in het spel vertegenwoordigen.
     */
    public static class Speed {
        public static final double LOW = 1.5;
        public static final double MEDIUM = 3;
        public static final double HIGH = 5;
    }

    public static class Size {
        public  static final double SMALL = 40;
        public static final double MEDIUM = 80;
        public static final double LARGE = 120;
        public static final double HUGE = 160;
    }
}
