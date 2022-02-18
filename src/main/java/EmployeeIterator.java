public class EmployeeIterator implements MyIterator{
    Parent[] employeeArray;


    int index=0;
    public EmployeeIterator(Parent[] employees){
        this.employeeArray=employees;
    }
    //listede eleman varsa true döner
    @Override
    public boolean isNotDone() {
        if (employeeArray==null){
            return false;
        }else {
            if (index==employeeArray.length) {
                index = 0;
                return false;
            }else if (index>employeeArray.length){
                index=0;
                return false;
            }else {
                return true;
            }

        }
    }
    // ilk indexten başlayarak sırayla döndürür
    @Override
    public Parent next() {
        if (employeeArray==null){
            System.err.println("No employee!");
            return null;
        }else {
            index++;
            return employeeArray[index-1];
        }

    }


    // listeye ekler
    @Override
    public void add(Parent e) {
        if (employeeArray==null){
            employeeArray=new Parent[]{e};
        }else {
            Parent[] newEmployeeArray=new Parent[employeeArray.length+1];
            for (int i=0;i< employeeArray.length;i++){
                newEmployeeArray[i]=employeeArray[i];
            }
            newEmployeeArray[employeeArray.length]=(Parent) e;
            employeeArray=newEmployeeArray;
        }
    }
    //indexi resetler
    @Override
    public void reset() {
        this.index=0;
    }
}
