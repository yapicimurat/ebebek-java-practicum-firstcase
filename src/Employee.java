import java.text.DecimalFormat;

public class Employee {

    private final Double TAX_THRESHOLD_VALUE = 1000.0;

    private final int CURRENT_YEAR = 2021;

    private final int WEEKLY_WORK_LIMIT_HOUR = 40;

    private final Double BONUS_PRICE_PER_HOUR = 30.0;

    private final String name;

    private final Double salary;

    private final Double workHours;

    private final int hireYear;

    public Employee(String name, Double salary, Double workHours, int hireYear){
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public Double tax(){
        if(salary > TAX_THRESHOLD_VALUE){
            return 0.97;
        }
        //eger herhangi bir vergi uygulanmayacak ise, islemin etkilenmemesi icin 1.0 dondur...
        return 1.0;
    }

    public Double bonus(){
        if(workHours > WEEKLY_WORK_LIMIT_HOUR){
            return (workHours - WEEKLY_WORK_LIMIT_HOUR) * BONUS_PRICE_PER_HOUR * 4;
        }
        return 0.0;
    }

    public Double raiseSalary(){
        final int totalWorkYear = CURRENT_YEAR - hireYear;
        final Double salaryWithBonus = salary + bonus();
        if(totalWorkYear < 10){
            return (salaryWithBonus * 1.05) * tax() - salary;
        }
        else if(totalWorkYear > 9 && totalWorkYear < 20){
            return (salaryWithBonus * 1.10) * tax() - salary;
        }
        else
            return (salaryWithBonus * 1.15) * tax() - salary;
    }

    private String doubleFormatter(Double val){
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(val);
    }

    @Override
    public String toString(){
        return "Employee => Name: " + name +
                ", Hire Year: " + hireYear +
                ", Default Salary: " + salary +
                ", Weekly Working Hours: " + workHours +
                ", Monthly Bonus: " + doubleFormatter(bonus()) +
                ", Salary Raise: " + doubleFormatter(raiseSalary()) +
                ", Total Salary: " + doubleFormatter((Double)(salary + raiseSalary()));
    }

}