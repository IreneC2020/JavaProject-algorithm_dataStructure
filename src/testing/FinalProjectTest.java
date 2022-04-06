package testing;

import utility.MyStack;
import utility.FinalProject;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class FinalProjectTest {
    public static void consoleTest() {
        MyStack<String> currentStack       = new MyStack<>();
        MyStack<String> popStack           = new MyStack<>();
        FinalProject testProj = new FinalProject(currentStack, popStack);

        // first add
        currentStack.push("first");

        System.out.println("original: " + currentStack);
        System.out.println("currentStack size: " + currentStack.size());

        System.out.println("------------UNDO TEST-----------");
        testProj.undo();
        System.out.println("<1 undo>\ncurrent stack:" + currentStack);
        System.out.println("currentStack size: " + currentStack.size());
        System.out.println("currentStack empty? " + currentStack.isEmpty());
        System.out.println("popStack size: " + popStack.size());
        System.out.println("popStack empty? " + popStack.isEmpty());

        System.out.println("------------REDO TEST-----------");
        testProj.redo();
        System.out.println("<1 redo>\ncurrent stack: " + currentStack);
        System.out.println("currentStack size: " + currentStack.size());
        System.out.println("currentStack empty? " + currentStack.isEmpty());
        System.out.println("popStack size: " + popStack.size());
        System.out.println("popStack empty? " + popStack.isEmpty());

        System.out.println("------------REDO TEST-----------");
        testProj.redo();
        System.out.println("<2 redo>\ncurrent stack: " + currentStack);
        System.out.println("currentStack size: " + currentStack.size());
        System.out.println("currentStack empty? " + currentStack.isEmpty());
        System.out.println("popStack size: " + popStack.size());
        System.out.println("popStack empty? " + popStack.isEmpty());

        System.out.println("------------ADD TEST-----------");
        currentStack.push("second");
        System.out.println("<2 add>\n" + currentStack);
        System.out.println("currentStack size: " + currentStack.size());
        System.out.println("currentStack empty? " + currentStack.isEmpty());
        System.out.println("popStack size: " + popStack.size());
        System.out.println("popStack empty? " + popStack.isEmpty());


        System.out.println("------------REDO TEST-----------");
        testProj.redo();
        System.out.println("<1 redo>\ncurrent stack: " + currentStack);
        System.out.println("currentStack size: " + currentStack.size());
        System.out.println("currentStack empty? " + currentStack.isEmpty());
        System.out.println("popStack size: " + popStack.size());
        System.out.println("popStack empty? " + popStack.isEmpty());

        System.out.println("------------UNDO TEST-----------");
        testProj.undo();
        System.out.println("<1 undo>\ncurrent stack:" + currentStack);
        System.out.println("currentStack size: " + currentStack.size());
        System.out.println("currentStack empty? " + currentStack.isEmpty());
        System.out.println("popStack size: " + popStack.size());
        System.out.println("popStack empty? " + popStack.isEmpty());

        System.out.println("------------UNDO TEST-----------");
        testProj.undo();
        System.out.println("<2 undo>\ncurrent stack:" + currentStack);
        System.out.println("currentStack size: " + currentStack.size());
        System.out.println("currentStack empty? " + currentStack.isEmpty());
        System.out.println("popStack size: " + popStack.size());
        System.out.println("popStack empty? " + popStack.isEmpty());

        System.out.println("------------UNDO TEST-----------");
        testProj.undo();
        System.out.println("<3 undo>\ncurrent stack:" + currentStack);
        System.out.println("currentStack size: " + currentStack.size());
        System.out.println("currentStack empty? " + currentStack.isEmpty());
        System.out.println("popStack size: " + popStack.size());
        System.out.println("popStack empty? " + popStack.isEmpty());

        System.out.println("----------console test finished!------------");
        System.out.println();
        System.out.println();
    }

    public static void intro() {
        System.out.println("Hi there! This program is to help you to create a text file in result folder.");
        System.out.println("If you want to add a string to your file, enter 'A or a'.");
        System.out.println("If you want to undo what you have done, enter 'U or u'. ");
        System.out.println("If you want to redo it, enter 'R or r'. ");
        System.out.println("If you finish, enter 'E or e'.");
        System.out.println("Have fun!");
        System.out.println("------------Program start!-----------");
    }

    public static void userInputTest() throws FileNotFoundException {
        MyStack<String> currentStack   = new MyStack<>();
        MyStack<String> popStack       = new MyStack<>();
        FinalProject testProj          = new FinalProject(currentStack, popStack);
        Scanner conIn                  = new Scanner(System.in);
        String userChoice;
        String choice;
        intro();
        do {
            System.out.print("Enter your choice(u, r, a or e): ");
            userChoice = conIn.nextLine();
            choice = userChoice.toLowerCase(Locale.ROOT);

            if (choice.equals("u") || choice.equals("r") || choice.equals("a")) {
                switch (choice) {
                    case "u" -> testProj.undo();
                    case "r" -> testProj.redo();
                    case "a" -> {
                        System.out.print("What do you want to add to the file? ");
                        String item = conIn.nextLine();
                        testProj.addString(item);
                    }
                }
            }
        } while (!choice.equals("e"));
        testProj.write();
        System.out.println("Thank you for using our program. Your file is inside results folder, " +
                "called <finalProject-result.txt>");
        conIn.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        consoleTest();
        userInputTest();
    }
}
