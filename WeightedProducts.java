package finalprojectoopswft1f2u;

public class WeightedProducts extends products {

    private double weight;

    public WeightedProducts(int ID, String name, String Description,
            double Price, double weight) {
        super(ID, name, Description, Price);
        this.weight = weight;
    }

    public WeightedProducts() {
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double CalculatePrice() {
        return weight * getPrice();
    }

    @Override
    public String toString() {
        String str = super.toString();
        str += "," + weight+",W";
        return str;

    }

}
