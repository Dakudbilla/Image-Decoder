package com.akud;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dimension_Of_Image {
    private int image_width;
    private int image_height;
    private File picture_file;

    //Constructor
    public Dimension_Of_Image() {
        this.picture_file = new File("picture.txt");
        getImageDimension();
    }

    //This method Takes out image Dimensions from the picture.txt file
    public void getImageDimension() {
        try {
            Scanner myReader = new Scanner(this.picture_file);
            String[] Image_dimension_Array = myReader.nextLine().split("\\s+");
            this.image_width = Integer.parseInt(Image_dimension_Array[0]);
            this.image_height = Integer.parseInt(Image_dimension_Array[1]);
            System.out.println("Width:" + image_width);
            System.out.println("Height" + image_height);
            myReader.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("An error occurred.");

        }
    }

    //accessor for image_width attribute
    public int getImage_width() {
        return image_width;
    }

    //accessor for image_height attribute
    public int getImage_height() {
        return image_height;
    }

    //accessor for picture.txt file
    public File getPicture_file() {
        return picture_file;
    }
}
