import java.io.FileNotFoundException;
import java.sql.SQLException;

public interface Reader {
    public Director Reader() throws FileNotFoundException, SQLException;
}
