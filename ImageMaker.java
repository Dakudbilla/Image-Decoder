package com.akud;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//*
// Beginning of ImageMaker class
// ImageMaker class inherits from Dimension_Of_Image class
// */
public class ImageMaker extends Dimension_Of_Image {

    //Constructor that calls the constructor of the parent  class
    public ImageMaker() {
        super();

    }

    // Method that decodes the image
    public String make_image() {
        BufferedImage bufferedImage = new BufferedImage(super.getImage_width(), super.getImage_height(),
                BufferedImage.TYPE_INT_RGB);
        Color[] colors = {Color.BLACK, Color.GREEN, Color.BLACK, Color.WHITE, Color.YELLOW, Color.ORANGE};
        String img_line;
        try {
            Scanner myReader = new Scanner(super.getPicture_file());

            for (int counter = 0; counter < super.getImage_height(); counter++) {

                if (counter == 0)
                    myReader.nextLine();
                else if (counter == super.getImage_height() - 1)
                    myReader.nextLine();
                else {
                    img_line = myReader.nextLine();

                    String[] imageLine = img_line.split("\\s+");

                    int[] img_pixel = new int[imageLine.length / 2];
                    int[] img_color = new int[imageLine.length / 2];
                    int point = 0;
                    for (int foo = 0; foo <= (imageLine.length) - 2; foo += 2) {
                        img_pixel[point] = Integer.parseInt(imageLine[foo]);

                        img_color[point] = Integer.parseInt(imageLine[foo + 1]);

                        point++;

                    }

                    int col = 0;
                    int steps = 0;
                    for (int i = 0; i < img_pixel.length; i++) {
                        for (int j = 0; j < img_pixel[i]; j++) {
                            bufferedImage.setRGB(j + steps, counter, colors[img_color[col]].getRGB());
                        }
                        steps += img_pixel[i];
                        col++;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("File not found");
            return null;
        }


        //Writes bufffered Image to File
        File img_file;
        String directory = System.getProperty("user.dir");
        try {
            img_file = new File(directory + File.separator + "Decoded_picture.png");
            ImageIO.write(bufferedImage, "png", img_file);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Cannot write image to current directory");
            return null;
        }
        return "Decoded_picture.png";
    }

}
