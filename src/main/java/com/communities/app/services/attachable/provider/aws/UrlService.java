package com.communities.app.services.attachable.provider.aws;

import com.communities.app.services.attachable.provider.IUrlService;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;

import java.time.Duration;

@Service
public class UrlService implements IUrlService {
    private final S3Presigner s3Presigner;
    private final CredentialsService credentialsService;

    public UrlService(CredentialsService credentialsService) {
        this.credentialsService = credentialsService;
        this.s3Presigner = S3Presigner.builder()
                .region(Region.US_WEST_2)
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(credentialsService.getAccessKeyId(), credentialsService.getSecretAccessKey())
                ))
                .build();
    }

    @Override
    public String generateUrl(String key) {
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(credentialsService.getBucketName())
                .key(key)
                .build();

        GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
                .getObjectRequest(getObjectRequest)
                .signatureDuration(Duration.ofHours(credentialsService.getExpired()))
                .build();

        return s3Presigner.presignGetObject(presignRequest).url().toString();
    }
}
