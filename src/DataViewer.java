import java.util.InputMismatchException;
import java.util.Scanner;

abstract class DataViewer implements DatasetTemplate{
    DatasetList datasets; // the master DatasetList loaded from a CKAN site
    public int currentDataset; // you view a currentDataset by its index

    // The idea behind the constructor is that when you instantiate a DataViewer you
    // shall have the DatasetList created and loaded from the CKAN site, all sorted and
    // ready to be viewed since it queries site in order from dataset name.
    public DataViewer(){
        datasets = new DatasetList();
        datasets.loadDatasets();

    }


}
