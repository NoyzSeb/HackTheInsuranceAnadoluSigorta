package Main.Model.Components;
import java.time.LocalDate;

import Main.Model.Insurance;
import Main.Model.Product;

public class Ram extends Product{
    private final float RiskCoefficient=0.05f;
    private Float  RiskMultiplier;

    public String Genaration;
    public short MHz;
    public byte CLK;
    public byte Capacity;



    public Ram(
    String Brand, String Model, 
    byte InsurancePeriod, String Category, 
    String Genaration, short MHz, 
    byte CLK, byte Capacity, 
    Float ProductPrice, LocalDate PurchaseDate)
    {
        super(Brand, Model, InsurancePeriod, Category, ProductPrice, PurchaseDate);

        this.Genaration=Genaration;
        this.MHz=MHz;
        this.CLK=CLK;
        this.Capacity=Capacity;

        RiskCalculator();

        Insurance insurance = new Insurance(
            "RAM",Brand,Model,
            RiskMultiplier, ProductPrice, InsurancePeriod);
            
        this.InsurancePrice= insurance.InsurancePriceCalculator();
        
    }

    public void RiskCalculator() {
        float RiskMultiplier=RiskCoefficient;
        
        switch(this.Brand){
          case "CORSAIR":
            RiskMultiplier+=0.2;
            break;
            case "GSkILL":
            RiskMultiplier+=0.2;
            break;
            case "CRUCIAL":
            RiskMultiplier+=0.1;
            break;
            case "KINGSTON":
            RiskMultiplier+=0.4;
            break;
            case "ADATA":
            RiskMultiplier+=0.4;
            break;
            case "HYPERX":
            RiskMultiplier+=0.4;
            break;
            default:
            RiskMultiplier=RiskCoefficient;
        }
        switch(this.Genaration){
            case "DDR4":
              RiskMultiplier+=0.08;
              break;
              case "DDR5":
              RiskMultiplier+=0.10;
              break;
              case "DDR3":
              RiskMultiplier+=0.05;
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
