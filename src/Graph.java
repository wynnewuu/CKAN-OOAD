abstract class Graph {
    public RecordList data;
    public Graph(RecordList recordList){
        this.data = recordList;
    }
    public abstract void displayGraph();
}
