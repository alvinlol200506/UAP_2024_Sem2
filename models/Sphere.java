package uap.models;

import uap.bases.Shape;
import uap.interfaces.MassCalculable;
import uap.interfaces.PiRequired;
import uap.interfaces.ShippingCostCalculator;
import uap.interfaces.ThreeDimensional;

public class Sphere extends Shape implements ThreeDimensional, PiRequired, MassCalculable, ShippingCostCalculator {
    private double radius;

    public Sphere(double radius){
        this.radius = radius;
        getVolume();
        getSurfaceArea();
        getMass();
        gramToKilogram();
        calculateCost();
        printInfo();
    }
    @Override
    public double getVolume(){
        return 4/3 * PI * radius * radius * radius;
    }
    @Override
    public double getSurfaceArea(){
        return 4 * PI * radius * radius;
    }
    @Override
    public double getMass(){
        return DENSITY * getSurfaceArea() * THICKNESS;
    }
    @Override
    public void printInfo(){
        System.out.println("=============================================");
        System.out.println("Donat tanpa lubang");
        System.out.println("=============================================");
        System.out.println("Isikan radius   : isi dengan " + this.radius);
        System.out.println("=============================================");
        System.out.println("Volume          : " + getVolume());
        System.out.println("Luas permukaan  : " + getSurfaceArea());
        System.out.println("Massa           : " + getMass());
        System.out.println("Massa dalam kg  : " + gramToKilogram());
        System.out.println("Biaya kirim     : Rp" + calculateCost() );
        System.out.println("=============================================");
    }
    public double gramToKilogram(){
        return getMass() / 1000;
    }
    public double calculateCost(){
        return PRICE_PER_KG * gramToKilogram();
    }
}
