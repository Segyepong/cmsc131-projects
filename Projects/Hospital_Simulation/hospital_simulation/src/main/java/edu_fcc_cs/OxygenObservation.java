package edu_fcc_cs;

public class OxygenObservation extends Observation {

    private int oxygenLevel;

    public OxygenObservation(Patient patient, int time, int oxygenLevel) {
        super(patient, time);
        this.oxygenLevel = oxygenLevel;
    }

    public int getOxygenLevel() {
        return oxygenLevel;
    }

    @Override
    public String getType() {
        return "Oxygen Level";
    }
}
