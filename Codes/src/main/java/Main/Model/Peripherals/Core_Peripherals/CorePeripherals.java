package Main.Model.Peripherals.Core_Peripherals;

import java.time.LocalDate;

import Main.Model.Insurance;
import Main.Model.Product;

public class CorePeripherals extends Product {
    
    private final float RiskCoefficient=0f;
    private Float  RiskMultiplier;
    

    public boolean hasCosmeticLights=false,isWired=true,hasMic=false;
    
    public CorePeripherals(
        String Brand, String Model, 
        byte InsurancePeriod,String Category, 
        boolean hasLight,boolean isWired, 
        boolean hasMic,Float ProductPrice, LocalDate PurchaseDate)
    {
        super(Brand, Model, InsurancePeriod, Category, ProductPrice, PurchaseDate);

        this.hasCosmeticLights=hasLight;
        this.isWired=isWired;
        this.hasMic=hasMic;

        RiskCalculator();

        Insurance insurance = new Insurance(
            Category,Brand,Model,RiskMultiplier, 
            ProductPrice, InsurancePeriod);

        this.InsurancePrice= insurance.InsurancePriceCalculator();
    }

    public void RiskCalculator() {
        float RiskMultiplier=RiskCoefficient;
        
        switch(this.Category){
          case "Mouse":
            RiskMultiplier+=0.2;
            break;
            case "HeadSet":
            RiskMultiplier+=(hasMic) ? 0.22:0.2;        
            break;
            case "Speaker":
            RiskMultiplier+=0.1;
            break;
            case "KeyBoard":
            RiskMultiplier+=0.4;
            break;
            default:
            RiskMultiplier=RiskCoefficient;
        }

        RiskMultiplier+=(isWired) ? 0.1:0;
        RiskMultiplier+=(hasCosmeticLights) ? 0.2:0;


        this.RiskMultiplier=RiskMultiplier;
        
        
    }

    public float getRiskMultiplier(){
        return RiskMultiplier;
    }

    
}
