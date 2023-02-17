import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.*;


public class task_2 {
    public static void main( String[] args ) throws IOException {

        int[] my_arary = new Random().ints(10, -99, 100).toArray();
        System.out.println( "\nИсходный массив: \t" + Arrays.toString( my_arary ) );

        int[] sort_array = bubble_sort( Arrays.copyOf(my_arary, my_arary.length) );
        System.out.println( "Сортированный массив: \t" + Arrays.toString( sort_array ) +"\n" );
    }


    // Сортировка с логированием
    static int[] bubble_sort( int[] array ) throws IOException {
        Logger log = create_logger();

        int n = array.length;
        int[] sort_array = Arrays.copyOf( array, n );
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sort_array[j] > sort_array[j + 1]) {
                    int temp = sort_array[j];
                    sort_array[j] = sort_array[j + 1];
                    sort_array[j + 1] = temp;

                    log.log( Level.INFO, Arrays.toString(sort_array) + "\n" );
                }
            }
        }

        return sort_array;
    }


    // Логер без вывода в консоль
    static Logger create_logger() throws IOException {
        Logger log = Logger.getLogger( task_2.class.getName() );

        FileHandler fh = new FileHandler( "task_2.log", true );
        fh.setFormatter( new SimpleFormatter() );

        log.addHandler( fh );

        // Отключаем вывод в консоль
        log.setUseParentHandlers( false );
        return log;
    }
}