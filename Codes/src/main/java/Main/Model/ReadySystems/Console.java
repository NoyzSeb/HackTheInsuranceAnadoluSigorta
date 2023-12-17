package Main.Model.ReadySystems;

import java.time.LocalDate;

import Main.Model.Insurance;
import Main.Model.Product;


public class Console extends Product {
    
    private final float consoleRiskCoefficient=0.1f;
    private Float  RiskMultiplier;

    


    public Console(
        String Brand, String Model, 
        byte InsurancePeriod,String Category, 
        Float ProductPrice, LocalDate PurchaseDate)
    {
        super(Brand,Model, InsurancePeriod,Category,ProductPrice,PurchaseDate);
        
        RiskCalculator();

        Insurance insurance = new Insurance(
            "Console",Brand,Model,RiskMultiplier, 
            ProductPrice, InsurancePeriod);

        this.InsurancePrice= insurance.InsurancePriceCalculator();

    }
    
    public void RiskCalculator() {
        float RiskMultiplier=consoleRiskCoefficient;
        
        switch(this.Brand){
          case "SONY":
            RiskMultiplier+=0.2;
            break;
            case "MICROSOFT":
            RiskMultiplier+=0.2;
            break;
            case "NİNTENDO":
            RiskMultiplier+=0.1;
            break;
            case "VALVE":
            RiskMultiplier+=0.4;
            break;
            default:
            RiskMultiplier=consoleRiskCoefficient;
        }

        this.RiskMultiplier=RiskMultiplier;
        
        
    }

    public float getRiskMultiplier(){
        return RiskMultiplier;
    }

    
    

}
