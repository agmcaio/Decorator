import model.CompressionDecorator;
import model.DataSourceDecorator;
import model.EncryptionDecorator;
import model.FileDataSource;

public class Decorator {
    public static void main(String[] args) {
        String message = "Mensagem a ser gravada";

        FileDataSource fileDataSource = new FileDataSource("output.txt");

        DataSourceDecorator encoded = new CompressionDecorator(
                new EncryptionDecorator(fileDataSource));

        encoded.writeData(message);

        String result = encoded.readData();

        System.out.println("\nResultado após a leitura: " + result);
    }
}