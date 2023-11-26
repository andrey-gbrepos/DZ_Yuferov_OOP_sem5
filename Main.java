// — Создать класс УчебнаяГруппа, содержащий в себе поля Преподаватель и список Студентов;
// — Создать класс УчебнаяГруппаСервис, в котором реализована функция 
//     (входные параметры - (Teacher, List<Strudent>)) формирования из Студентов и 
//     Преподавателя УчебнойГруппы и возвращения его;
// — Создать метод в Контроллере, в котором агрегируются функции получения списка студентов 
//     (их id) и преподавателя (его id) и формирования учебной группы, путём вызова метода 
//     из сервиса;
// — Всё вышеуказанное создать согласно принципам ООП, пройдённым на семинаре.
//     ИЛИ 


import java.io.IOException;

/**
 * Main
 */
public class Main {
     
public static void main(String[] args) throws IOException {
    LearnGroupService lgs = new LearnGroupService();
    View view = new View();
    Model model = new Model();
    Controller controller = new Controller(lgs, view, model);
    controller.runController();
    }  
}