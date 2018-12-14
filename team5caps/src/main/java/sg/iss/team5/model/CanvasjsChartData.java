package sg.iss.team5.model;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanvasjsChartData {
 
	static Map<Object,Object> map = null;
	private List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
	
	public CanvasjsChartData(ArrayList<String> coursenames, ArrayList<Integer> integers) {
		
		map = new HashMap<Object,Object>(); map.put("label", coursenames.get(0)); map.put("y", integers.get(0));dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", coursenames.get(1)); map.put("y", integers.get(1));dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", coursenames.get(2)); map.put("y", integers.get(2));dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", coursenames.get(3)); map.put("y", integers.get(3));dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", coursenames.get(4)); map.put("y", integers.get(4));dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", coursenames.get(5)); map.put("y", integers.get(5));dataPoints1.add(map);
		
		list.add(dataPoints1);
	}

	static List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();
 
	public List<List<Map<Object, Object>>> getCanvasjsDataList() {
		return list;
	}
}   