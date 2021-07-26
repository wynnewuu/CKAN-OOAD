/**
 * Displays Data Vizualisation options
 *
 * @author Jose Guillen Santos
 * @version 0.0.1
 */


import java.util.InputMismatchException;
import java.util.Scanner;

public class RecordVisualizer{
    public RecordList records;
    public RecordVisualizer(RecordList records){
        this.records = records;
    }

    public void displayVisualization() {

        boolean done = false;
        char selection;

        do
        {
            displayMenu();
            selection = getSelection("bmplhx");
            switch(selection)
            {
                case 'l':
                    visualizeLine(records);
                    break;
                case 'b':
                    break;
                case 'm':
                    System.out.println("TODO");
                    //todo
                    break;
                case 'g':
                    System.out.println("TODO");
                    //todo
                    break;
                case 'p':
                    System.out.println("TODO");
                    //todo
                    break;
                case 'h':
                    System.out.println("TODO");
                    //todo
                    break;
                case 'x':
                    done = true;
                    break;
                default:
                    // should not happen if you did the input right!
            }
        }while(!done);


    }

    public char getSelection(String optionString){
        Scanner sc = new Scanner(System.in);
        char c='x';
        String pattern = "["+optionString.toLowerCase() + optionString.toUpperCase()+"]";
        boolean done = false;

        do
        {
            try
            {
                c = sc.next(pattern).trim().charAt(0);
                c =  Character.toLowerCase(c);
                done = true;
            }
            catch(InputMismatchException imme)
            {
                done = false;
            }
        }while(!done);

        System.out.println("user selection = ["+c+"]");
        return c;
    }
    public void displayMenu()
    {
        System.out.print("[L]ine Graph | [B]ar Graph | [M]ap | [P]ie Graph | [L]ogarithmic Graph | [H]eat Map  | E[x]it>>");
    }

    public static void visualizeLine(RecordList records){ //asks user for columns that are going to be x and y values then provides bar graph visualization
        Scanner scan = new Scanner(System.in);
        int x,y;
        String output = "";
        System.out.println();
        for (int i = 0; i < records.getFieldNumber(); i++) { //iterates through all field labels
            output+=String.format("OPTION %d: %s\n", i, records.getFieldLabels().get(i));
        }
        System.out.println(output);
        System.out.printf("X Variable >>>    "); //sets to x


        try { //try catch for input
            x = Integer.parseInt(scan.next());
            if (x<0 || x>records.getFieldNumber()){
                System.out.println("Invalid digit");
                return;
            }
        } catch (NumberFormatException e){
            System.out.println("Wrong input type.");
            return;
        }
        output = "";
        System.out.println();
        for (int i = 0; i < records.getFieldNumber(); i++) { //iterates through all field labels
            if (i != x)
                output+=String.format("OPTION %d: %s\n", i, records.getFieldLabels().get(i)); //gives options for all but one chose
        }
        System.out.println(output);
        System.out.printf("Y Variable >>>    "); //sets to x


        try { //try catch for input
            y = Integer.parseInt(scan.next());
            if (y<0 || y>records.getFieldNumber() || y == x){
                System.out.println("Invalid digit");
                return;
            }
        } catch (NumberFormatException e){
            System.out.println(e);
            System.out.println("Wrong input type.");
            return;
        }
        LineGraph graph = new LineGraph(records, x, y);
        graph.displayGraph();
    }

}



