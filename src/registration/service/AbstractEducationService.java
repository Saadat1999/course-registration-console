package registration.service;
import registration.repository.entity.HumanEntity;
import registration.service.dto.HumanDto;

import java.util.List;
import java.util.Scanner;


public abstract class AbstractEducationService implements EducationService {
    protected final List<HumanEntity> list;

    protected AbstractEducationService(List<HumanEntity> list) {
        this.list = list;
    }


    @Override
    public void delete() {
        System.out.println("Who do you want to remove from the list?");

        int id = new Scanner(System.in).nextInt();
        deleteByID(id);
    }

    @Override
    public int showMenu() {
        System.out.println("Please enter the operation:\n" +
                "1. Register\n"+
                "2. Delete\n"+
                "3. Search\n"+
                "4. Show all\n"+
                "5. Update\n");

        return new Scanner(System.in).nextInt();
    }

}
