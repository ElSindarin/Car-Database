public class Car {
    private final String vin;
    private String regNumber;
    private String brand;
    private String model;
    private short year;
    private int mileage;

    public Car(String vin, String regNumber, String brand, String model, short year, int mileage) {
        this.vin = vin;
        this.regNumber = regNumber;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
    }

    public String getVin() {
        return vin;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public short getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }
}
