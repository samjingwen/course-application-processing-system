package sg.iss.team5.model;

public class ChartData {
	private int y=0;
	private String label=null;
	
	public ChartData(int y, String label) {
		super();
		this.y = y;
		this.label = label;
	}
	
	public ChartData() {
		super();
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	@Override
	public String toString() {
		return String.format("ChartData [y=%s, label=%s]", y, label);
	}
	
}
