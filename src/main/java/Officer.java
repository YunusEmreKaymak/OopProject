
//
//@Data
//@AllArgsConstructor
public class Officer extends Parent implements Employee{
    private String nameSurname;
    private int salary;

    public String getNameSurname() {
        return nameSurname;
    }

    public int getSalary() {
        return salary;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Officer(String nameSurname, int salary) {
        this.nameSurname = nameSurname;
        this.salary = salary;
    }

    @Override
    public void showEmployees(int indent) {
        for (int i=0;i<indent;i++){
            System.out.printf("    ");
        }
        System.out.println("M("+nameSurname+","+salary+")");
    }

    public void showEmployees() {
        System.out.println("Name-Surname(Officer): "+nameSurname);
    }



    @Override
    public int employeeCost(int salary) {
//        System.out.println("Cost of "+nameSurname+"(O): "+salary);
//        System.out.println(getNameSurname()+" işletildi");
//        System.out.println(salary+"t");
        return getSalary();
    }
    public int employeeCost(){
        return getSalary();
    }
    // memurların tipi 0 olacak
    @Override
    public int type() {
        return 0;
    }
}
