package sia.springidolaspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class ContestantIntroducer {

    @DeclareParents( //<co id="co_declareParents"/>
            value = "sia.springidolaspectj.Performer+",
            defaultImpl = GraciousContestant.class)
    public static Contestant contestant;
}