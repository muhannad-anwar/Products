package finalprojectoopswft1f2u;

public class products {
    
    private int ID;
    private String name;
    private String Description;
    private double Price;
    private DimensionalProducts die;
    private WeightedProducts wei;
    
    public products(int ID, String name, String Description, double Price) {
        this.ID = ID;
        this.name = name;
        this.Description = Description;
        this.Price = Price;
    }
    
    public products() {
    }
    
    public double getID() {
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return Description;
    }
    
    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    public double getPrice() {
        return Price;
    }
    
    public void setPrice(double Price) {
        this.Price = Price;
    }
    
    public double CalculatePrice() {
        return 0;
    }
    
    public double getWeight() {
        return wei.getWeight();
    }
    
    public double getWidth() {
        return die.getWidth();
    }
    
    public double getLength() {
        return die.getLength();
    }

    public void setLength(double length) {
        die.setLength(length);
    }

    public void setWidth(double width) {
        die.setWidth(width);
    }

    public void setWeight(double weight) {
        wei.setWeight(weight);
    }
    
    @Override
    public String toString() {
        return ID + "," + name + "," + Description + "," + Price;
    }
    
}
