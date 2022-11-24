import jdk.swing.interop.SwingInterOpUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DistanceCalculator {

    //Note that distanceMap uses non-primitive type double
    //public static HashMap<Double, int[]> distanceMap = new HashMap<Double, int[]>();

    public static double[][] createDeltaMatrix(HashMap datamap){

        double[][] deltaMatrix = new double[datamap.size()+1][datamap.size()+1];

        double x1;
        double y1;
        double z1;

        double x2;
        double y2;
        double z2;

        double[] currentList;
        double[] nextList;


        for (int i = 1; i <= datamap.size(); i++){

            currentList = (double[]) datamap.get(i);

            x1 = currentList[0];
            y1 = currentList[1];
            z1 = currentList[2];

            double delta;

            for (int j =1; j <= datamap.size(); j++){

                nextList = (double[]) datamap.get(j);

                x2 = nextList[0];
                y2 = nextList[1];
                z2 = nextList[2];

                delta = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2) + Math.pow((z2 - z1), 2));

                deltaMatrix[i][j] = delta;
            }
        }

      return deltaMatrix;
    }

    public static int[] findChain(double[][] deltaMatrix){

        int[] chain = new int[deltaMatrix.length-1];
        chain[0] = getSingularConnection(deltaMatrix);
        System.out.println(chain[0]);
        int length = 1;

        while(length < deltaMatrix.length-1) {
            for(int i = 1 ; i < deltaMatrix.length ; i++) {
                int tempVar = 0;
                if(length > 2) {
                    tempVar = chain[length-2];
                }
                if(deltaMatrix[chain[length-1]][i] > 3.7 && deltaMatrix[chain[length-1]][i] < 3.9 && i != tempVar) {
                    chain[length] = i;
                    length++;
                    System.out.println(i);
                    break;
                }

            }
        }
        return chain;
    }

    public static int getSingularConnection(double[][] deltaMatrix) {

        for (int i = 1 ; i < deltaMatrix.length ; i++){
            int counter = 0;

            int j = 1;

            do {
                if(deltaMatrix[i][j] > 3.7 && deltaMatrix[i][j] < 3.9) {
                    counter++;
                }

                if(j == deltaMatrix.length-1 && counter == 1) {
                    return i;
                }
                j++;

            } while(j < deltaMatrix.length);

        }
        return -1;
    }



}





