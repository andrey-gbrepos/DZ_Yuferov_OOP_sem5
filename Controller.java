import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Управляющий модуль
 */
public class Controller {
    private LearnGroupService service;
    private View view;
    
    private List<Person> person;
    public Controller(LearnGroupService service, View view, Model model) {
        this.service = service;
        this.view = view;
        this.person = new ArrayList<>();
        model.fullPerson(person);
    }
        
    public void runController() throws IOException {
        int choice;
        do {
        System.out.println("Выберите Действие:");
        System.out.println("1. Показать список преподавателей");
        System.out.println("2. Показать список студентов");
        System.out.println("3. Показать список группы");
        System.out.println("4. Добавить в список");
        System.out.println("5. Удалить из списка");
        System.out.println("0. Выход");
        
        choice = view.getUserInput("Введите номер операции: ");
        List <String> lst = new ArrayList<>();
        switch (choice) {
        case 1://Список преподавателей
            lst = service.personList(person, "Teacher");
            view.displayResult(lst);
        break;
        case 2: // Список студентов
            lst = service.personList(person, "Student");
            view.displayResult(lst);
        break;
        case 3: //Список группы по ID преподавателя
            lst = service.personList(person, "Teacher");
            view.displayResult(lst);
            choice = view.getUserInput("Введите ID преподавателя: ");
        if (!service.checkID(person, choice)) {
            view.uncorrectValue();
            break;
            }
        else {
            lst = service.groupList(person, choice);
            view.displayResult(lst);
            break;
            }
        case 4: //Добавление позиции
            choice = view.getUserInput("Введите позицию: 1 - Teacher, 2 - Student ");
            if (!service.checkPos(choice)){
                view.uncorrectValue();
            break;
            }
            else
            {
                String firstName = view.invite("Введите Имя ");
                String lastName = view.invite("Введите Фамилию ");
                String numGroup = view.invite("Введите номер группы ");
                String newID = service.nextID(person);
                service.addNewPerson(person,newID,choice, firstName, lastName, numGroup);
                lst = service.searchPers(person, newID);
                view.displayResult(lst);
            break;
            }
            case 5: // Удаление позиции
            choice = view.getUserInput
                        ("Введите ID позиции,которую хотите удалить:  ");
            Integer ch = choice;
            lst = service.searchPers(person, ch.toString());
        if(lst.size() == 0){
            view.notFound();
            break;
        }else {
            service.deletePerson(person, ch.toString());
            view.delPosition(ch.toString());
            break;
        }
        case 0:
            System.out.println("Программа завершена.");
        break;
        default:
            System.out.println("Неверный выбор. Попробуйте еще раз.");
        }
        } while (choice != 0);
    }
}
