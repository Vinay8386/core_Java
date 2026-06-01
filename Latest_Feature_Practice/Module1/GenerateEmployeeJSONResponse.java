package Latest_Feature_Practice.Module1;

import java.util.List;

public class GenerateEmployeeJSONResponse {
    public static void main(String[] args) {
        //Generate offer letter for Intern
        //Get name, id and department of intern
        EmployeeHierarchy emp = new Intern("Ashmita", "HR", 101, 55000);
        EmployeeHierarchy emp2 = new Intern("Vijesh", "IT", 102, 85000);

        String name = emp.getName();
        int id = emp.getId();
        double salary = emp.getSalary();
        String dept = emp.getDepartment();

        System.out.println(generateResponseInJSONFormat(name,id,salary,dept));

        List<EmployeeHierarchy> empList = List.of(emp,emp2);
        System.out.println(generateResponseInJSONFormat(empList));
    }

    private static String generateResponseInJSONFormat(String name, int id, double salary, String dept) {
        String response = """
                {
                    "name" : "%s",
                    "id"   : %d,
                    "salary": %.2f,
                    "dept": "%s"
                }
                """.formatted(name,id,salary,dept);

        return response;
    }

    //for dynamic
    private static String generateResponseInJSONFormat(List<EmployeeHierarchy> empList) {

        StringBuilder finalResponse = new StringBuilder();

        finalResponse.append("{\n");

        for(var i=0; i<empList.size(); i++){

            EmployeeHierarchy emp = empList.get(i);

            String response = """
                    {
                        "name" : "%s",
                        "id" : %d,
                        "salary" : %.2f,
                        "dept" : "%s"
                    }
                    """.formatted(
                            emp.getName(),
                            emp.getId(),
                            emp.getSalary(),
                            emp.getDepartment()
                    ).strip();

            finalResponse.append(
                        """
                            "%s" : %s
                        """.formatted(emp.getName(),response).strip()
            );
            if(i<empList.size()-1){
                finalResponse.append(",\n");
            }
        }
        finalResponse.append("\n}");

        return finalResponse.toString();
    }
}
