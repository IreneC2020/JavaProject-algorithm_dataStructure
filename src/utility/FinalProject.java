package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class FinalProject {
    private final MyStack<String> currentStack;
    private final MyStack<String> popStack;

    public FinalProject(MyStack<String> currentStack, MyStack<String> popStack) {
        this.currentStack = currentStack;
        this.popStack     = popStack;
    }

    public void redo() {
        if (popStack.size() == 0) {
            String message = "We cannot process your requests. You may have redone everything.";
            System.out.println(message);
        } else {
            String redoValue = popStack.pop();
            currentStack.push(redoValue);
            System.out.println("Your request completed successfully.");
        }
    }

    public void undo() {
        if (currentStack.size() == 0) {
            String message = "Your file is empty. We cannot undo anything. ";
            System.out.println(message);
        } else {
            String popValue = currentStack.pop();
            popStack.push(popValue);
            System.out.println("Your request completed successfully.");
        }
    }

    public void addString(String item){
        // simulate what MS word does, once the user start writing again, no more redo left
        while(!popStack.isEmpty()){
            popStack.pop();
        }
        currentStack.push(item);
    }

    public void write() throws FileNotFoundException {
        String outputLocation   = "." + File.separator + "results"
                + File.separator + "finalProject-result.txt";
        PrintStream output      = new PrintStream(outputLocation);
        StringBuilder builder   = new StringBuilder();
        ArrayList<String> list  = new ArrayList<>();
        while(!currentStack.isEmpty()){
            list.add(currentStack.pop());
        }
        for (int i = list.size() - 1; i >= 0 ; i--) {
            builder.append(list.get(i)).append("\n");
        }
        output.print(builder);
        output.close();
    }
}
