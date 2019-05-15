package utility;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.ClosePrice;
import model.Company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.List;

public class FileHelper {

    public static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("MM-dd-yyyy");
    private static final ObjectMapper mapper = new ObjectMapper();

    
    public static Stock readSingleStock(String fileName) throws IOException {
        InputStream inputStream = new FileInputStream(("resources/data" + File.separatorChar + fileName));
//        InputStream resourceAsStream = FileHelper.class.getClassLoader().getResourceAsStream(fileName);
        return mapper.readValue(inputStream, new TypeReference<Stock>() {});
    }

    // reads the stock data from the file and returns it in a list of stock objects
    public static List<Stock> readAllStocks(String fileName) throws IOException {
        InputStream inputStream = new FileInputStream(("resources/data" + File.separatorChar + fileName));
//        InputStream resourceAsStream = FileHelper.class.getClassLoader().getResourceAsStream(fileName);
        return mapper.readValue(inputStream, new TypeReference<List<Stock>>() {
        });
    }

    // reads the companies from the file and returns it in a list of company objects
    public static List<Company> readCompaniesFromFile(String fileName) throws IOException {
        InputStream inputStream = new FileInputStream(("resources/data" + File.separatorChar + fileName));
//        InputStream resourceAsStream = FileHelper.class.getClassLoader().getResourceAsStream(fileName);
        return mapper.readValue(inputStream, new TypeReference<List<Company>>() {});
    }

    public static Company readCompanyFromFile(String fileName) throws IOException {
        InputStream inputStream = new FileInputStream(("resources/data" + File.separatorChar + fileName));
//        InputStream resourceAsStream = FileHelper.class.getClassLoader().getResourceAsStream(fileName);
        return mapper.readValue(inputStream, new TypeReference<Company>() {});
    }

    public static void writeCompaniesToFile(String fileName, List<Company> comp) throws IOException {

        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("resources/data", fileName), comp);
    }

    public static void writeCompaniesToFile(String fileName, Company comp) throws IOException {
        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("resources/data", fileName), comp);
    }


    public static void writeStockToFile(String fileName, ClosePrice stock) throws IOException {
        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("resources/data", fileName), stock);
    }

    public static void writeStocksToFile(String fileName, List<ClosePrice> stocks) throws IOException {
        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("resources/data", fileName), stocks);
    }
}
