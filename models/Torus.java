package uap.models;

import uap.bases.Shape;
import uap.interfaces.*;

public class Torus extends Shape implements ThreeDimensional, PiRequired, MassCalculable, MassConverter, ShippingCostCalculator {
    private double majorRadius;
    private double minorRadius;

    public Torus(double majorRadius, double minorRadius){
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;

        setName("Donat dengan lubang");
        getVolume();
        getSurfaceArea();
        getMass();
        gramToKilogram();
        calculateCost();
        printInfo();
    }
    @Override
    public double getVolume(){
        return 2 * PI * PI * majorRadius * minorRadius * minorRadius;
    }
    @Override
    public double getSurfaceArea(){
        return 4 * PI * PI * majorRadius * minorRadius;
    }
    @Override
    public double getMass(){
        return DENSITY * getSurfaceArea() * THICKNESS;
    }
    @Override
    public void printInfo(){
        System.out.println("=============================================");
        System.out.println(getName());
        System.out.println("=============================================");
        System.out.println("Isikan Radius   : isi dengan " + this.majorRadius);
        System.out.println("Isikan radius   : isi dengan " + this.minorRadius);
        System.out.println("=============================================");
        System.out.println("Volume          : " + getVolume());
        System.out.println("Luas permukaan  : " + getSurfaceArea());
        System.out.println("Massa           : " + getMass());
        System.out.println("Massa dalam kg  : " + gramToKilogram());
        System.out.println("Biaya kirim     : Rp" + calculateCost() );
    }
    @Override
    public double gramToKilogram(){
        return getMass() / DENOMINATOR;
    }
    public double calculateCost(){
        return PRICE_PER_KG * gramToKilogram();
    }

    @Override
    public void setName(String inputName) {
        super.setName(inputName);
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
