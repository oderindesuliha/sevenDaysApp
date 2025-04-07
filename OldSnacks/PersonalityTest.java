import java.util.Scanner;

public class PersonalityTest {
    public static void main(String... args) {
        Scanner input = new Scanner(System.in);

        int extrovert = 0, introvert = 0;
        int sensing = 0, intuitive = 0;
        int thinking = 0, feeling = 0;
        int judging = 0, perceiving = 0;

        System.out.println("---------------------------");
        System.out.println("MBTI Personality Test");
        System.out.println("---------------------------");

        System.out.print("What is your name? ");
        String name = input.nextLine();

        System.out.println("""
        1. 	EXTROVERT E vs INTROVERT I
        A. Expend energy, enjoy groups
        B. Conserve energy, enjoy one-on-one
        """);
        char userInput = validation(input);
        if (userInput == 'A') extrovert++; else introvert++;

        System.out.println("""
        2. 	SENSING S vs INTUITIVE N        
        A. Interpret literally
        B. Look for meaning and possibilities
        """);
        userInput = validation(input);
        if (userInput == 'A') sensing++; else intuitive++;

        System.out.println("""
        3. 	THINKING T vs FEELING F        
        A. Logical, thinking and questioning
        B. Empathetic, feeling and accommodating
        """);
        userInput = validation(input);
        if (userInput == 'A') thinking++; else feeling++;

        System.out.println("""
        4. 	JUDGING J vs PERCEPTIVE P        
        A. Organized and orderly
        B. Flexible and adaptable
        """);
        userInput = validation(input);
        if (userInput == 'A') judging++; else perceiving++;

        System.out.println("""
        5. 	EXTROVERT E vs INTROVERT I
        A. More outgoing, think out loud
        B. More reserved, think to yourself
        """);
        userInput = validation(input);
        if (userInput == 'A') extrovert++; else introvert++;

        System.out.println("""
        6. 	SENSING S vs INTUITIVE N        
        A. Practical, realistic, experiential
        B. Imaginative, innovative, theoretical
        """);
        userInput = validation(input);
        if (userInput == 'A') sensing++; else intuitive++;

        System.out.println("""
        7. 	THINKING T vs FEELING F        
        A. Candid, straightforward, frank
        B. Tactful, kind, encouraging
        """);
        userInput = validation(input);
        if (userInput == 'A') thinking++; else feeling++;

        System.out.println("""
        8. 	JUDGING J vs PERCEPTIVE P        
        A. Plan, schedule
        B. Unplanned, spontaneous
        """);
        userInput = validation(input);
        if (userInput == 'A') judging++; else perceiving++;

        System.out.println("""
        9.	EXTROVERT E vs INTROVERT I
        A. Seek many tasks, public activities, interaction with others
        B. Seek private, solitary activities with quiet to concentrate
        """);
        userInput = validation(input);
        if (userInput == 'A') extrovert++; else introvert++;

        System.out.println("""
        10. 	SENSING S vs INTUITIVE N        
        A. Firm, tend to criticize, hold the line
        B. Gentle, tend to appreciate, conciliate
        """);
        userInput = validation(input);
        if (userInput == 'A') sensing++; else intuitive++;

        System.out.println("""
        11. 	THINKING T vs FEELING F        
        A. Tough-minded, just
        B. Tender-hearted, merciful
        """);
        userInput = validation(input);
        if (userInput == 'A') thinking++; else feeling++;

        System.out.println("""
        12. 	JUDGING J vs PERCEPTIVE P        
        A. Regulated, structured
        B. Easy-going, live and let live
        """);
        userInput = validation(input);
        if (userInput == 'A') judging++; else perceiving++;

        System.out.println("""
        13. 	EXTROVERT E vs INTROVERT I
        A. External, communicative, express yourself
        B. Internal, reticent, keep to yourself
        """);
        userInput = validation(input);
        if (userInput == 'A') extrovert++; else introvert++;

        System.out.println("""
        14. 	SENSING S vs INTUITIVE N        
        A. Focus on here-and-now
        B. Look to the future, global perspective, big picture
        """);
        userInput = validation(input);
        if (userInput == 'A') sensing++; else intuitive++;

        System.out.println("""
        15. 	THINKING T vs FEELING F        
        A. Matter-of-fact, issue-oriented
        B. Sensitive, people-oriented, compassionate
        """);
        userInput = validation(input);
        if (userInput == 'A') thinking++; else feeling++;

        System.out.println("""
        16. 	JUDGING J vs PERCEPTIVE P        
        A. Preparation, plan ahead
        B. Go with the flow, adapt as you go
        """);
        userInput = validation(input);
        if (userInput == 'A') judging++; else perceiving++;

        System.out.println("""
        17. 	EXTROVERT E vs INTROVERT I
        A. Active, initiate
        B. Reflective, deliberate
        """);
        userInput = validation(input);
        if (userInput == 'A') extrovert++; else introvert++;

        System.out.println("""
        18. 	SENSING S vs INTUITIVE N        
        A. Facts, things, what is
        B. Ideas, dreams, what could be, philosophical
        """);
        userInput = validation(input);
        if (userInput == 'A') sensing++; else intuitive++;

        System.out.println("""
        19. 	THINKING T vs FEELING F        
        A. Logical, questioning
        B. Compassionate, empathetic
        """);
        userInput = validation(input);
        if (userInput == 'A') thinking++; else feeling++;

        System.out.println("""
        20. 	JUDGING J vs PERCEPTIVE P        
        A. Control, govern
        B. Latitude, freedom
        """);
        userInput = validation(input);
        if (userInput == 'A') judging++; else perceiving++;

       
        char ei = (extrovert >= introvert) ? 'E' : 'I';
        char sn = (sensing >= intuitive) ? 'S' : 'N';
        char tf = (thinking >= feeling) ? 'T' : 'F';
        char jp = (judging >= perceiving) ? 'J' : 'P';

        String mbtiType = "" + ei + sn + tf + jp;

        System.out.println("----------------------------------------------------");
        System.out.println("Hello " + name);
        System.out.println("Your MBTI Personality Type is: " + mbtiType);
        System.out.println("----------------------------------------------------");

        }

    public static char validation(Scanner input) {
        char userInput = input.next().charAt(0);
        while (userInput != 'A' && userInput != 'B') {
            System.out.println("Invalid input. Please answer A or B.");
        userInput = input.next().charAt(0);
        }
        return userInput;
    }
}