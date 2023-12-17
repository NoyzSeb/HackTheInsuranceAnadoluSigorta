package Main.Model;

import java.time.LocalDate;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("Product")
public class Product {
   
    @Id
    private String id;
    public String Brand;
    public String Model;
    public byte InsurancePeriod;
    public String Category;
    public Float ProductPrice;
    public Float InsurancePrice;
    public LocalDate PurchaseDate;
     
    
    public Product(
        String Brand, String Model, 
        byte InsurancePeriod,String Category, 
        Float ProductPrice, LocalDate PurchaseDate)
    {
        this.Brand=Brand;
        this.Model=Model;
        this.Category=Category;
        this.InsurancePeriod=InsurancePeriod;
        this.ProductPrice=ProductPrice;
        this.PurchaseDate=PurchaseDate;
       
    }
    
   
    

    

}
