import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class labb2Exercise1 {


    //Alla 90 (alla jämförelser iinluding  copy )världen ta den störtas diffen oc hta det som är närmast den tills du får slut på världen. Du måste dock ta bort duåplicates på nå¨got sät't annars blir det fl

    public Scanner scanner; 

    public static HashMap<Integer, double[]> dataMap = new HashMap<Integer, double[]>();

    public void lab2Exercises1() throws FileNotFoundException {

        readFile(scanner, "Text_files/test_q1.txt");
        double[][] deltaMatrix = DistanceCalculator.createDeltaMatrix(dataMap);
        DistanceCalculator.findChain(deltaMatrix);

    }

    public static void readFile(Scanner scanner, String filePath) throws FileNotFoundException {

        double[] coordinates_array = {0.0, 0.0, 0.0};

        String Xcoordinate = "";
        String Ycoordinate = "";
        String Zcoordinate = "";

        try {
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

                    //end of for loop

                }

                //resets starting coordinate
                tempCoordinate = "x";

                //Sets x, y ,z to list that can be put  as value for hashmap
                coordinates_array[0] = Double.parseDouble((Xcoordinate));
                coordinates_array[1] = Double.parseDouble((Ycoordinate));
                coordinates_array[2] = Double.parseDouble((Zcoordinate));

                //Set coordinates to one key representing the atom.
                dataMap.put(linecount, coordinates_array.clone());

                //Reset Coordinates and coordinates list
                Xcoordinate = "";
                Ycoordinate = "";
                Zcoordinate = "";
                coordinates_array[0] = 0.0;
                coordinates_array[1] = 0.0;
                coordinates_array[2] = 0.0;

            }


        } catch (Exception e) {throw new FileNotFoundException("File not found");}




    }
}