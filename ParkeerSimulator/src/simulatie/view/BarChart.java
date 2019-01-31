package simulatie.view;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChart {
	
	public static void main(String[] args) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(100, "", "Parkeerders");
		dataset.setValue(200, "", "Abbonnement");
		dataset.setValue(300, "", "Reserveringen");
		JFreeChart chart = ChartFactory.createBarChart("BarChart diagram", "", "geen idee wat hier moet", dataset,
				PlotOrientation.VERTICAL, false, true, false);
		chart.setBackgroundPaint(Color.WHITE);
		chart.getTitle().setPaint(Color.RED);
		CategoryPlot p = chart.getCategoryPlot();
		p.setRangeGridlinePaint(Color.GREEN);
		ChartFrame frame1 = new ChartFrame("count", chart);
		frame1.setVisible(true);
		frame1.setSize(500, 500);
		
	}
}
