package shop.saarth.plant.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SellerController {

    private final SellerService sellerService;
    @Autowired
    public SellerController (SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping(path = "/api/seller")
    public List<SellerDetails> getSellers() {
        return sellerService.getSeller();
    }

    @PostMapping(path = "/api/partners")
    public void addSeller(@RequestBody SellerDetails sellerDetails) {
        sellerService.addNewSeller(sellerDetails);
    }
}
