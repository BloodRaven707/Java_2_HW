import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;


public class task_3 {
    public static void main( String[] args ) throws IOException {
        // Считываем инфо из файла data.json
        String json = Files.readString( Paths.get( "task_3_data.json" ) );

        print_strings( json );
    }

    private static void print_strings( String json ) {
        Gson gson = new Gson();
        Student[] students = gson.fromJson( json, Student[].class );
        System.out.println();
        for ( Student student : students ) {
            System.out.printf( "Студент %s получил %s по предмету %s\n", student.surname, student.mark, student.subject );
        }
        System.out.println();
    }

    // Класс, соответствующий структуре json {"фамилия":"Иванов","оценка": 5,"предмет":"Математика"}
    private static class Student {
        @SerializedName( "фамилия" )
        String surname;
        @SerializedName( "оценка" )
        String mark;
        @SerializedName( "предмет" )
        String subject;

        private Student( String surname, String mark, String subject ) {
            this.surname = surname;
            this.mark = mark;
            this.subject = subject;
        }
    }
}
