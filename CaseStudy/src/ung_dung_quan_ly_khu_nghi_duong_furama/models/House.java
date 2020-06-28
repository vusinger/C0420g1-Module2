package ung_dung_quan_ly_khu_nghi_duong_furama.models;

public class House extends Services{

    private String standardRoom;
    private String otherService;
    private int floorsNumber;

    public House() {
    }

    public House(int id, String serviceName, double useArea, double rentalCost, int maximumPerson, String[] rentType, AccompaniedService[] accompaniedService) {
        super(id, serviceName, useArea, rentalCost, maximumPerson, rentType, accompaniedService);
    }

    @Override
    public void showInfo() {
        System.out.println("Id:"+this.getId());
        System.out.println("Service Name:"+this.getServiceName());
        System.out.println("Use Area:"+this.getUseArea());
        System.out.println("Rental Cost:"+this.getRentalCost());
        System.out.println("Maximum Person:"+this.getMaximumPerson());
//        System.out.println(this.getAccompaniedService()[0].getName()+" Unit:"
//                +this.getAccompaniedService()[0].getUnit()+" Price:"+this.getAccompaniedService()[0].getPrice());
//        System.out.println(this.getAccompaniedService()[1].getName()+" Unit:"
//                +this.getAccompaniedService()[1].getUnit()+" Price:"+this.getAccompaniedService()[1].getPrice());
//        System.out.println(this.getAccompaniedService()[2].getName()+" Unit:"
//                +this.getAccompaniedService()[2].getUnit()+" Price:"+this.getAccompaniedService()[2].getPrice());
//        System.out.println(this.getAccompaniedService()[3].getName()+" Unit:"
//                +this.getAccompaniedService()[3].getUnit()+" Price:"+this.getAccompaniedService()[3].getPrice());
//        System.out.println(this.getAccompaniedService()[4].getName()+" Unit:"
//                +this.getAccompaniedService()[4].getUnit()+" Price:"+this.getAccompaniedService()[4].getPrice());
//        System.out.println("Standard Room:"+this.standardRoom);
//        System.out.println("Other Service:"+this.otherService);
//        System.out.println("Floors Number:"+this.floorsNumber);
        System.out.println();
    }
}
