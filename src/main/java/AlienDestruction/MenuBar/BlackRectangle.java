package AlienDestruction.MenuBar;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;

import java.util.ArrayList;

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







