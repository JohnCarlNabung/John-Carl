package CRUD;

public class TrafficViolation {
    private String plateNumber;
    private String violationType;
    private double fineAmount;

    public TrafficViolation(String plateNumber, String violationType, double fineAmount) {
        this.plateNumber = plateNumber;
        this.violationType = violationType;
        this.fineAmount = fineAmount;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getViolationType() {
        return violationType;
    }

    public void setViolationType(String violationType) {
        this.violationType = violationType;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    @Override
    public String toString() {
        return plateNumber + " | " + violationType + " | $" + fineAmount;
    }
}
