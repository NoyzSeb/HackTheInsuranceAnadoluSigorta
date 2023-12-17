package Main.Services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Main.Controller.InsuranceCrud;
import Main.Controller.UserCrud;
import Main.Model.Insurance;
import Main.Model.Components.CPU;
import Main.Model.Components.GraphicCard;
import Main.Model.Components.MotherBoard;
import Main.Model.Components.Ram;
import Main.Model.Peripherals.Additional_Peripherals.Add_Peripherals;
import Main.Model.Peripherals.Core_Peripherals.CorePeripherals;
import Main.Model.ReadySystems.Console;
import Main.Model.ReadySystems.NoteBook;

@RestController
@RequestMapping("api")
public class InsuranceServ {
    @Autowired
	private InsuranceCrud insuranceCrud;

    @Autowired
    private UserCrud userCrud;

    
    @GetMapping("InsuranceList")
	public ResponseEntity<List<Insurance>> AllInsurances(){
		return ResponseEntity.ok(insuranceCrud.getAllInsurances());
	}

    @PostMapping("PreviewConsoleInsurance")
    public ResponseEntity<Console> postMethodName(@RequestBody Console console) {
        
        return ResponseEntity.ok(console);
    }

    @PostMapping("PreviewNoteBookInsurance")
    public ResponseEntity<NoteBook> postMethodName(@RequestBody NoteBook noteBook) {
        
        return ResponseEntity.ok(noteBook);
    }

    @PostMapping("PreviewGraphicCardInsurance")
    public ResponseEntity<GraphicCard> postMethodName(@RequestBody GraphicCard GPU) {
        
        return ResponseEntity.ok(GPU);
    }

    @PostMapping("PreviewRamInsurance")
    public ResponseEntity<Ram> postMethodName(@RequestBody Ram ram) {
        
        return ResponseEntity.ok(ram);
    }

    @PostMapping("PreviewMotherBoardInsurance")
    public ResponseEntity<MotherBoard> postMethodName(@RequestBody MotherBoard mBoard) {
        
        return ResponseEntity.ok(mBoard);
    }

    @PostMapping("PreviewCPUInsurance")
    public ResponseEntity<CPU> postMethodName(@RequestBody CPU cpu) {
        
        return ResponseEntity.ok(cpu);
    }

    @PostMapping("PreviewCorePeripheralsInsurance")
    public ResponseEntity<CorePeripherals> postMethodName(@RequestBody CorePeripherals corePeripherals) {
        
        return ResponseEntity.ok(corePeripherals);
    }

    @PostMapping("PreviewAddPeripheralsInsurance")
    public ResponseEntity<Add_Peripherals> postMethodName(@RequestBody Add_Peripherals addPeripherals) {
        
        return ResponseEntity.ok(addPeripherals);
    }    
    
    

    @PostMapping("createInsurance/{id}")
    public ResponseEntity<String> createInsurance(@PathVariable String id,@RequestBody Insurance insurance) {
          Insurance temp_insurance=insuranceCrud.createInsurance(insurance);
          userCrud.addInsurance(temp_insurance.getID(),id);

      return ResponseEntity.ok("Succesfully Insured Have a nice day.");
    }
}
