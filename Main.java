package com.akud;

/***
 * @Author: AKUDBILLA DANIEL
 *
 * Project name: Encoded_Text_To_Image
 * Purpose: This project takes an encoded image file and decodes it to get the original image
 *
 *
 *
 * **/


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


//main class
public class Main {

    ///Prints decoded image to JFrame
    private Main(String fileName) throws IOException {
        BufferedImage img = ImageIO.read(new File(fileName));
        ImageIcon icon = new ImageIcon(img);
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(200, 300);
        JLabel lbl = new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws IOException {
        //Creates instance of ImageMaker
        ImageMaker imageMaker = new ImageMaker();
        String createdImage = imageMaker.make_image();

        //Prints to console the name of image created
        System.out.println(createdImage);

//Creates new instance of the main class
        Main main = new Main(createdImage);

    }

}
