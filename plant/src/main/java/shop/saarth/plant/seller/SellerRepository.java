package shop.saarth.plant.seller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SellerRepository extends JpaRepository<SellerDetails, UUID> {
  SellerDetails findBySellerShopName(String store);
}
