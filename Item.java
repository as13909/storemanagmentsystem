package gui;

public class Item{
    // declarations
    private int stock, id;
    private String name;
    private double price;


    // constructors
    public Item(){
        stock = 0;
        name = "Unnamed";
        price = 0;
        id = 0;
    }

    public Item(String name, double price, int stock, int id){
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.id = id;
    }

    // methods
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getStock(){
        return stock;
    }
    public int getId(){
        return id;
    }
    // public static int getNumItems(){
    //     return numItems;
    // }
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setStock(int stock){
        this.stock = stock;
    }
    public void setId(int id){
        this.id = id;
    }
    // when an item/items are sold
    public void sell(int sold){
        // decrement
        stock -= sold;
        // stock can never be negative
        if(stock < 0){
            // assign to zero for simplicity
            stock = 0;
        }
    }
    // when quantity of items is increased
    public void add(int added){
        // increment
        stock += added;
    }
    // returns a dash delimited string of the Item
    public String toDelimString(){
        // converting numeric class attributes to strings
        String strStock = Integer.toString(stock);
        String strPrice = Double.toString(price);
        String strId = Integer.toString(id);

        return name+"-"+strStock+"-"+strPrice+"-"+strId;
    }
}