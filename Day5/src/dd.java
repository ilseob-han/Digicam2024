import java.util.HashMap;
import java.util.Map;

public class dd {
    public static void main(String[] args) {
        String[][] data = {
            {"A", "X", "10"},
            {"A", "Y", "20"},
            {"B", "X", "30"},
            {"B", "Y", "40"}
        };
        
        Map<String, Map<String, Integer>> pivotTable = new HashMap<>();
        
        // Create a pivot table
        for (String[] row : data) {
            String rowKey = row[0]; // Key for row dimension
            String colKey = row[1]; // Key for column dimension
            int value = Integer.parseInt(row[2]); // Value to aggregate
            
            pivotTable.putIfAbsent(rowKey, new HashMap<>()); // Initialize row if not exists
            pivotTable.get(rowKey).put(colKey, pivotTable.get(rowKey).
            		getOrDefault(colKey, 0) + value);
        }
        
        // Print pivot table
        System.out.println("Pivot Table:");
        for (Map.Entry<String, Map<String, Integer>> entry : pivotTable.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}