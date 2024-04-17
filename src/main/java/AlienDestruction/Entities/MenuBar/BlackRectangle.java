package AlienDestruction.Entities.MenuBar;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;

import java.util.ArrayList;
// To do:
// Menu balk bovenin gamescherm - zwarte achtergrond
// Sound on/sound off button in Start menu + Game menu balk
// booster.png in game menu. Klikbare sprite, dan 10s in "gebruik", dan 30s niet meer klikbaar (beide klokjes in beeld), rinse repeat.

public class BlackRectangle extends RectangleEntity {
    public BlackRectangle(Coordinate2D initialLocation, Size size) {
        super(initialLocation, size);
    }

    YaegerEntity[] createEntities() {
        var list = new ArrayList<YaegerEntity>();

//        list.add()

        return (YaegerEntity[]) list.toArray();
    }
}







