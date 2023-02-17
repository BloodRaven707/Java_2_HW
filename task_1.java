import java.util.*;

// Самое сложное это подключить их в VS Code...
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
// Maven так и не заработал...


public class task_1 {
    public static void main( String[] args ) {
        String json = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\": null }";

        String query = "SELECT * FROM students WHERE ";
        System.out.println( "\n" + query + createRequest( json ) + "\n" );
    }


    // Добавляем параметры к WHERE в SQL запросе
    static String createRequest( String jsonStr ) {
        // Gson gson = new Gson(); // Меньше мусора
        Map<String, Object> studentMap = new Gson().fromJson( jsonStr, new TypeToken<Map<String, Object>>(){}.getType() );
        StringBuilder sb = new StringBuilder();
        boolean fl = false;

        for ( Map.Entry<String, Object> entry : studentMap.entrySet() ) {
            if ( entry.getValue() != null ) {

                // Добавляем AND если больше 1 параметра
                if ( fl != false ) {
                    sb.append( " AND " );
                } else {
                    fl = true;
                }

                sb.append( entry.getKey() + "=" + entry.getValue() );
            }
        }

        // При формировании многострочных запросов обязательно ";" в конце строки
        sb.append( ";" );
        return sb.toString();
    }
}
