/* To change this license header, choose License Headers in Project Properties.
        * To change this template file, choose Tools | Templates
        * and open the template in the editor.
        */

//        import com.mycompany.thelastoop.Reader;
//        import com.mycompany.thelastoop.Director;
//        import com.mycompany.thelastoop.FileReader;
//        import com.mycompany.thelastoop.Officer;
//        import com.mycompany.thelastoop.TheLastOOP;
        import java.io.FileNotFoundException;
        import java.sql.SQLException;
        import org.junit.jupiter.api.AfterEach;
        import org.junit.jupiter.api.AfterAll;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.BeforeAll;
        import org.junit.jupiter.api.Test;
        import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ASUS
 */
        public class NewEmptyJUnitTest {

        public NewEmptyJUnitTest() {
        }

        @BeforeAll
        public static void setUpClass() {
        }

        @AfterAll
        public static void tearDownClass() {
        }

        @BeforeEach
        public void setUp() {
        }

        @AfterEach
        public void tearDown() {
        }

        @Test
        public void testTypeDirector() { // Director'un type'i 1'e esit midir onu kontrol eder.
        Director director = new Director("asd",5);
        int typeOfDirector = director.type();
        assertEquals(1,typeOfDirector);
        }
        @Test
        public void testTypeOfficer(){ // Officer'in type'i 0'a  esit midir onu kontrol eder.
        Officer officer = new Officer("asd",6);
        int typeOfOfficer = officer.type();
        assertEquals(0,typeOfOfficer);
        }
        @Test
        void testDirectorNameSurname() throws FileNotFoundException, SQLException {
            //file.txt dosyasının uzantısı ayarlanmalıdır.
        Reader fileReader=new FileReader("file.txt");
        Director boss = fileReader.Reader();
        Director mustafa = (Director)boss.nameSearch("Mustafa",boss);
        assertNotEquals("Mustafa Turksever",mustafa.getNameSurname());

        }
        @Test
        public void testEmpAdder() { //
        System.out.println("empAdderTesti başarısız oldu");
        String[] line = {"D","Mustafa Turksever","5000","Root"};
        Director boss = new Director("Mustafa Turksever",5000);
        Director expResult = new Director(line[1],Integer.parseInt(line[2]));
        expResult= OopProject.empAdder(line, expResult);
        Director result = OopProject.empAdder(line, boss);
        assertNotEquals(expResult, result);
        }
        @Test
        public void testEmployeeCost() /* Bir direktor icin maliyetin bos olup olmadıgını kontrol eder */ throws FileNotFoundException, SQLException{
        System.out.println("employeeCostDirektorTest");
        //file.txt dosyasının uzantısı ayarlanmalıdır.
        Reader fileReader=new FileReader("file.txt");
        Director boss = fileReader.Reader();
        Director oguz = (Director)boss.nameSearch("Oguz",boss);
        assertNotNull(oguz.employeeCost());
        }
        @Test
        public void testEmployeeCost2() /* Bir memur icin maliyetin bos olup olmadıgını kontrol eder */throws FileNotFoundException, SQLException{
        System.out.println("employeeCostMemurTest");
        //file.txt dosyasının uzantısı ayarlanmalıdır.
        Reader fileReader=new FileReader("file.txt");
        Director boss = fileReader.Reader();
        Officer ahmet = (Officer)boss.nameSearch("Ahmet",boss);
        assertNotNull(ahmet.employeeCost());
        }
        }