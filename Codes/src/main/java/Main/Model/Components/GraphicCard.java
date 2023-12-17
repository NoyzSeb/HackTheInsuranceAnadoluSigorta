package Main.Model.Components;

import java.time.LocalDate;

import Main.Model.Insurance;
import Main.Model.Product;

public class GraphicCard extends Product{

    private Float  RiskMultiplier;
    private final float RiskCoefficient=0.01f;
    public String ChipsetBrand;
    public Byte Vram;

 

    public GraphicCard(
        String Brand, String Model, 
        byte InsurancePeriod,String Category,
        String ChipsetBrand, Byte Vram, 
        Float ProductPrice, LocalDate PurchaseDate)
    {
        super(Brand, Model, InsurancePeriod, Category, ProductPrice, PurchaseDate);

        this.ChipsetBrand=ChipsetBrand;
        this.Vram=Vram;

        RiskCalculator();

        Insurance insurance = new Insurance(
            "GraphicCard",Brand,Model,
            RiskMultiplier, ProductPrice, InsurancePeriod);
            
        this.InsurancePrice= insurance.InsurancePriceCalculator();

    }

    public void RiskCalculator() {
        float RiskMultiplier=RiskCoefficient;

        switch(this.ChipsetBrand){
            case "AMD":
              RiskMultiplier+=0.08;
              break;
              case "INTEL":
              RiskMultiplier+=0.10;
              break;
              case "NVIDIA":
              RiskMultiplier+=0.05;
              break;
              default:
              RiskMultiplier+=0f;
          }
        
        switch(this.Brand){
            case "ASUS":
              RiskMultiplier+=0.1;
              break;
              case "GIGAGBYTE":
              RiskMultiplier+=0.2;
              break;
              case "EVGA":
              RiskMultiplier+=0.3;
              break;
              case "ZOTAC":
              RiskMultiplier+=0.4;
              break;
              case "SAPPHIRE":
              RiskMultiplier+=0.4;
              break;
              case "MSI":
              RiskMultiplier+=0.2;
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
