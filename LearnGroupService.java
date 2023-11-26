
import java.util.ArrayList;
import java.util.List;
/**
 * Выборка и проверка корректности введенных данных
 */
public class LearnGroupService {
    Teacher teacher;
    List <Student> lst;
    public LearnGroupService() {
        this.lst = new ArrayList<>();       
    }
    /**
     * Проверка на корректность введенного значения
     * @param ch
     * @return
     */
    boolean checkPos(Integer ch){
        boolean bool = false;
        if(ch == 1 || ch == 2) bool = true;
        return bool;
    }
    /**
     * Проверка на наличие ID
     * @param person
     * @param choice
     * @return
     */
    boolean checkID (List<Person> person, Integer choice){
        boolean bool = false;
         for (Person item : person) {
            if(item.position.equals("Teacher")&& item.idPerson.equals(choice.toString()) )
            bool = true;   
        }
        return bool;
    }
    
    /**
     * Поиск позиции по ID
     * @param person
     * @param id
     * @return
     */
    public List<String> searchPers (List <Person> person,String id){  
            List <String> str = new ArrayList<>();
            for (Person item : person) {
            if (item.idPerson.equals(id)) {
                str.add(item.toString());
                   
            }
        }  
     return str;   
      
    }
    /**
     * Добавляет новую запись
     * @param person
     * @param id
     * @param pos
     * @param firstName
     * @param lastName
     * @param numGroup
     */
    public void addNewPerson (List<Person> person, String id, Integer pos, 
                        String firstName, String lastName, String numGroup){
        if (pos == 1){
            Person pers = new Teacher(id);
            pers.position = "Teacher";
            pers.firstName = firstName;
            pers.lastName = lastName;
            pers.numGroup = numGroup;
            person.add(pers); 
            }   
            else{
            Person pers = new Student(id);
            pers.position = "Student";
            pers.firstName = firstName;
            pers.lastName = lastName;
            pers.numGroup = numGroup;  
            person.add(pers); 
            }    
                 
        }
    /**
     * Удаляет запись по ID
     * @param pers
     * @param idPerson
     */
    void deletePerson(List<Person> pers, String idPerson){
        for(int i = 0; i < pers.size(); i++){
            if(pers.get(i).idPerson.equals(idPerson)){
                pers.remove(i);
            }
        }
    }
    /**
     * Определяет ID для новой записи
     * @param person
     * @return
     */
    String nextID(List<Person> person){
        Integer nextID;
        nextID = Integer.parseInt(person.get(person.size()-1).idPerson);
        nextID++;
        return nextID.toString();
    }
/**
 * Выбирает из общего списка группу преподавателя
 * @param person
 * @return
 */
    public List <String> groupList(List<Person> person, Integer idTeacher){
        List <String> groupList = new ArrayList<>();
        String numGr = "";
        for (Person item : person) {
            if(item.idPerson.equals(idTeacher.toString())) {
                numGr = item.numGroup;
                groupList.add(item.toString());
            }
        }
        for (Person item : person) {
            if(item.numGroup.equals(numGr)&& item.position.equals("Student") ){
                groupList.add(item.toString());
            }
        }
        return groupList;
    }
/**
 * Выбирает из общего списка по позиции (Teacher or Student)
 * @param person
 * @return
 */
    public List <String> personList(List<Person> person, String position){
        List <String> personList = new ArrayList<>();
        for (Person item : person) {
            if(item.position.equals(position) ){
                personList.add(item.toString());
            }
        }
        return personList;
    }
}
