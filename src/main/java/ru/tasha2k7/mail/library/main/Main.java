package ru.tasha2k7.mail.library.main;

import com.google.gson.*;
import ru.tasha2k7.mail.library.services.impl.BooksServiceImpl;

import java.util.Scanner;
import java.io.*;

public class Main {

    public static final String PATH_JSON = "src/main/resources/library.json";
    //public static final String PATH_JSON = "src/resources/library.json";
    //public static final String PATH_JSON = "C:/Lib/library.json";

    public static final String PATH_TITLE = "src/main/resources/search/title.json";
    public static final String PATH_AUTHOR = "src/main/resources/search/author.json";
    public static final String PATH_GENRE = "src/main/resources/search/genre.json";
    public static final String PATH_YEAR = "src/main/resources/search/year.json";
    public static final String PATH_PUBLISHING = "src/main/resources/search/publishing.json";
    public static final String PATH_CLIENT = "src/main/resources/search/client.json";
    public static final String PATH_EXPIRED = "src/main/resources/search/expired.json";

    public static final String FOLDER_TITLE = "src/main/resources/title/";
    //public static final String FOLDER_TITLE = "C:/Lib/title/";
    public static final String FOLDER_AUTHOR = "src/main/resources/author/";
    public static final String FOLDER_GENRE = "src/main/resources/genre/";
    public static final String FOLDER_YEAR = "src/main/resources/year/";
    public static final String FOLDER_PUBLISHING = "src/main/resources/publishing/";
    public static final String FOLDER_CLIENT = "src/main/resources/client/";
    public static final String FOLDER_EXPIRED = "src/main/resources/expired/";

    public static void main(String[] args) {

        BooksServiceImpl booksService = new BooksServiceImpl();

        /*    Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Books.class, new BooksSerializer())
                .registerTypeAdapter(Author.class, new AuthorSerializer())
                .registerTypeAdapter(Client.class, new ClientSerializer())
                .registerTypeAdapter(Genre.class, new GenreSerializer())
                .registerTypeAdapter(Journal.class, new JournalSerializer())
                .registerTypeAdapter(Library.class, new LibrarySerializer())
                .create();*/

       /*   BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(PATH_JSON));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject json = gson.fromJson(bufferedReader, JsonObject.class);
        System.out.println(json.getClass());
        //System.out.println(json.toString());*/

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonObject json = new JsonObject();
        JsonParser parser = new JsonParser();
        try {
            JsonElement jsonElement = parser.parse(new FileReader(PATH_JSON));
            json = gson.fromJson(jsonElement.getAsJsonObject(), JsonObject.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //System.out.println(json.toString());

        //консоль
        System.out.println("Поиск книги. Выберите параметр поиска. Введите соответствующий номер:");
        System.out.println("1. По названию;");
        System.out.println("2. По автору;");
        System.out.println("-3. По жанру;");
        System.out.println("-4. По году;");
        System.out.println("-5. По издательству;");
        System.out.println("-6. По читателю;");
        System.out.println("-7. По сроку (должники).");
        System.out.println("Разбить данные по характеристике в файлы. Выберите характеристику. Введите соответствующий номер:");
        System.out.println("8. По названию;");
        System.out.println("9. По автору;");
        System.out.println("10. По жанру;");
        System.out.println("11. По году;");
        System.out.println("12. По издательству;");
        System.out.println("-13. По читателю;");
        System.out.println("-14. По читателю (должники)");
        System.out.println("15. По всем характеристикам (п.8-13).");
        System.out.println();

        Scanner scan = new Scanner(System.in);
        System.out.print("Параметр поиска: ");
        int param = scan.nextInt();
        //if (scan.hasNextInt()) {
        System.out.println();

        if (param == 1) {
            System.out.print("Введите наименование книги: ");
            String str = scan.next();

            // if (scan.hasNext()) {
            booksService.searchTitle(gson, json, PATH_TITLE, str.toLowerCase());
            //} else System.out.print("Введите наименование книги: ");
        }

        if (param == 2) {
            System.out.print("Введите автора: ");
            String str = scan.next();

            // if (scan.hasNext()) {
            booksService.searchAuthor(gson, json, PATH_AUTHOR, str.toLowerCase());
            //} else System.out.print("Введите наименование книги: ");
        }

        if (param == 3) {
            System.out.print("Введите автора: ");
            String str = scan.next();

            // if (scan.hasNext()) {
            booksService.searchGenre(gson, json, PATH_GENRE, str.toLowerCase());
            //} else System.out.print("Введите наименование книги: ");
        }

        if (param == 8) {
            booksService.parseToTitle(gson, json, FOLDER_TITLE);
        }

        if (param == 9) {
            booksService.parseToAuthor(gson, json, FOLDER_AUTHOR);
        }

        if (param == 10) {
            booksService.parseToGenre(gson, json, FOLDER_GENRE);
        }

        if (param == 11) {
            booksService.parseToYear(gson, json, FOLDER_YEAR);
        }

        if (param == 12) {
            booksService.parseToPublishing(gson, json, FOLDER_PUBLISHING);
        }

        if (param == 13) {
            booksService.parseToClient(gson, json, FOLDER_CLIENT);
        }

        if (param == 14) {
            booksService.parseToExpired(gson, json, FOLDER_EXPIRED);
        }

        if (param == 15) {
            booksService.parseToTitle(gson, json, FOLDER_TITLE);
            booksService.parseToAuthor(gson, json, FOLDER_AUTHOR);
            booksService.parseToGenre(gson, json, FOLDER_GENRE);
            booksService.parseToYear(gson, json, FOLDER_YEAR);
            booksService.parseToPublishing(gson, json, FOLDER_PUBLISHING);
            // booksService.parseToClient(gson, json, FOLDER_CLIENT);
        }
        /*}
        else System.out.print("Некорректно введен параметр. Введите номер пункта, соответствующий параметру поиска. ");*/
    }
}
