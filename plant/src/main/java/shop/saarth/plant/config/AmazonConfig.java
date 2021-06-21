package shop.saarth.plant.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {

    private String region = "ap-south-1";

    @Bean
    public AmazonS3 s3() {
        AWSCredentials awsCredentials = new BasicAWSCredentials("AKIAVMBMXOKOH5MC6NMI",
                "1igJgY/hH8juLZ8Y6LoxXYe7pJmxS+oB3u6EOFfY");

        return AmazonS3ClientBuilder.standard().withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
    }

    @Bean
    public AmazonSNS sns() {
        AWSCredentials awsCredentials = new BasicAWSCredentials("AKIAVMBMXOKOH5MC6NMI",
                "1igJgY/hH8juLZ8Y6LoxXYe7pJmxS+oB3u6EOFfY");

        return AmazonSNSClientBuilder.standard().withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
    }
}
