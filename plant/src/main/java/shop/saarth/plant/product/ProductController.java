package shop.saarth.plant.product;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductServices productService;

    public ProductController(ProductServices productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/")
    public String index() {
        return "Saarth Homepage";
    }

    @GetMapping(path = "/api/product")
    public List<ProductDetails> getProduct() {
        return productService.getProduct();
    }

    @PostMapping(path = "/api/inventory")
    public void addProduct(@RequestBody ProductDetails productDetails) {
        productService.addNewProduct(productDetails);
    }

    @PostMapping(path = "/api/inventory/{productId}/images", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void addProductImage(@PathVariable("productId") UUID productId,
                                @RequestParam("file") MultipartFile file) {
        productService.productImage(productId, file);
    }

    @GetMapping(path = "/api/inventory/{productId}/download")
    public byte[] downloadProductImage(@PathVariable("productId") UUID productId) {
        return productService.downloadProductImage(productId);
    }

    @DeleteMapping(path = "/api/inventory/{productId}/delete")
    public void deleteProduct(@PathVariable("productId") UUID productId) {
        productService.deleteProduct(productId);
    }

    @PutMapping(path = "/api/inventory/update/{productId}")
    public void updateProduct(
            @PathVariable("productId") UUID productId,
            @RequestParam(required = false) float maxPrice,
            @RequestParam(required = false) float price,
            @RequestParam(required = false) boolean stock) {
        productService.updateProduct(productId, maxPrice, price, stock);
    }
}
