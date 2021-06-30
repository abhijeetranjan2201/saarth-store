package shop.saarth.plant.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    private final SellerRepository sellerRepository;

    @Autowired
    public SellerService (SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public List<SellerDetails> getSeller() {
        return sellerRepository.findAll();
    }

    public void addNewSeller(SellerDetails sellerDetails) {
        sellerRepository.save(sellerDetails);
    }

}
