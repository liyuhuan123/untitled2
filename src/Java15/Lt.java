package Java15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
class Employee{
   public int id;
   public int importance;
   public List<Integer> subordinates;
}
public class Lt {
    Map<Integer,Employee> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        for(Employee e : employees){
            map.put(e.id,e);
        }
        return dfs(id);

    }
    private int dfs(int id){
        Employee employee = map.get(id);
        int sum = employee.importance;
        for(int o:employee.subordinates){
            sum += dfs(o);

        }
        return sum;
    }
}
