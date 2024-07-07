import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.sound.sampled.*;

public class FileManager {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {





        // Запуск аудио файла
        Scanner scanner = new Scanner(System.in);

        File a = new File("C:\\Users\\maxis\\OneDrive\\Рабочий стол\\Proggers\\java\\Shulk.wav");
        File b = new File("C:\\Users\\maxis\\OneDrive\\Рабочий стол\\Proggers\\java\\otherside.wav");
        File c = new File("C:\\Users\\maxis\\OneDrive\\Рабочий стол\\Proggers\\java\\relic.wav");
        File[] line = new File[] {a, b, c};
        ArrayList <Clip> playlist = new ArrayList<Clip>();
        for(int i =0; i < line.length; i++)
        {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(line[i]);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            playlist.add(clip);
        }
        

        int num = 0;
        // clip.start();
        
        String response = "P";
        while(!response.equals("Q"))
        {
            System.out.println("P - play, S = stop, R = reset, Q = quit, N = next song");
            System.out.print("Enter your choice: ");
            response = scanner.next();
            response = response.toUpperCase();

        
            switch (response)
            {
                case ("P"): getAudio(playlist, num).start();
                break;
                case ("S"): getAudio(playlist, num).stop();
                break;
                case ("R"): getAudio(playlist, num).setMicrosecondPosition(0);
                break;
                case ("Q"): getAudio(playlist, num).close();
                case ("N"):
                getAudio(playlist, num).setMicrosecondPosition(0);
                getAudio(playlist, num).stop();
                num++;
                if(num >= playlist.size())
                {
                    num = 0;
                }
                getAudio(playlist, num).start();
                // System.out.println(num);
                break;
                default: System.err.println("Not a valid responsr");
            }
        }
        System.err.println("Byeeee!");


        // File file = new File("C:\\Users\\maxis\\OneDrive\\Рабочий стол\\Proggers\\java\\secret.txt");
        // try 
        // {
        //     FileWriter writer = new FileWriter("C:\\\\Users\\\\maxis\\\\OneDrive\\\\Рабочий стол\\\\Proggers\\\\java\\\\test.txt");
        //     writer.write("Nigga! \nGay! \nBooty B");
        //     writer.append("\n(My text)");


        //     writer.close();
        // } catch (Exception e) 
        // {
        // }
        
        // if (file.exists())
        // {
        //     System.out.println("This file exists");
        //     System.out.println(file.getPath());
        //     System.out.println(file.getAbsolutePath());
        //     // file.delete();
            
        // }
        // else
        // {
        //     System.out.println("This file not exist");
        // }
        // try
        // {
        //     FileReader reader = new FileReader("C:\\Users\\maxis\\OneDrive\\Рабочий стол\\Proggers\\java\\art.txt");
        //     int data = reader.read();
        //     while(data != -1)
        //     {
        //         System.out.print((char)data);
        //         data = reader.read();
        //     }
        //     reader.close();
        // }
        // catch(Exception e)
        // {
        //     System.err.println("Something went wrong!");
        // }

    }
    public static Clip getAudio(ArrayList<Clip> player, int numb)
    {
        
        Clip curClip = player.get(numb);
        return curClip;
    }
}
