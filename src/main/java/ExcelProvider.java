import org.apache.poi.ss.extractor.ExcelExtractor;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class ExcelProvider implements ArgumentsProvider {

    private List<String> readFromFile(){
        List<String> lines = new LinkedList<>();
        String path = "";

        try (XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(new File(path)))){
            ExcelExtractor excelExtractor = new XSSFExcelExtractor(myExcelBook);
            String[] fileLines = excelExtractor.getText().split("\n");
            lines.addAll(Arrays.asList(fileLines));
        } catch (Exception e){
           e.printStackTrace();
        }

        return lines;
    }

    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext){
        return readFromFile().stream().map(Arguments::of);
    }
}

