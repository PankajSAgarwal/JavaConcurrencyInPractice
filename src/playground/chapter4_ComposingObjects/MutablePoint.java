package playground.chapter4_ComposingObjects;

import net.jcip.annotations.NotThreadSafe;

import java.util.Map;

/**
 * No instance confinement , so not thread safe
 */
@NotThreadSafe
public class MutablePoint {
    public int x,y;

    public MutablePoint() {
        x=0;
        y=0;
    }

    public MutablePoint(MutablePoint p) {
        this.x = p.x;
        this.y = p.y;
    }
// Thread for rendering vehichles would need access
    /*for(Map.Entry<String,MutablePoint> entry:vehicles.getLocations().entrySet()){
        renderVehicle(entry.getKey(),entry.getValue());
    }*/

// Thread for updating location would also need access
    /*public void vehicleMoved(VehicleMovedEvent evt){
        MutablePoint p = evt.getNewLocation();
        vehicles.setLocation(evt.getVehicleId(),p.x,p.y);
    }*/
}
