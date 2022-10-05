public class Application {


    public static void main(String args[]){
        Employee employee1 = new Employee("Ali", 10000.0, 45.0, 2010);
        Employee employee2 = new Employee("Ayşe", 5000.0, 40.0, 1995);
        Employee employee3 = new Employee("Cem", 5500.25, 46.0, 2008);
        Employee employee4 = new Employee("Ceren", 9250.50, 45.5, 2020);
        Employee employee5 = new Employee("Şule", 10000.0, 42.0, 2021);
        System.out.println(employee1.toString());
        System.out.println(employee2.toString());
        System.out.println(employee3.toString());
        System.out.println(employee4.toString());
        System.out.println(employee5.toString());
    }
}
