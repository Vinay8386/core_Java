package Basic_concept;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NewClass {
    public static void main(String[] args) {
        /*List<Integer> list= Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);

        int a=
        list.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                .findFirst()
                .get();
        System.out.println(a);*/

        int[] arr={1,2,3,4,5};
        int temp;
        for (int i = arr.length-1; i > 0; i--) {
            temp=arr[i];
            arr[i]=arr[i-1];
            arr[i-1]=temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
//5,1,2,3,4
/*
select * from employee
 (select employee e1 Join ON employee e2 where e1.salary=e2.salary
 ) Group By employee.name;
*/
