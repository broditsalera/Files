import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

//Программа, которая вычисляет количество символов 'r' в произвольном текстовом файле.

public class File1 {
    static String path;
    static File file;
    static BufferedReader br;
    static Scanner scr = new Scanner(System.in);
    static int count = 0;

    public static void main(String[] args) {
        System.out.println("Программа, вычисляющая количество символов 'r' в произвольном текстовом файле");
        while (true)
        {
            System.out.println("Введите путь к файлу: ");
            path = Imput();
            file = new File(path);
            if(file.exists())
            {
                if (file.canRead())
                    break;
                else
                    System.out.println("Невозможно прочитать файл по заданному пути");
            }
            else
                System.out.println("Невозможно найти файл по заданному пути");
        }
        try {
            br = new BufferedReader
                    (new InputStreamReader(new FileInputStream(file), "UTF-8"));

            String line = null;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                for(int i = 0; i < line.length(); i++)
                {
                    if (line.charAt(i) == 'r')
                        count++;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Количество символов 'r': " + count);
    }
    private static String Imput()
    {
        String str;
        while (true)
        {
            try
            {
                str = scr.nextLine();
                break;
            }
            catch (Exception e)
            {
                System.out.println(e + " - Ошибка. Введите путь ещё раз");
                scr.next();
            }
        }
        return str;
    }
}