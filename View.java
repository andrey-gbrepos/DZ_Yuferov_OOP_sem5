
import java.util.List;
import java.util.Scanner;

/**
 * Интерфейс пользователя
 */
public class View  {
   private Scanner scanner;
   private Scanner scanner1;
   
public View() {
scanner = new Scanner(System.in);
scanner1 = new Scanner(System.in);
}

public void displayResult(List <String> lst) {
System.out.println(lst);
}

public  String invite (String str){  //Приглашение для ввода
    System.out.println(str);
    return scanner1.nextLine();
}

public void uncorrectValue() { //Сообщение о некорректном значении
    System.out.println("Введено некорректное значение.");
}

public void notFound() { //Сообщение о ненайденной позиции
    System.out.println("Позиция не найдена");
}

public void delPosition(String id) { //Сообщение об удалении
System.out.println("Позиция  с id " + id + " удалена");
}

public int getUserInput(String prompt) {
    System.out.print(prompt);
    return scanner.nextInt();
}
}
