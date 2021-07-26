/** DatasetManager
 A dataset manager controls the loading (really displaying) of datasets
 and instantiates a DatasetViewer

 @author Jose Guillen Santos

 */
public class DatasetManager {
    public DatasetManager(){
        System.out.println("DatasetManager initiated....");
        DatasetViewer dv = new DatasetViewer();
        dv.displayViewer();
    }
}
