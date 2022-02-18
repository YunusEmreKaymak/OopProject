import java.util.ArrayList;
import java.util.List;

//@Getter
public class Director extends Parent implements Employee{
    private String nameSurname;
    private int salary;
    public Director(String nameSurname,int salary){
        this.nameSurname=nameSurname;
        this.salary=salary;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public MyIterator getList() {
        return list;
    }

    public Parent[] getEmployees() {
        return employees;
    }

    public int getSalary() {
        return salary;
    }

    private Parent[] employees;

    MyIterator list=new EmployeeIterator(employees);
    //Employee ekler
    public void addEmployee(String[] line)
    {
        int salary=Integer.parseInt(line[2]);
        if (line[0].equalsIgnoreCase("M")){
            list.add(new Officer(line[1],salary));
        }else {
            list.add(new Director(line[1],salary));
        }

    }
    public void showEmployees(int indent){
        list.reset();
        for (int i=0;i<indent;i++){
            System.out.printf("    ");
        }
        System.out.printf("D(");
        System.out.printf(getNameSurname()+","+getSalary()+")");
        System.out.println("");
        indent++;
        while (list.isNotDone()){
            list.next().showEmployees(indent);
        }

    }
    public void showEmployees(){
//        System.out.println("Name: "+getNameSurname());
        showEmployees(0);

    }
    // isim arıyor
    public Parent nameSearch(String name,Director boss){
        String thisName=getNameSurname().split(" ")[0];
        if (name.equalsIgnoreCase(thisName)){
            return this;
        }
        while (list.isNotDone()){
//            Parent next = list.next();
//            if (next.type()==1){
//                return next.nameSearch(name);
//            }
            if (this.type()==1){
                Parent next = list.next();
                if (next.type()==1){
                    //Next'in tipini(type) belirtmek için Cast ettim
                    Director current=(Director) next;
                    return current.nameSearch(name,boss);
                }else {
                    Officer current=(Officer) next;
                    String firstName=current.getNameSurname().split(" ")[0];
                    if (firstName.equalsIgnoreCase(name)){
                        return next;
                    }
                }
            }
        }
        return boss.nameSearch(name,boss);
    }

    @Override
    public int employeeCost(int salaries) {
        list.reset();
//        System.out.println(getNameSurname()+" işletildi");

        salaries+=getSalary();
//        System.out.println(salaries+"t");
        while (list.isNotDone()){
            Parent myObject=list.next();
            if (myObject.type()==0){
                int sum=myObject.employeeCost(salaries);
//                System.out.println(sum+"t");
                salaries+=sum;
            }else if (myObject.type()==1){
                int sum=myObject.employeeCost(salaries);
////                System.out.println(sum+"t");
                salaries=sum;
            }
//            salaries+=list.next().employeeCost(salaries);
        }
        return salaries;
    }
    public int employeeCost(){
        int salary=0;
        salary=employeeCost(salary);
        return salary;
    }

    // direktörlerin tipi 1 olacak
    @Override
    public int type() {
        return 1;
    }

    //singleton için
//    static Director director=null;
//    public static Director getDirector(String nameSurname,int salary){
//        if (director==null){
//            director=new Director(nameSurname,salary);
//        }
//        return director;
//    }


    //Composit orijinali
    //    List<Employee> employees=new ArrayList<Employee>();
//    @Override
//    public void showEmployees() {
//        System.out.println("Name-Surname(Director) "+nameSurname);
//        for (Employee e:employees){
//            e.showEmployees();
//        }
//    }

}
