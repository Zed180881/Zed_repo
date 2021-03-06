// <start id="stage_java" />
package sia.springidoljavaconfig;

public class Stage {
    private Stage() {
    }

    private static class StageSingletonHolder {
        static Stage instance = new Stage();
    }

    public static Stage getInstance() {
        return StageSingletonHolder.instance;
    }
}
// <end id="stage_java" />
