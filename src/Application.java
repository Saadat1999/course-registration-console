import service.Database;
import service.EducationService;

public class Application {
    public static void main(String[] args) {
        boolean isSave = "save-to-file".equalsIgnoreCase(args.length>0?args[0]:"");
        Database.init(isSave);
        while (true) {
            EducationService.chooseService(isSave).chooseAndExecuteSelectedMenu();
        }
    }

}
