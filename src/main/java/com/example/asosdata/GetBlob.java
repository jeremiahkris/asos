package com.example.asosdata;

import com.azure.core.util.BinaryData;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

public class GetBlob {
    public static String getData(String filename) {
        // Retrieve the connection string for use with the application.
        String connectStr = "DefaultEndpointsProtocol=https;AccountName=asosuksnicohortstorage;AccountKey=HMhFopa769gpMdzfbJySWZuslKuaB/1qts+HYMbNDIKeJ5z1KFg3uKhSI7YIxDODjhaTgJCP4+q++AStbTSXdg==;EndpointSuffix=core.windows.net";

        // Create a BlobServiceClient object using a connection string
        BlobServiceClient client = new BlobServiceClientBuilder()
                .connectionString(connectStr)
                .buildClient();

        BlobContainerClient blobContainerClient = client.getBlobContainerClient("cohort-3");

        BlobClient blobClient = blobContainerClient.getBlobClient("output/" + filename );

        BinaryData content = blobClient.downloadContent();

        return content.toString();
    }
}
