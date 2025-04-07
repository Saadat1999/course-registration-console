import service.EducationService;

public class Application {
    public static void main(String[] args) {
        while (true) {

            EducationService educationService = EducationService.chooseService();

            educationService.chooseAndExecuteSelectedMenu();
        }
    }

}
