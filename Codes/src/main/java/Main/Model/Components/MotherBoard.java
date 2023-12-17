package Main.Model.Components;

import java.time.LocalDate;

import Main.Model.Insurance;
import Main.Model.Product;

public class MotherBoard extends Product{
  
    private final float RiskCoefficient=0.1f;
    private Float  RiskMultiplier;
    public String CpuChipset;
    public byte RamSlot,M2_SSD_Slot;
    


    public MotherBoard(
        String Brand, String Model, 
        byte InsurancePeriod,String Category, 
        String CpuChipset, byte RamSlot, byte M2_SSD_Slot,
        Float ProductPrice, LocalDate PurchaseDate)
    {
            super(Brand, Model, InsurancePeriod, Category, ProductPrice,PurchaseDate);

            this.CpuChipset=CpuChipset;
            this.RamSlot=RamSlot;
            this.M2_SSD_Slot=M2_SSD_Slot;

            RiskCalculator();

            Insurance insurance = new Insurance(
              "Motherboard",Brand,Model,
              RiskMultiplier, ProductPrice, InsurancePeriod);

            this.InsurancePrice= insurance.InsurancePriceCalculator();

    }
    public void RiskCalculator() {
        float RiskMultiplier=RiskCoefficient;
        
        switch(this.CpuChipset){
            case "AMD":
              RiskMultiplier+=0.02;
              break;
              case "INTEL":
              RiskMultiplier+=0.07;
              break;
              default:
              RiskMultiplier+=0f;
          }
          switch(this.Brand){
            case "ASUS":
              RiskMultiplier+=0.1;
              break;
              case "GIGAGBYTE":
              RiskMultiplier+=0.4;
              break;
              case "MSI":
              RiskMultiplier+=0.1;
              break;
              default:
              RiskMultiplier+=0;
          }
          switch(this.RamSlot){
            case 2:
              RiskMultiplier+=0.04;
              break;
              case 4:
              RiskMultiplier+=0.02;
              break;
              default:
              RiskMultiplier+=0f;
          }

        this.RiskMultiplier=RiskMultiplier;
        
        
    }

    public float getRiskMultiplier(){
        return RiskMultiplier;
    }

    
}
