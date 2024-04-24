package AlienDestruction.Scenes;


import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.api.scenes.TileMap;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.api.scenes.YaegerScene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
/** De `MenuManager` klasse is een abstracte klasse die fungeert als basis voor het beheren van menu's in het startscherm, gamescherm en eindscherm.
 Het bevat alleen de methodes setupScene() en setupEntities() die in de subclasses geimplementeerd wordt.
 Implements: YaegerScene
**/

 public abstract class MenuManager extends StaticScene implements YaegerScene {


    public void setupScene() {

    }

    public void setupEntities() {
    }
}





