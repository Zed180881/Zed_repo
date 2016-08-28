package sia.springidolqualifiers.qualifiers;

import sia.springidolqualifiers.Instrument;

@StringedInstrument
public class HammeredDulcimer implements Instrument {
    public void play() {
        System.out.println("Ting ting ting");
    }
}
