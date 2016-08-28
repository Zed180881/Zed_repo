// <start id="volunteer_java" />
package sia.springidolaspectj;

public class Volunteer implements Thinker {
    private String thoughts;

    public void thinkOfSomething(String thoughts) {
        this.thoughts = thoughts;
    }

    public String getThoughts() {
        return thoughts;
    }
}
// <end id="volunteer_java" />
