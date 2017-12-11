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
public class Book extends StoreItem {
    private static int bookCount = 0;
    private String genre;
    
    Book(String title, String author, Date dateAcquired, int purchasePrice, int askingPrice, String genre )
    {
        super(title, author, dateAcquired, purchasePrice, askingPrice);
        this.genre = genre;
        bookCount++;
    }

    public static int getBookCount() {
        return bookCount;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public void remove()  // called when removing a book item, decrements the bookCount
    {
        bookCount--;
    }
    
    public String printableString()
    {
        return "this is a book?";
    }
}
