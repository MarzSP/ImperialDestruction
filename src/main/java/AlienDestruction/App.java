package AlienDestruction;



import AlienDestruction.Scenes.EndScreen;
import AlienDestruction.Scenes.GameMenu;
import AlienDestruction.Scenes.GameScreen;
import AlienDestruction.Scenes.StartScreen;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;


/** App is de hoofd-klasse van deze game applicatie, deze erft van YaegerGame(Game Engine)
 * De App klasse is verantwoordelijk voor het initialiseren van de game-instellingen, het opzetten van de verschillende schermen (scenes).
 * App start de game op.
 */
public class App extends YaegerGame {
    /**
     * Initialiseert de moeilijkheidsgraad (difficulty) op de standaardwaarde (Easy)
     */
    private int difficulty;

    /**
     * Deze static methode kan aangeroepen worden zonder eerst een object van de class te maken. Deze klasse is de aangestelde entrypoint methode.
     * Launch("--noSplash) verbergt het Yaeger Game Engine start Splash scherm.
     */
    public static void main(String[] args ) {
        launch("--noSplash");
    }

    /**
     * setupGame() methode is een @Override uit YaegerGame.
     * Deze methode wordt gebruikt om de titel in het spel te zetten en de grootte van het venster te bepalen (voor alle scenes)
     */
    @Override
    public void setupGame() {
        setGameTitle("Imperial Destruction");
        setSize(new Size(1200, 800));

    }

    /**
     *setupScenes() methode is een @Override uit YaegerGame. Deze wordt gebruikt om verschillende schermen (scenes) toe te voegen aan het spel met de addScene methode.
     * Elke scene heeft een uniek identificatienummer. Dit spel bestaat uit vier verschillende schermen.
     */
    @Override
    public void setupScenes() {

    addScene(0, new StartScreen(this));
    addScene(1, new GameScreen(this));
    addScene(2, new EndScreen(this));
    addScene(3, new GameMenu());

    }

    /**
     * @return Geeft de huidige moeilijkheidsgraad van het spel terug.
     */

    public int getDifficulty() {
        return difficulty;
    }

    /**
     * @param difficulty Stelt de moeilijkheidsgraad van het spel in op de opgegeven waarde (difficulty).
     */
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
