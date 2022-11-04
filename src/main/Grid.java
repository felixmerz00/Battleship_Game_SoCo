import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Grid {
    private char coordinateSystem[][];
    private ArrayList<Ship>[] shipList;

    public Grid() {
        coordinateSystem = new char[][] {{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                        {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                        {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                        {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                        {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                        {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                        {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                        {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                        {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                        {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '}};
    }

    public char getCoordinateValue(int x, int y) {
        return coordinateSystem[x][y];
    }

    public void setShipList(ArrayList<Ship>[] shipList) {
        this.shipList = shipList;
        updateGrid(shipList);
    }

    // Save the ships from the shipList in the grid aka overwrite the grid
    private void updateGrid(ArrayList<Ship>[] shipList){
        char[] shipTypeName = new char[]{'C', 'B', 'S', 'P'}; // Trage diese Symbole ins Grid ein C-Carrier, B-Battleship, S-Submarine, P-Patrol Boat
        for(int shipType = 0; shipType < 4; shipType++){    // Alle Schiffe im Grid speichern
            for(int i = 0; i < shipList[shipType].size(); i++) {    // Alle Schiffe vom aktuellen shipType im Grid speichern
                List<Coordinate> coordinatesOfCurrentShip = shipList[shipType].get(i).getCoordinateList();
                for(int j = 0; j < coordinatesOfCurrentShip.size(); j++){   // Alle Koordinaten vom aktuellen Schiff im Grid speichern
                    coordinateSystem[coordinatesOfCurrentShip.get(j).getY()][coordinatesOfCurrentShip.get(j).getX()] = shipTypeName[shipType];
                }
            }
        }
    }
}