import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class File2 {
    static String path;
    static File file;
    static BufferedReader br;
    static Scanner scr = new Scanner(System.in);
    static int count = 0;

    public static void main(String[] args) {
        System.out.println("Программа, вычисляющая число слов в произвольном текстовом файле, "
                + "каждое из которых содержит не менее трех символов 'r'");
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
                    System.out.println("Невозможно прочитать файл по этому пути");
            }
            else
                System.out.println("Невозможно найти файл по этому пути");
        }
        try {
            br = new BufferedReader
                    (new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                String[] words = line.split(" ");
                int buffer = 0;
                for (int i=0; i< words.length; i++)
                {
                    //	System.out.println(words[i]);
                    buffer = 0;
                    for (int j =0; j < words[i].length(); j++)
                    {
                        if (words[i].charAt(j) == 'r')
                            buffer++;
                    }
                    if (buffer >= 3)
                        count++;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Число слов, каждое из которых\nсодержит не менее трех символов 'r' = " + count);
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
                System.out.println(e + " Ошибка. Попробуйте ввести путь ещё раз");
                scr.next();
            }
        }
        return str;
    }
}