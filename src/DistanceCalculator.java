import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DistanceCalculator {

    public double x1;
    public double y1;
    public double z1;

    public double x2;
    public double y2;
    public double z2;

    public static double[] currentList;
    public static double[] nextList;

    public static int[] atomPair = {0, 0};

    //Note that distanceMap uses non-primitive type double
    //public static HashMap<Double, int[]> distanceMap = new HashMap<Double, int[]>();

    public static HashMap<Double, int[]> distanceMap = new HashMap<Double, int[]>();

    public DistanceCalculator(HashMap datamap) {

        for (int j = 1; j < datamap.size(); j++){

            atomPair[0] = j;
            currentList = (double[]) datamap.get(j);
            x1 = currentList[0];
            y1 = currentList[1];
            z1 = currentList[2];

            int i = 1;

            double delta = 0.0;

            for (i = 1; i < datamap.size(); i++){

                if (j != i) {

                    atomPair[1] = i;

                    nextList = (double[]) datamap.get(i);

                    x1 = nextList[0];
                    y1 = nextList[1];
                    z1 = nextList[2];

                    delta = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2) + Math.pow((z2 - z1), 2));

                    distanceMap.put(delta, atomPair);
                }
            }




        }


        System.out.println("check");
    }















}
