/******************************************************
‘***  Project 8 - Connecting to a database
‘***  Gabriel Brown
‘******************************************************
‘*** To Demonstrate Connecting to a database
‘***
‘******************************************************
‘*** 12/10/2017
‘******************************************************
‘*****************************************************/
import java.util.Date;

/**
 *
 * @author gb011
 */
public class Painting extends StoreItem{
    private static int paintingCount;
    private int height;
    private int width;
    private String media; 
    
    Painting(String title, String author, Date dateAcquired, int purchasePrice, int askingPrice,
            int height, int width, String media )
    {
        super(title, author, dateAcquired, purchasePrice, askingPrice);
        this.height = height;
        this.width = width;
        this.media = media;
        paintingCount++;
    }

    public static int getPaintingCount() {
        return paintingCount;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }
    
    public void remove()
    {
        paintingCount--;
    }
    
    public String printableString()
    {
        return "this is a painting?";
    }
}
