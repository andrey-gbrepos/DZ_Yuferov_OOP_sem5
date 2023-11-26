
import java.util.List;

/**
 * Первоначально заполняет данные.
 */
public class Model {
    String source;

    public Model() {
        this.source = "List";
    }
    public  void fullPerson(List <Person> pers){
        Integer count = 1;
        Integer numGroup = 185;
    for (int i = 0; i < 4; i++) { 
        String cnt = count.toString();
        String numGr = numGroup.toString();
        Person teach = new Teacher(cnt);{
            teach.setPosition("Teacher");
            teach.setFirstName("FirstTeachName" + cnt);
            teach.setLastName("LastTeachName" + cnt);
            teach.setNumGroup(numGr);  
        };
        pers.add(teach);
        count+=1;
        numGroup+=(i+1)*7;
        for (int j = 0; j < 8; j++) {
            cnt =count.toString();
            Person stud = new Student(cnt);{
                stud.setPosition("Student");
                stud.setFirstName("FirstStudName" + cnt);
                stud.setLastName("LastStudName" + cnt);
                stud.setNumGroup(numGr);  
            };
            pers.add(stud);
            count+=1;
        }
        }
    }
}
