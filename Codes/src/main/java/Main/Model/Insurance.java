package Main.Model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Insurance")
public class Insurance {
    @Id
    private String id;
    public String Category;
    public String Brand;
    public String Model;
    private Float RiskMultiplier;
    public Float InsurancePrice;
    public byte  InsurancePeriod;
    public LocalDate InsuranceStartDate=LocalDate.now();
    public Float ProductPrice;

    public Insurance(
        String Category,String Brand,
        String Model,Float RiskMultiplier, 
        Float ProductPrice,byte  InsurancePeriod)
    {
        this.Category=Category;
        this.Brand= Brand;
        this.Model = Model;
        this.InsurancePeriod=InsurancePeriod;
        this.RiskMultiplier=RiskMultiplier;
        this.ProductPrice=ProductPrice;
        
        InsurancePriceCalculator();
    }
    
     
    public float InsurancePriceCalculator(){
        
        this.InsurancePrice=ProductPrice*RiskMultiplier*(InsurancePeriod/10f);
        
        return InsurancePrice;
    }

    public String getID (){
        return this.id;
    }
}
