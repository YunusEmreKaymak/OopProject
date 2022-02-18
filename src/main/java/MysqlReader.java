import java.io.FileNotFoundException;
import java.sql.*;

public class MysqlReader implements Reader{



    String mysqlAdress;
    String user;
    String password;

    public MysqlReader(String mysqlAdress, String user, String password) {
        this.mysqlAdress = mysqlAdress;
        this.user = user;
        this.password = password;
    }

    @Override
    public Director Reader() throws FileNotFoundException, SQLException {
        Connection conn = DriverManager.getConnection(mysqlAdress,user,password);
        Statement st =conn.createStatement();
        ResultSet resultSet = st.executeQuery("select * from OopProject");
        String position=null;
        String nameSurname=null;
        String salary=null;
        String supervisor=null;
        if (resultSet.next()){
             position = resultSet.getString(1);
             nameSurname = resultSet.getString(2);
             salary = resultSet.getString(3);
             supervisor = resultSet.getString(4);
        }else {
            System.err.println("ERROR: Employee not found on database");
        }

        int salaryInt=Integer.parseInt(salary);
        String[] splitted={position,nameSurname,salary,supervisor};
        // Patronu ilk başta çağırdım bir problem olmasın diye
        Director boss=new Director(splitted[1],salaryInt);
        while (resultSet.next()){
            position = resultSet.getString(1);
            nameSurname = resultSet.getString(2);
            salary = resultSet.getString(3);
            supervisor = resultSet.getString(4);
            splitted=new String[]{position,nameSurname,salary,supervisor};
            boss=OopProject.empAdder(splitted,boss);
        }
        return boss;
    }
}
