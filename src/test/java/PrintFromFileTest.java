import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

class PrintFromFileTest {

    @ParameterizedTest
    @ArgumentsSource(ExcelProvider.class)
    void print(String lines){
       System.out.println(lines);
    }
}
