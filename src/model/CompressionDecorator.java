package model;

import interfaces.DataSource;

public class CompressionDecorator extends DataSourceDecorator {

    public CompressionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        String compressedData = compress(data);
        System.out.println("Compression: \n Dados comprimidos para write.");
        super.writeData(compressedData);
    }

    @Override
    public String readData() {
        String data = super.readData();
        String decompressedData = decompress(data);
        System.out.println("Compression: \n Dados descomprimidos após read.");
        return decompressedData;
    }

    private String compress(String data) {
        return data.substring(0, data.length() / 2);
    }

    private String decompress(String data) {
        return data + data;
    }
}