import java.util.HashMap;
import java.util.List;
import java.util.Map;




	public class PivotTable {
	    public static Map<String, Map<String, Integer>> createPivotTable(List<EmployeeData> dataList) {
	        Map<String, Map<String, Integer>> pivotTable = new HashMap<>();

	        for (EmployeeData data : dataList) {
	            String employee = data.getEmployeeName();
	            String month = data.getMonth().substring(0, 7);
	            int salary = data.getSalary();

	            pivotTable.putIfAbsent(employee, new HashMap<>());
	            pivotTable.get(employee).put(month, salary);
	        }

	        return pivotTable;
	    }
	}
	
	
}
