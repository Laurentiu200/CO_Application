package com.example.aplicatiepaypall.Blurr_Code;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javafx.application.Application.launch;

public class BlurrEfect {

    static File fin;
    static BufferedImage input;
    static BufferedImage output;


    public static void initImage(String path) throws IOException {

        fin = new File(path);
        input = ImageIO.read(fin);
    }

    public static void CreateImage() throws IOException {

        Color color[];
        output = new BufferedImage(
                input.getWidth(), input.getHeight(),
                BufferedImage.TYPE_INT_RGB);
        int i = 0;
        int max = 400, rad = 10;
        int a1 = 0, r1 = 0, g1 = 0, b1 = 0;
        color = new Color[max];
        int x = 1, y = 1, x1, y1, ex = 5, d = 0;
        for (x = rad; x < input.getHeight() - rad; x++) {
            for (y = rad; y < input.getWidth() - rad; y++) {
                for (x1 = x - rad; x1 < x + rad; x1++) {
                    for (y1 = y - rad; y1 < y + rad; y1++) {
                        color[i++] = new Color(
                                input.getRGB(y1, x1));
                    }
                }

                i = 0;
                for (d = 0; d < max; d++) {
                    a1 = a1 + color[d].getAlpha();
                }

                a1 = a1 / (max);
                for (d = 0; d < max; d++) {
                    r1 = r1 + color[d].getRed();
                }

                r1 = r1 / (max);
                for (d = 0; d < max; d++) {
                    g1 = g1 + color[d].getGreen();
                }

                g1 = g1 / (max);
                for (d = 0; d < max; d++) {
                    b1 = b1 + color[d].getBlue();
                }

                b1 = b1 / (max);
                int sum1 = (a1 << 24) + (r1 << 16)
                        + (g1 << 8) + b1;
                output.setRGB(y, x, (int)(sum1));
            }
        }
        System.out.println("Done");
    }

    public static void printOutput(String path) throws IOException {
        ImageIO.write(
                output, "jpeg",
                new File(path + "\\BlurredImage.jpg"));
        System.out.println("Image blurred successfully !");
    }

    public static Image getImage()
    {
        Image image = new Image("C:/Users/laure/Desktop/BlurredImage.jpeg");
        return image;
    }

}
