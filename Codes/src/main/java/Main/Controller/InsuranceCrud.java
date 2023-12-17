package Main.Controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Main.Model.Insurance;
import Main.Repositories.InsuranceRepo;

@Service
public class InsuranceCrud {
    @Autowired
    InsuranceRepo insuranceRepo;
    
    public Insurance createInsurance(Insurance insurance){
        return insuranceRepo.save(insurance);
    }

    public List<Insurance> getAllInsurances(){
        return insuranceRepo.findAll();
    }
}
