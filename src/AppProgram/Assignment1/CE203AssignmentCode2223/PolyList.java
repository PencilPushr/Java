package AppProgram.Assignment1.CE203AssignmentCode2223;

import java.util.ArrayList;

public class PolyList {

    private ArrayList<PolygonContainer> PolyList = new ArrayList<PolygonContainer>();


    public void AddtoPolyList(PolygonContainer p){
        PolyList.add(p);
    }

    public PolygonContainer getPolygon(int ID){
        for (var i: PolyList) {
            if (ID == i.pId) return i;
        }
        return null;
    }
}
