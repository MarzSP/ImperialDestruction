package AlienDestruction;



import AlienDestruction.Scenes.EndScreen;
import AlienDestruction.Scenes.GameMenu;
import AlienDestruction.Scenes.GameScreen;
import AlienDestruction.Scenes.StartScreen;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;


/** App is de hoofd-klasse van deze game applicatie, deze erft van YaegerGame.
 * De App klasse is verantwoordelijk voor het initialiseren van de game-instellingen, het opzetten van de verschillende schermen (scenes).
 * App start de game op.
 */
public class App extends YaegerGame {
    /**
     * Deze static methode kun je aanroepen zonder eerst een object van de class te maken. Deze klasse is de aangestelde entrypoint methode.
     * @param args
     */
    public static void main(String[] args ) {
        launch("--noSplash");
    }

    /**
     * setupGame() methode is een @Override uit YaegerGame, om de titel in het spel te zetten, en de grootte van het venser te bepalen.
     */
    @Override
    public void setupGame() {
        setGameTitle("Imperial Destruction");
        setSize(new Size(1000, 800));

    }

    /**
     *setupScenes() methode is een @Override uit YaegerGame,om verschillende schermen toe te voegen aan het spel met de addScene methode.
     * Elke scene heeft een uniek identificatienummer.
     */
    @Override
    public void setupScenes() {

    addScene(0, new StartScreen(this));
    addScene(1, new GameScreen(this));
    addScene(2, new EndScreen(this));
    addScene(3, new GameMenu());

    }

}
