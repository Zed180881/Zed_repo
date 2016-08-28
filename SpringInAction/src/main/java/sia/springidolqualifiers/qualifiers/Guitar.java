package sia.springidolqualifiers.qualifiers;


import sia.springidolqualifiers.Instrument;

@StringedInstrument
@Strummed
public class Guitar implements Instrument {
    public void play() {
        System.out.println("Strum strum strum");
    }
}
