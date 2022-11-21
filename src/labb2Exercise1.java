import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.math.*;

public class labb2Exercise1 {

    public Scanner scanner;

    public File dataFile;
    public File testFile;

    public int x1;
    public int x2;

    public int y1;
    public int y2;

    public int z1;
    public int z2;

    public static HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();


    public void lab2Exercises1() throws FileNotFoundException {

        //dataFile = readFile(scanner, "E:\\Programming\\Java stuff\\bioinformatics-lab-2\\Text_files\\data_q1.txt");
        testFile = readFile(scanner, "E:\\Programming\\Java stuff\\bioinformatics-lab-2\\Text_files\\test_q1.txt");
    }


    public static double calculateDistance(int x1, int x2, int y1, int y2, int z1, int z2) {

        double delta = 0;

        delta = Math.sqrt(((x2 - x1) ^ 2) + ((y2 - y1)) ^ 2 + ((z2 - z1) ^ 2));

        return delta;
    }


    public static File readFile(Scanner scanner, String filePath) throws FileNotFoundException {

        File file = new File(filePath);

        String coordinate = "x";

        String Xcoordinate = "";
        String Ycoordinate = "";
        String Zcoordinate = "";


        try {
            scanner = new Scanner(file);
            String fileContent = "";

            System.out.println("Running from filepath: " + file);

            while (scanner.hasNextLine()) {

                int key = 0;
                key++;

                fileContent = scanner.nextLine();


                for (int i = 2; i < (fileContent.length() - 1); i++) {


                    if (fileContent.charAt(i) != ' ') {

                        



                    } else {

                        if (coordinate == "x"){
                            Xcoordinate = Xcoordinate.concat(String.valueOf(fileContent.charAt(i)));

                        }
                        if (coordinate == "y"){
                            Ycoordinate = Xcoordinate.concat(String.valueOf(fileContent.charAt(i)));

                        }
                        if (coordinate == "z"){
                            Zcoordinate = Xcoordinate.concat(String.valueOf(fileContent.charAt(i)));

                        }



                    }


                    System.out.println(fileContent);


                }


                //Alla 90 (alla jämförelser iinluding  copy )världen ta den störtas diffen oc hta det som är närmast den tills du får slut på världen. Du måste dock ta bort duåplicates på nå¨got sät't annars blir det fl


            }

            System.out.println();
            System.out.println();

            return file;

        } catch (Exception e) {throw new FileNotFoundException("File not found");}




    }
}