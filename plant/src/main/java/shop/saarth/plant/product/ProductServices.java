package shop.saarth.plant.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import shop.saarth.plant.bucket.BucketName;
import shop.saarth.plant.filestore.FileStore;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.*;

@Service
public class ProductServices {

    private final ProductRepository productRepository;
    private final FileStore fileStore;

    @Autowired
    public ProductServices(ProductRepository productRepository, FileStore fileStore) {
        this.productRepository = productRepository;
        this.fileStore = fileStore;
    }

    //get request for product method
    public List<ProductDetails> getProduct() {
        return productRepository.findAll(Sort.by("type"));
    }

    //delete request for product method
    public void deleteProduct(UUID productID) {
        boolean exist = productRepository.existsById(productID);
        if(!exist) {
            throw new IllegalStateException("Product with Id" + productID +
                    " does not exist");
        }
        productRepository.deleteById(productID);
    }

    @Transactional //put request for product method
    public void updateProduct(UUID productID, float maxPrice, float price, boolean stock){
        ProductDetails productDetails = productRepository.findById(productID)
                .orElseThrow(() -> new IllegalStateException("Product with Id"
                        + productID + " does not exist"));

        if(maxPrice > 0 && !Objects.equals(productDetails.getMaxPrice(), maxPrice)) {
            productDetails.setMaxPrice(maxPrice);
        }

        if(price > 0 && !Objects.equals(productDetails.getPrice(), price)) {
            productDetails.setPrice(price);
        }

        productDetails.setStock(stock);
    }

    //post request for product method
    public void addNewProduct(ProductDetails productDetails) {
        productRepository.save(productDetails);
    }

    @Transactional//put request for product to update image field method
    public void productImage(UUID productID, MultipartFile file) {

        ProductDetails productDetails = productRepository.getOne(productID);

        Map<String, String> metadata = extractMetadata(file);

        String path = String.format("%s", BucketName.PRODUCT_IMAGES.getBucketName());
        String filename = String.format("%s", file.getOriginalFilename());

        try {
            fileStore.save(path, filename, Optional.of(metadata), file.getInputStream());
            productDetails.setImage(filename);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private Map<String, String> extractMetadata(MultipartFile file) {
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));
        return metadata;
    }

    byte[] downloadProductImage(UUID productId) {
        ProductDetails productDetails = productRepository.getOne(productId);
        String path = String.format("%s", BucketName.PRODUCT_IMAGES.getBucketName());
        String key = productDetails.getImage();
        return fileStore.download(path, key);
    }
}
