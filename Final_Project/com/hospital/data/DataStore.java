public class DataStore {
    // ... other fields and methods ...
    
    public List<Appointment> getAllAppointments() {
        return new ArrayList<>(appointments);
    }
    
    // ... existing code ...
} 