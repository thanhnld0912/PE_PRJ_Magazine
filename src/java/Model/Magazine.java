/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author HELLO
 */
public class Magazine {
    private String ID, title, publisher; 
    private double price;
    
    //constructor
    public Magazine(){}
    public Magazine(String ID, String title, String publisher, double price){
        this.ID = ID;
        this.title = title;
        this.publisher = publisher;
        this.price = price;
    }
    
    //getter setter
    public String getID() {
      return ID;
   }

   public void setID(String ID) {
      this.ID = ID;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getPublisher() {
      return publisher;
   }

   public void setPublisher(String publisher) {
      this.publisher = publisher;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }
}
