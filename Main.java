import java.io.IOException;
public class Main {
    
    public static void main(String[] args) throws IOException{
        ImageProcessing img = new ImageProcessing();
        img.GrayScale1("image/image.png","image/output.png", "png");
        img.GrayScale2("image/image.png", "image/output2.png", "png");
    }
}
