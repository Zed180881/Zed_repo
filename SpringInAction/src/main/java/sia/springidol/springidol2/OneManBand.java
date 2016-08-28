package sia.springidol.springidol2;

import sia.springidol.springidol.Instrument;
import sia.springidol.springidol.PerformanceException;
import sia.springidol.springidol.Performer;

import java.util.Map;

public class OneManBand implements Performer {
    private Map<String, Instrument> instruments;

    public OneManBand() {
    }

    @Override
    public void perform() throws PerformanceException {
        instruments.keySet().forEach(key -> {
            System.out.print(key + " : ");
            instruments.get(key).play();
        });
    }

    public void setInstruments(Map<String, Instrument> instruments) {
        this.instruments = instruments;
    }
}
