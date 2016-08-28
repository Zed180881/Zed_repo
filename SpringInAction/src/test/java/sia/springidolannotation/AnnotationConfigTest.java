package sia.springidolannotation;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/springidolannotation/spring-idol.xml")
public class AnnotationConfigTest {
    @Autowired
    @Qualifier("eddie")
    private Instrumentalist eddie;

    @Autowired
    @Qualifier("guitar")
    private Instrument guitar;

    @Test
    public void shouldWireWithAutowire() {
        assertNotNull(eddie.getInstrument());
        assertEquals(guitar, eddie.getInstrument());
    }
}