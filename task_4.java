import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class task_4 {
    public static void main( String[] args ) throws IOException {
        Logger log = create_logger();

        print( "\nПрограмма калькулятор, очень простой... но с логированием\n" );

        Scanner iScanner = new Scanner( System.in );

        print( "\nВведите первое число: " );
        int number_1  = iScanner.nextInt();

        String[] validInputs = {"-", "+", "*", "/"};
        String operator = "";

        // Fix ввода
        while (!Arrays.asList(validInputs).contains(operator)) {
            print( "\nВведите оператор -, +, *, /: " );
            operator = iScanner.next();
        }

        // Fix деление на 0
        print( "\nВведите второе число: " );
        int number_2  = iScanner.nextInt();
        while ( operator.equals( "/" ) && number_2 == 0 ) {
            print( "\nДелить на 0 нельзя!!!" );
            print( "\nВведите второе число: " );
            number_2 = iScanner.nextInt();
        }

        iScanner.close();
        int result = very_simple_calculator( operator, number_1, number_2 );

        String result_str = number_1 + " " + operator + " " + number_2 + " = " + result + "\n";
        print( "\n" + result_str + "\n" );
        log.log( Level.INFO, result_str );
    }


    // метод получения результата
    static int very_simple_calculator( String operator, int number_1, int number_2 ) {
        int result = 0;

        switch ( operator ) {
            case "+":
                result = number_1 + number_2;
                break;
            case "-":
                result = number_1 - number_2;
                break;
            case "*":
                result = number_1 * number_2;
                break;
            case "/":
                result = number_1 / number_2;
                break;
        }
        return result;
    }


    // Тест реализации Python подобной функции print (упрощенной)
    public static void print( String message ) {
        System.out.printf( message );
    }


    // Логер без вывода в консоль
    static Logger create_logger() throws IOException {
        Logger log = Logger.getLogger( task_4.class.getName() );

        FileHandler fh = new FileHandler( "task_4.log", true );
        fh.setFormatter( new SimpleFormatter() );

        log.addHandler( fh );

        // Отключаем вывод в консоль
        log.setUseParentHandlers( false );
        return log;
    }
}
