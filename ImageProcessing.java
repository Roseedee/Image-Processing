import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.*;

import javax.imageio.ImageIO;

public class ImageProcessing {

    int width;
    int height;
    BufferedImage image = null;
    File input = null;
    File output = null;


    public void GrayScale1(String _input, String _output, String format_output) throws IOException {
        
        input = new File(_input);
        output = new File(_output);

        try {
            image = ImageIO.read(input);
            System.out.println("Read file Complate");
            this.width = image.getWidth();
            this.height = image.getHeight();
            for(int x = 0; x < width; x++) {
                for(int y = 0; y < height; y++) {
                    int p = image.getRGB(x, y);
                    int a = (p >> 24) & 0xff;
                    int r = (p >> 16) & 0xff;
                    int g = (p >> 8) & 0xff;
                    int b = p & 0xff;
                    int avg = (r + g + b) / 3;
                    p = (a << 24) | (avg << 16) | (avg << 8) | avg;
                    image.setRGB(x, y, p);
                }
            }
            try {
                ImageIO.write(image, format_output, output);
                System.out.println("Write file Complate");
            }catch(IOException e) {
                System.out.println(e);
            }
            System.out.println("Convert to grayscale Successfully");
        }catch(IOException e) {
            System.out.println("Error : " + e);
        }

    }

    public void GrayScale2(String _input, String _output, String format_output) {
        input = new File(_input);
        output = new File(_output);

        try {
            image = ImageIO.read(input);
            this.width = image.getWidth();
            this.height = image.getHeight();
            for(int x = 0; x < width; x++) {
                for(int y = 0; y < height; y++) {
                    Color color = new Color(image.getRGB(x, y));
                    int r = (int)(color.getRed() * 0.299);
                    int g = (int)(color.getGreen() * 0.587);
                    int b = (int)(color.getBlue() * 0.114);
                    color = new Color(r + g + b, r + g + b, r + g + b);
                    image.setRGB(x, y, color.getRGB());
                }
            }
            try {
                ImageIO.write(image, format_output, output);
                System.out.println("Write file Complate");
            }catch(IOException e) {
                System.out.println(e);
            }
            System.out.println("Convert to grayscale Successfully");
        }catch(IOException e) {

        }
    }

}
