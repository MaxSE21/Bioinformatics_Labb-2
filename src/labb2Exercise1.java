import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystemNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class labb2Exercise1 {


    //Alla 90 (alla jämförelser iinluding  copy )världen ta den störtas diffen oc hta det som är närmast den tills du får slut på världen. Du måste dock ta bort duåplicates på nå¨got sät't annars blir det fl

    public Scanner scanner;

    public int x1;
    public int x2;

    public int y1;
    public int y2;

    public int z1;
    public int z2;

    public static String Xcoordinate = "";
    public static String Ycoordinate = "";
    public static String Zcoordinate = "";

    public static Double[] coordinates_array = {0.0, 0.0, 0.0};
    public static HashMap<Integer, List<Double>> dataMap = new HashMap<Integer,List<Double>>();


    public void lab2Exercises1() throws FileNotFoundException {


        readFile(scanner, "E:\\Programming\\Java stuff\\bioinformatics-lab-2\\Text_files\\test_q1.txt");
        System.out.println((List.of(dataMap)));

    }


    public static double calculateDistance(int x1, int x2, int y1, int y2, int z1, int z2) {

        double delta = 0;

        delta = Math.sqrt(((x2 - x1) ^ 2) + ((y2 - y1)) ^ 2 + ((z2 - z1) ^ 2));

        return delta;
    }


    public static void readFile(Scanner scanner, String filePath) throws FileNotFoundException {


        try {
            System.out.println((List.of(coordinates_array)));
            File file = new File(filePath);
            scanner = new Scanner(file);
            String lineContent = "";

            System.out.println("Running from filepath: " + file);

            int linecount = 0;

            while (scanner.hasNextLine()) {

                linecount++;

                lineContent = scanner.nextLine();
                String tempCoordinate = "x";

                //Iterates through the line string.
                for (int i = 7; i < (lineContent.length()); i++) {


                    //This will be hit when a space is found,
                    // it will now write to Z coordinate instead of previous temp.
                    if (lineContent.charAt(i) == ' ' && tempCoordinate == "y"){
                        tempCoordinate = "z";
                    }
                    //This will be hit when a space is found,
                    // it will now write to Y coordinate instead of previous temp.
                    if (lineContent.charAt(i) == ' '&& tempCoordinate == "x") {
                        tempCoordinate = "y";
                    }


                    switch (tempCoordinate) {
                        case "x" -> Xcoordinate += lineContent.charAt(i);
                        case "y" -> Ycoordinate += lineContent.charAt(i);
                        case "z" -> Zcoordinate += lineContent.charAt(i);
                        default -> {
                            System.out.println("Invalid token");
                            return;
                        }
                    }
                }

                //resets starting coordinate
                tempCoordinate = "x";

                //Sets x, y ,z to list that can be put  as value for hashmap
                coordinates_array[0] = Double.valueOf(Xcoordinate);
                coordinates_array[1] = Double.valueOf(Ycoordinate);
                coordinates_array[2] = Double.valueOf(Zcoordinate);

                //Sets coordinates to one key representing the atom.
                dataMap.put(linecount, List.of(coordinates_array));
                System.out.println((List.of(dataMap)));

                //Resets Coordinates
                Xcoordinate = "";
                Ycoordinate = "";
                Zcoordinate = "";
            }


        } catch (Exception e) {throw new FileNotFoundException("File not found");}




    }
}