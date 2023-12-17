package Main.Model.Components;

import Main.Model.Insurance;
import Main.Model.Product;
import java.time.LocalDate;


public class CPU extends Product {
    
    private Float  RiskMultiplier;
    private final float RiskCoefficient=0.01f;
    
    public String CpuGen;

    public CPU(
        String Brand, String Model, 
        byte InsurancePeriod,String Category,
        String CpuGen, Float ProductPrice, LocalDate PurchaseDate)
    {
        super(Brand, Model, InsurancePeriod, Category, ProductPrice, PurchaseDate);

        this.CpuGen=CpuGen;

        RiskCalculator();

        Insurance insurance = new Insurance(
            "CPU",Brand,Model,
            RiskMultiplier, ProductPrice, InsurancePeriod);

        this.InsurancePrice= insurance.InsurancePriceCalculator();

    }
    
    public void RiskCalculator() {
        float RiskMultiplier=RiskCoefficient;

        switch(this.Brand){
            case "AMD":
              RiskMultiplier+=0.08;
              break;
              case "INTEL":
              RiskMultiplier+=0.10;
              break;
              default:
              RiskMultiplier+=0f;
          }
        
        switch(this.CpuGen){
            case "AM4":
              RiskMultiplier+=0.1;
              break;
              case "AM5":
              RiskMultiplier+=0.2;
              break;
              case "10th_Gen":
              RiskMultiplier+=0.01;
              break;
              case "11th_Gen":
              RiskMultiplier+=0.015;
              break;
              case "12th_Gen":
              RiskMultiplier+=0.02;
              break;
              case "13th_Gen":
              RiskMultiplier+=0.025;
              break;
              case "14th_Gen":
              RiskMultiplier+=0.04;
              break;
              default:
              RiskMultiplier+=0;
          }

        this.RiskMultiplier=RiskMultiplier;
        
        
    }
    public float getRiskMultiplier(){
        return RiskMultiplier;
    }
}
