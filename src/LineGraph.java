import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.util.ArrayList;

public class LineGraph extends Graph {
    public int x, y;
    public LineGraph(RecordList recordList, int x, int y){
        super(recordList);
        this.x = x;
        this.y = y;
    }
    public void displayGraph(){
        ArrayList xData = new ArrayList<Double>();
        ArrayList yData = new ArrayList<Double>();

        for (int i = 0; i < 10; i++) { //graphs the first 10 values
            xData.add(Double.parseDouble(this.data.get(i).getValue(x)));
            yData.add(Double.parseDouble(this.data.get(i).getValue(y)));
        }
        // Create Chart
        XYChart chart = QuickChart.getChart("Sample Chart", this.data.getFieldLabels().get(x), this.data.getFieldLabels().get(y), "y(x)", xData, yData);

        // Show it
        new SwingWrapper(chart).displayChart();
    }
}
