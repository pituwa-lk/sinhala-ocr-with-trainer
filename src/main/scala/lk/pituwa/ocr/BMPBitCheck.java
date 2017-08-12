package lk.pituwa.ocr;

/**
 * Created by nayana on 8/13/17.
 */

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BMPBitCheck {

    public static void main(String[] args) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("ga.bmp"));
        } catch (IOException e) {

        }

        System.out.println("File Opened " + img.getType() + "\n");

        int height = img.getHeight();
        int width = img.getWidth();

        int amountPixel = 0;
        int amountBlackPixel = 0;
        int amountWhitePixel = 0;

        int rgb;
        int red;
        int green;
        int blue;

        double percentPixel = 0;

        System.out.println(height  + "  " +  width + " " + img.getRGB(30, 30));

        for (int h = 1; h<height; h++)
        {
            System.out.print("\n");
            for (int w = 1; w<width; w++)
            {
                amountPixel++;

                rgb = img.getRGB(w, h);

                System.out.print(Integer.toHexString(rgb).substring(2, 3));
                //System.out.print("value of pixel at x:" + w + " and y:" + h + " is -> " + Integer.toHexString(rgb) + "\n");

                if (rgb == 0) {
                    amountBlackPixel++;
                } else if (rgb == 255) {
                    amountWhitePixel++;
                }
                /*red = (rgb >> 16 ) & 0x000000FF;
                green = (rgb >> 8 ) & 0x000000FF;
                blue = (rgb) & 0x000000FF;

                if (red == 0 && green == 0 && blue == 0)
                {
                    amountBlackPixel ++;
                }*/
            }
        }
        percentPixel = (double)amountBlackPixel / (double)amountPixel;

        System.out.println("amount pixel: "+amountPixel);
        System.out.println("amount black pixel: "+amountBlackPixel);
        System.out.println("amount white pixel: "+amountWhitePixel);
        System.out.println("amount pixel black percent: "+percentPixel);
    }
}