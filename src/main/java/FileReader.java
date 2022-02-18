import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class FileReader implements Reader{

    String filePath;

    public FileReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Director Reader() throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner=new Scanner(file);
        String first = scanner.nextLine();
        //virgüllerine parçaladım
        String[] splitted = first.split(",");
        int salary=Integer.parseInt(splitted[2]);
        // Patronu ilk başta çağırdık bir sıkıntı olmasın diye
        Director boss=new Director(splitted[1],salary);
        while (scanner.hasNext()){
            String line=scanner.nextLine();
            String[] splitted2 = line.split(",");
            // sırasıyla okuyup ekliyor
            boss = OopProject.empAdder(splitted2, boss);
        }
        return boss;
    }
}
