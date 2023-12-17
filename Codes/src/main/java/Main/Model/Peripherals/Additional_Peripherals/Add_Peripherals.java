package Main.Model.Peripherals.Additional_Peripherals;

import java.time.LocalDate;

import Main.Model.Insurance;
import Main.Model.Product;


public class Add_Peripherals extends Product {
    
    private final float RiskCoefficient=0f;
    private Float  RiskMultiplier;

    public boolean hasCosmeticLights=false;
    public String DisplayPanel;
    
    public Add_Peripherals(
        String Brand, String Model, 
        byte InsurancePeriod,String Category, 
        boolean hasCosmeticLights,String DisplayPanel, 
        Float ProductPrice, LocalDate PurchaseDate)
    {
        super(Brand, Model, InsurancePeriod, Category, ProductPrice, PurchaseDate);
        this.hasCosmeticLights=hasCosmeticLights;
        this.DisplayPanel=DisplayPanel;

        RiskCalculator();

        Insurance insurance = new Insurance(
            Category,Brand,Model,RiskMultiplier, 
            ProductPrice, InsurancePeriod);

        this.InsurancePrice= insurance.InsurancePriceCalculator();
    }

    public void RiskCalculator() {
        float RiskMultiplier=RiskCoefficient;
        
        switch(this.Category){
          case "DisplayDevice":
            RiskMultiplier+=0.2;

            switch(this.DisplayPanel){
                case "VA":
                  RiskMultiplier+=0.08;
                  break;
                  case "IPS":
                  RiskMultiplier+=0.10;
                  break;
                  case "TN":
                  RiskMultiplier+=0.05;
                  break;
                  default:
                  RiskMultiplier+=0f;
                }

            break;
            case "Mice":
                RiskMultiplier+=(hasCosmeticLights) ? 0.4:0.2;        
            break;
            case "Speaker":
                RiskMultiplier+=(hasCosmeticLights) ? 0.3:0.1;

            
            break;
            default:
            RiskMultiplier=RiskCoefficient;
        }

        this.RiskMultiplier=RiskMultiplier;
        
        
    }

    public float getRiskMultiplier(){
        return RiskMultiplier;
    }
}
