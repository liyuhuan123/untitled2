package Java15;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Employee{
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
public class Lt {
    public int getImportance(List<Employee> employees, int id) {
        if(employees.size() == 0){
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        int sum = 0;
        while(!(queue.size() == 0)){
            int tmp = queue.poll();
            for(Employee e : employees){
                if(tmp == e.id){
                    sum += e.importance;
                    for(int i : e.subordinates){
                        queue.add(i);
                    }
                }
            }
        }
        return sum;
    }
}
