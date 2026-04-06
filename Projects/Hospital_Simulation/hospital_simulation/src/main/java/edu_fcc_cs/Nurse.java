package edu_fcc_cs;

public class Nurse {

    private String id;
    private Alert currentAlert;
    private boolean usingTelemedicine;

    public Nurse(String id) {
        this.id = id;
        this.currentAlert = null;
        this.usingTelemedicine = false;
    }

    public void resolve(int time, Hospital hospital) {

        if (currentAlert == null) {
            currentAlert = hospital.getNextAlert();
            usingTelemedicine = false;
        }

        while (currentAlert != null) {

            boolean success = Simulation.getRandom().nextDouble() < 0.5;

            if (!success && !usingTelemedicine &&
                    hospital.requestTelemedicine(currentAlert)) {

                usingTelemedicine = true;

                success = Simulation.getRandom().nextDouble() < 0.7;
            }

            if (success) {

                currentAlert.resolve(time);

                if (usingTelemedicine) {
                    hospital.releaseTelemedicine();
                }

                hospital.addCompletedAlert(currentAlert);

                System.out.println(id + " resolved: " + currentAlert);

                currentAlert = hospital.getNextAlert();
                usingTelemedicine = false;

            } else {
                break;
            }
        }
    }
}