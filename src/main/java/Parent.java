public class Parent {
    public void showEmployees(int indent){
        System.err.println("ERROR: showEmpleyees from Parent");
    }
    public int employeeCost(int salaries){
        System.err.println("ERROR: employeeCost from Parent\"");
        return 1;
    }
    int type(){
        return 3;
    }
    public Parent nameSearch(String name){
        System.err.println("ERROR: nameSearch from Parent");

        return this;
    }
}
