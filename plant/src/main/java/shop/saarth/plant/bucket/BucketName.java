package shop.saarth.plant.bucket;

public enum BucketName {
    PRODUCT_IMAGES("saarth-store");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
