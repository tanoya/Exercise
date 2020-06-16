package com.toy.opencv;


import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;

public class Application {

    public static void main(String[] args) {
//        getPicFromVideo();
        try{
            String t = "😍";
            byte[] t1 = t.getBytes();
            byte[] t2 = t.getBytes("utf8");
            byte[] t3 = t.getBytes("unicode");
            byte[] t4 = t.getBytes("utf16");
            System.out.println(new String(t4, "unicode"));
            System.out.println(new String(t1, "utf8"));
            System.out.println(new String(t1, "utf16"));
        }catch(Exception e){

        }
    }

    public static void getPicFromVideo(){
        try {

            File source = new File("/Users/tany/Downloads/movie.mp4");
            FFmpegFrameGrabber ff = new FFmpegFrameGrabber(source);
            ff.start();

            for (int i = 0; i < 100; i++) {
                Frame frame = ff.grabImage();

                if (frame == null || frame.image == null) {
                    continue;
                }

                Java2DFrameConverter convert = new Java2DFrameConverter();

                String imageMat = "jpg";

                BufferedImage buffer = convert.getBufferedImage(frame);
                File outPut = new File("/Users/tany/"+i);  // todo

                ImageIO.write(buffer, imageMat, outPut);
            }


            ff.stop();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
