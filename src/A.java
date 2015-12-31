import java.applet.Applet;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by nilajapatankar on 12/7/14.
 */

public class A {
    public static void main(String[] args) {
        CandidateCode code = new CandidateCode();
        System.out.println(code.minimumCost(new String[]{"A", "B", "C", "D", "E", "F"}, new int[]{1, 2, 2, 6, 4, 3, 4, 5, 6, 1, 3, 6, 4, 3, 1}));

    }

//    public static int minimumCost(String[] input1, int[] input2) {
//        Road[] possibleRoads = new Road[input2.length];
//        int roadCount = 0;
//        for (int i = 0; i < input1.length; i++) {
//            for (int j = i + 1; j < input1.length; j++) {
//                possibleRoads[roadCount] = new Road(input1[i], input1[j], input2[roadCount]);
//                roadCount++;
//            }
//        }
//
//        int minimumNumberOfRoads = input1.length - 1;
//        int minimumCost = 0;
//        int k =0;
//        while (k < minimumNumberOfRoads) {
//            Road roadToConstruct = FindCheapestUnconstructedRoad(possibleRoads);
//                minimumCost += roadToConstruct.constructionCost;
//                k++;
//                roadToConstruct.ConstructRoad();
//        }
//
//        return minimumCost;
//    }
//
//    private static boolean CitiesAlreadyConnected(Road[] possibleRoads, Road roadToConstruct) {
//
//        List<String> alreadyConnectedCities = new ArrayList<String>();
//        boolean cityOneConnected = false;
//        boolean cityTwoConnected = false;
//        for (Road possibleRoad : possibleRoads) {
//            if (possibleRoad.constructed) {
//                alreadyConnectedCities.add(possibleRoad.city1);
//                alreadyConnectedCities.add(possibleRoad.city2);
//            }
//        }
//
//        for (String alreadyConnectedCity : alreadyConnectedCities) {
//            if(alreadyConnectedCity.equalsIgnoreCase(roadToConstruct.city1))
//                cityOneConnected = true;
//            if(alreadyConnectedCity.equalsIgnoreCase(roadToConstruct.city2))
//                cityTwoConnected = true;
//        }
//        return cityOneConnected && cityTwoConnected;
//    }
//
//    private static Road FindCheapestUnconstructedRoad(Road[] possibleRoads) {
//        Road road = possibleRoads[0];
//        for (Road possibleRoad : possibleRoads) {
//            if (road.constructed || !possibleRoad.constructed && possibleRoad.constructionCost < road.constructionCost && !CitiesAlreadyConnected(possibleRoads,possibleRoad))
//                road = possibleRoad;
//        }
//        return road;
//    }
//}
//
//class Road {
//    String city1;
//    String city2;
//    int constructionCost;
//    boolean constructed;
//
//    Road(String vertex1, String vertex2, int cost) {
//        city1 = vertex1;
//        city2 = vertex2;
//        constructionCost = cost;
//        constructed = false;
//    }
//
//    public void ConstructRoad() {
//        constructed = true;
//    }
}