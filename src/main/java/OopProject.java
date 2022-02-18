import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class OopProject {
    public static void main(String[] args) throws FileNotFoundException, SQLException {
        // File path'in argüman olarak verilmesi lazım
        Reader fileReader=new FileReader("/home/asd/IdeaProjects/OopProject3/file.txt");
        Director boss = fileReader.Reader();
//        Reader dbReader=new MysqlReader("jdbc:mysql://localhost:3306/tutorial","root","test123");
//        Director boss = dbReader.Reader();
        // hiyerarşiyi yazdırıyor
        boss.showEmployees();
        Director eleman =(Director) boss.nameSearch("oguz",boss);
        Officer eleman2=(Officer) boss.nameSearch("Ahmet",boss);
        System.out.println("-------------------------------------------------");
        System.out.println("Oğuzun elemanları: ");
        eleman.showEmployees();
        System.out.println("Oguzun maliyeti: "+eleman.employeeCost());
        System.out.println("Ahmetin elemanları: ");
        eleman2.showEmployees();
        System.out.println("Ahmetin maliyeti: "+eleman2.employeeCost());

        System.out.println("---------------------------------------------------");
        boss.showEmployees();
        System.out.println(boss.employeeCost());
    }
    public static Director empAdder(String[] line,Director boss) {
//        System.out.println(line[1]);
        int salary = Integer.parseInt(line[2]);
        Director b = (Director) boss.nameSearch(line[3],boss);
        b.addEmployee(line);
        return boss;
    }
}

