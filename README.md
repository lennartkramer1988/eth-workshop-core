# eth-workshop-core

### Solidity compiler
Used to generate the ABI (Application Binary Interface) and Binary code for the smart contract.

Install command line interface
```
npm install -g solc
```

Compile solidity class to .bin and .abi
```
solcjs src/main/resources/contracts/greeter/Greeter.sol --bin --abi --optimize -o src/main/resources/contracts/greeter/build
```

### Web3j command line tool
Used to generate Java class based on the abi, binary code is used to deploy the contract.

Install command line interface
```
brew tap web3j/web3j
brew install web3j
```

Generate a java class based on .bin and .abi
```
web3j solidity generate src/main/resources/contracts/greeter/build/greeter.bin src/main/resources/contracts/greeter/build/greeter.abi -o src/main/java -p com.example.ethworkshop.ethereum.greeter
```