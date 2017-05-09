/**
 * Created by Yehwan on 5/9/2017.
 */

import java.lang.String;
import java.io.*;

public class ReadFile {
    Coordinates[] coordinates;
    public ReadFile(){

    };


    //Receive String fileName and reads text file for coordinates and returns an array of Coordinate instances
    public Coordinates[] getCoor(String fileName) throws IOException {
        try {
            LineNumberReader lnr = new LineNumberReader(new FileReader(fileName));      //function to count num of lines(coordinates)
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String str;
            String[] delimit;
            int count =0;

            lnr.skip(Long.MAX_VALUE);                                                   //skip to end of file line number
            coordinates = new Coordinates[lnr.getLineNumber() + 1];                     //allocate array of Coordinates to number of lines in file
                                                                                        //adds +1 because line starts with 0.

            while((str = in.readLine()) != null){
                delimit = str.split(", ");                                       //delimit by ", "
                coordinates[count] = new Coordinates();
                coordinates[count].setX(Integer.parseInt(delimit[0]));                  //parse x value and insert to Coordinate array
                coordinates[count].setY(Integer.parseInt(delimit[1]));                  //parse y value and insert to Coordinate array
                count++;
            }
            in.close();
        }
        catch (IOException e){
            System.out.println("IO Exception Error");
        }
        return coordinates;
    }
}
//Coordinates x and y
class Coordinates {
    private int x,y;
    public Coordinates(){};
    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
}