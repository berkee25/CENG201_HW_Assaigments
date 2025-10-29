public class TreatmmenRequest {
    int patientId;
    long arrivalTime;

    TreatmmenRequest(int patientId, long arrivalTime) {
        this.patientId = patientId;
        this.arrivalTime = arrivalTime;
    }
}
