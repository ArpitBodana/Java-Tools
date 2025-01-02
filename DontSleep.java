import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DontSleep {

    private static  Boolean check=false;
    
    private static final String dateTimePattern = "HH:mm:ss dd-MM-yyyy";

    public static void main(String[] args) {

        WelcomeText();

        //INFO : Change the delay time by updating the integer variable delayInMinutes accordingly.
        int delayInMinutes= 2;

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Runnable jiggleTask = () -> {
            check=!check;
            try {
                Robot robot = new Robot();
                Point currentPosition = MouseInfo.getPointerInfo().getLocation();

                int X = currentPosition.x+(check?10:-10);
                int Y = currentPosition.y+(check?10:-10);

                robot.mouseMove(X,Y);

                System.out.println(getTimeStamp()+" : Just Jiggled");

            }catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("\n"+getTimeStamp()+" : Oops! Something went wrong. Let's don't sleep and try again.");
            }
        };

        System.out.println(getTimeStamp()+" : Beginning the jiggling movement");

        scheduler.scheduleAtFixedRate(jiggleTask,0,delayInMinutes, TimeUnit.MINUTES);
    }

    public static void WelcomeText(){
        String header = """
                ===============================================
                  *~*~*~* Don't Sleep bY Arpit Bodana *~*~*~*
                ===============================================""";
        System.out.println(header);


        System.out.println("\n> Welcome to the *ULTIMATE* 'Don't Sleep' Program!");
        System.out.println("> This program will simulate **mouse movement** to prevent your computer from entering sleep mode.");
        System.out.println("> Simply relax and let it keep your system awake while you enjoy your work or entertainment!\n");

        System.out.println("    * Adjust the delay time by modifying the integer variable delayInMinutes as necessary. *");
        System.out.println("    * Press 'Ctrl + C' to gracefully stop the program anytime. *");
        System.out.println("    * Stay active, and your PC will stay awake! *\n");


        System.out.println("-----------------------------------------------------");
        System.out.println("  * Don't sleep! Stay awake! Keep winning! *");
        System.out.println("-----------------------------------------------------\n");

        System.out.println("----------------------* Logs *-----------------------");

    }

    public static String getTimeStamp(){

        LocalDateTime currentDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimePattern);

       return currentDateTime.format(formatter);
    }


}


/**
 * Developer: Arpit Bodana
 * Role: Full Stack Java Developer
 *
 * A skilled Java Full Stack Developer with a solid understanding of both front-end and back-end technologies.
 * Having successfully contributed to the development of scalable and efficient applications using a combination of Java, Spring boot Framework,
 * React, HTML, CSS, JavaScript, and various other technologies.
 *
 * Also the creator of the innovative "Don't Sleep" java program, a unique solution designed to help users stay awake, increase productivity,
 * and optimize their digital workflows. The program leverages modern algorithms and user experience best practices to prevent screen idle time
 * and maintain user engagement, enhancing overall performance and focus.
 *
 * Key Technologies Used:
 * - Java
 *
 * Contributions:
 * - Developed the core architecture of the "Don't Sleep" program
 *
 * My commitment to creating high-quality, user-centric applications is evident in every project he undertakes.
 * My passion for software development and problem-solving is what drives his ongoing success as a full-stack developer.
 */


