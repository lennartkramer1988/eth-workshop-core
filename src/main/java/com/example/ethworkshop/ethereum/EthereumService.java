package com.example.ethworkshop.ethereum;

import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;

import com.example.ethworkshop.ethereum.greeter.Greeter;
import com.example.ethworkshop.greeting.Greeting;

@Service
public class EthereumService {

    private final Web3j web3j;
    private final String clientVersion;
    private final Credentials credentials;
    private final Greeter greeter;

    public EthereumService(EthereumConfigProperties ethereumConfigProperties) throws Exception {
        this.web3j = Web3j.build(new HttpService());  // defaults to http://localhost:8545/
        Web3ClientVersion web3ClientVersion = web3j.web3ClientVersion().send();
        this.clientVersion = web3ClientVersion.getWeb3ClientVersion();
        this.credentials = WalletUtils.loadCredentials("justfortesting", ethereumConfigProperties.getWalletLocation());
        this.greeter = Greeter.deploy(
                web3j, credentials,
                ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT,
                "Len says hi from the blockchain!").send();
    }

    public Greeting getGreeting() throws Exception {
        final String greeterValue = greeter.greet().send();
        return new Greeting(greeterValue);
    }
}
