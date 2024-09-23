package model;

import interfaces.DataSource;

public class EncryptionDecorator extends DataSourceDecorator {

    public EncryptionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        String encryptedData = encode(data);
        System.out.println("Encryption: \n Dados criptografados para write.");
        super.writeData(encryptedData);
    }

    @Override
    public String readData() {
        String data = super.readData();
        String decryptedData = decode(data);
        System.out.println("Encryption: \n Dados descriptografados após read.");
        return decryptedData;
    }

    private String encode(String data) {
        return new StringBuilder(data).reverse().toString();
    }

    private String decode(String data) {
        return new StringBuilder(data).reverse().toString();
    }
}