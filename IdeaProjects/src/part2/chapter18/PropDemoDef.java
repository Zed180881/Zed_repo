package part1.chapter18;

import java.util.Properties;
import java.util.Set;

class PropDemoDef {
    public static void main(String[] args) {
        Properties defList = new Properties();
        defList.put("Флорида", "Тэннеси");
        defList.put("Висконсин", "Мэдисон");

        Properties capitals = new Properties(defList);
        capitals.put("Иллинойс", "Спрингфилд");
        capitals.put("Миссури", "Джефферсон-Сити");
        capitals.put("Вашингтон", "Олимпия");
        capitals.put("Калифорния", "Сакраменто");
        capitals.put("Индиана", "Индианаполис");

        Set<?> states = capitals.keySet();

        for (Object state : states) {
            System.out.println("Capital of state " + state + " - " + capitals.getProperty((String) state) + ".");
        }
        System.out.println();

        String str = capitals.getProperty("Флорида");
        System.out.println("Capital of state Florida " + str + ".");
    }
}
