package Threading;

import java.util.ArrayList;
import java.util.*;

class Downloader extends Thread {
    String image;
    Downloader(String image){
        this.image = image;
    }
    public void run(){
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Downloading"+ image);
    }
}
public class ImageDownloader {
     public static void main(String[] args) throws InterruptedException{
                String img[] = {"image1","image2","image3"};
                List<Thread> l=new ArrayList<>();
                for(int i=0;i<img.length;i++){
                    Downloader loader = new Downloader(img[i]);
                    l.add(loader);
                    loader.start();
                }
                for(Thread t:l){
                  t.join();
                }
         System.out.println("All images downloaded");
            }
        }

