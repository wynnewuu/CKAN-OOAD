/** DatasetViewer is a DataViewer... so it can displayDataset()
 This is a text mode interactive implementation of the viewer.

 @author Jose Guillen Santos

 */
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DatasetViewer extends DataViewer {

    public DatasetViewer(){
        super();
    }

    public void displayViewer(){
        boolean done = false;
        currentDataset=0;
        char selection;

        displayDataset();

        do
        {
            displayMenu();
            selection = getSelection("fnpleaxv");
            switch(selection)
            {
                case 'f':
                    currentDataset = 0;
                    displayDataset();
                    break;
                case 'n':
                    currentDataset = (currentDataset==datasets.size()-1)?currentDataset:currentDataset+1;
                    displayDataset();
                    break;
                case 'p':
                    currentDataset = (currentDataset==0)?currentDataset:currentDataset-1;
                    displayDataset();
                    break;
                case 'l':
                    currentDataset = datasets.size()-1;
                    displayDataset();
                    break;
                case 'a':
                    displayDatasets();
                    break;
                case 'x':
                    done = true;
                    break;
                case 'v':
                    viewDataset();
                    break;
                default:
                    // should not happen if you did the input right!
            }
        }while(!done);
    }
    public char getSelection(String optionString)
    {

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
    public void displayMenu(){
        System.out.print("[F]irst | [N]ext | [P]revious | [L]ast  | [A]ll | [V]iew | E[x]it >>");
    }
    public void displayDataset(){
        System.out.println(datasets.get(currentDataset));
    }
    public void displayDatasets(){
        System.out.println(datasets);
    }
    public void viewDataset(){
        Scanner scan = new Scanner(System.in);
        String output = "";
        for (int i = 0; i < datasets.get(currentDataset).fileCount; i++) {
            output += String.format("\nOPTION %d\n", i);
            output += String.format("    NAME: %s\n", datasets.get(currentDataset).fileNames.get(i));
            output += String.format("    FORMAT: %s\n", datasets.get(currentDataset).formats.get(i));
            output += String.format("    URL: %s\n>>>", datasets.get(currentDataset).urls.get(i));
        }
        System.out.println(output);
        System.out.printf("SELECTION >>> ");
        try {
            int selection = Integer.parseInt(scan.next());
            if (selection>=0 && selection<=datasets.get(currentDataset).fileCount){
                FileManager fm = new FileManager(datasets.get(currentDataset).getTemplate(selection));
            }else{
                System.out.println("Invalid digit");
            }
        } catch (NumberFormatException e){
            System.out.println("Wrong input type.");
            System.out.println(e);
        } catch (IOException e){
            System.out.println(e);
        }


    }
}
