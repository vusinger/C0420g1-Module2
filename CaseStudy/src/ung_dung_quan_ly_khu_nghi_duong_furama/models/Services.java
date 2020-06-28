package ung_dung_quan_ly_khu_nghi_duong_furama.models;

public abstract class Services {
    private int id;
    private String serviceName;
    private double useArea;
    private double rentalCost;
    private int maximumPerson;
    private String[] rentType = {"HourlyRent","DailyRent","MonthlyRent","YearlyRent"};
    private AccompaniedService[] accompaniedService = new AccompaniedService[5];

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUseArea() {
        return useArea;
    }

    public void setUseArea(double useArea) {
        this.useArea = useArea;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getMaximumPerson() {
        return maximumPerson;
    }

    public void setMaximumPerson(int maximumPerson) {
        this.maximumPerson = maximumPerson;
    }

    public String[] getRentType() {
        return rentType;
    }

    public void setRentType(String[] rentType) {
        this.rentType = rentType;
    }

    public AccompaniedService[] getAccompaniedService() {
        return accompaniedService;
    }

    public void setAccompaniedService(AccompaniedService[] accompaniedService) {
        this.accompaniedService = accompaniedService;
    }

    public Services() {
    }

    public Services(int id, String serviceName, double useArea, double rentalCost, int maximumPerson, String[] rentType, AccompaniedService[] accompaniedService) {
        this.id = id;
        this.serviceName = serviceName;
        this.useArea = useArea;
        this.rentalCost = rentalCost;
        this.maximumPerson = maximumPerson;
        this.rentType = rentType;
        this.accompaniedService = accompaniedService;
        accompaniedService[0] = new AccompaniedService("Massage",0,0);
        accompaniedService[1] = new AccompaniedService("Karaoke",0,0);
        accompaniedService[2] = new AccompaniedService("Food",0,0);
        accompaniedService[3] = new AccompaniedService("Drink",0,0);
        accompaniedService[4] = new AccompaniedService("RentCar",0,0);
    }

    abstract void showInfo();

    void goMassage(int unit,double price) {
        accompaniedService[0].setUnit(unit);
        accompaniedService[0].setPrice(price);
    }

    void goKaraoke(int unit,double price) {
        accompaniedService[1].setUnit(unit);
        accompaniedService[1].setPrice(price);
    }

    void buyFood(int unit,double price) {
        accompaniedService[2].setUnit(unit);
        accompaniedService[2].setPrice(price);
    }

    void buyDrink(int unit,double price) {
        accompaniedService[3].setUnit(unit);
        accompaniedService[3].setPrice(price);
    }

    void rentCar(int unit,double price) {
        accompaniedService[4].setUnit(unit);
        accompaniedService[4].setPrice(price);
    }

}
