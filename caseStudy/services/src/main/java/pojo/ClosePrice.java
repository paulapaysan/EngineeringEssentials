package pojo;

public class ClosePrice {
    String date;
    double price;

    public void ClosePrice(String date, double price) {
        this.date = date;
        this.price = price;
    }

    public void setDate(String d) {
        this.date = d;
    }

    public void setPrice(double p) {
        this.price = p;
    }

    public String getDate() {
        return this.date;
    }

    public double getPrice() {
        return this.price;
    }
}
