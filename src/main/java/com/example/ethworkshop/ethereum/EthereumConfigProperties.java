package com.example.ethworkshop.ethereum;

import java.io.File;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.config.ethereum")
public class EthereumConfigProperties {
    private File walletLocation;

    public File getWalletLocation() {
        return walletLocation;
    }

    public void setWalletLocation(File walletLocation) {
        this.walletLocation = walletLocation;
    }
}
