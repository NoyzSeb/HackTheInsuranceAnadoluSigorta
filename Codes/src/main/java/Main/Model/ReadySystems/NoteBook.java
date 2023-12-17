package Main.Model.ReadySystems;
import java.time.LocalDate;

import Main.Model.Insurance;
import Main.Model.Product;

public class NoteBook extends Product {
    private final float RiskCoefficient=0.2f;
    private Float  RiskMultiplier;
    public String UseCase;
    public String DisplayPanel;
    public boolean hasHDD=false;



    public NoteBook(
     String Brand, String Model,
     byte InsurancePeriod,String Category,
     Float ProductPrice, LocalDate PurchaseDate,
     String UseCase, String DisplayPanel,
     boolean hasHDD )
     {
        super(Brand,Model, InsurancePeriod,Category,ProductPrice,PurchaseDate);
        
        this.UseCase=UseCase;
        this.DisplayPanel=DisplayPanel;
        this.hasHDD=hasHDD;

        RiskCalculator();

        Insurance insurance = new Insurance(
            "NoteBook",Brand,Model,
            RiskMultiplier, ProductPrice, InsurancePeriod);

        this.InsurancePrice= insurance.InsurancePriceCalculator();

    }

    public void RiskCalculator() {
        float RiskMultiplier=RiskCoefficient;
        
        switch(this.Brand){
          case "ASUS":
            RiskMultiplier+=0.2;
            break;
            case "DELL":
            RiskMultiplier+=0.3;
            break;
            case "HP":
            RiskMultiplier+=0.1;
            break;
            case "RAZER":
            RiskMultiplier+=0.4;
            break;
            case "MSI":
            RiskMultiplier+=0.2;
            break;
            default:
            RiskMultiplier+=0;
        }
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

        if(hasHDD){
            RiskMultiplier+=0.05;
        }



        this.RiskMultiplier=RiskMultiplier;
        
        
    }
}
