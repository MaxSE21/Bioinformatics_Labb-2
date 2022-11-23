import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DistanceCalculator {

    public double x1;
    public int x2;

    public int y1;
    public int y2;

    public int z1;
    public int z2;


    public static Double[] Ylist = {0.0, 0.0, 0.0};

    public static Double[] Xlist;

    public DistanceCalculator(HashMap datamap) {



        for (int i = 1; i < datamap.size()+1; i++){

            System.out.println(datamap.get(i));

            Xlist = (Double[]) datamap.get(i);


            System.out.println();
            System.out.println(Xlist);

            System.out.println("hmm");

            x1 = Xlist[1];
          
            
        }


       // calculateDistance()







    }


    public static double calculateDistance(int x1, int x2, int y1, int y2, int z1, int z2) {

        double delta = 0.0;

        delta = Math.sqrt(((x2 - x1) ^ 2) + ((y2 - y1)) ^ 2 + ((z2 - z1) ^ 2));

        return delta;
    }





}
