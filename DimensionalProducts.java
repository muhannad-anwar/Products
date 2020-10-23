package finalprojectoopswft1f2u;

public class DimensionalProducts extends products {

    private double width;
    private double length;

    public DimensionalProducts(int ID, String name, String Description,
            double Price, double width, double length) {
        
        super(ID, name, Description, Price);
        this.width = width;
        this.length = length;
    }

    public DimensionalProducts() {
    }



    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double CalculatePrice() {
        return length * width * getPrice();
    }

    @Override
    public String toString() {
        String str = super.toString();
        str +=","+width + "," + length+",D";
        return str;
    }

}
