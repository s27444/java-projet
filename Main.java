import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.time.LocalDate;
import java.util.Comparator;

class Doctor {
    private String name;
    private List<String> specialties;
    private List<Appointment> appointments;

    @Override
    public String toString() {
        return name;
    }

    public Doctor(String name, List<String> specialties) {
        this.name = name;
        this.specialties = specialties;
        this.appointments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getSpecialties() {
        return specialties;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }
}

class Patient {
    private String name;

    public Patient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Appointment {
    private String date;
    private Doctor doctor;
    private Patient patient;
    private boolean reserved;
    private boolean completed;

    public Appointment(String date, Doctor doctor) {
        this.date = date;
        this.doctor = doctor;
        this.reserved = false;
        this.completed = false;
    }

    public String getDate() {
        return date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public boolean isReserved() {
        return reserved;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void reserve(Patient patient) {
        this.patient = patient;
        this.reserved = true;
    }

    public void cancelReservation() {
        this.patient = null;
        this.reserved = false;
    }

    public void complete() {
        this.completed = true;
    }
}

class Clinic {
    private List<Doctor> doctors;
    private List<Patient> patients;
    private List<Appointment> appointments;

    public Clinic() {
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Appointment> findAvailableAppointments(String specialty, String date) {
        List<Appointment> availableAppointments = new ArrayList<>();
        boolean found = false;

        for (Doctor doctor : doctors) {
            if (doctor.getSpecialties().contains(specialty)) {
                for (Appointment appointment : doctor.getAppointments()) {
                    if (!appointment.isReserved() && !appointment.isCompleted() &&
                            (date == null || date.isBlank() || appointment.getDate().compareTo(date) > 0)) {
                        availableAppointments.add(appointment);
                        found = true;
                    }
                }
            }
        }

        if (!found && (date != null && !date.isBlank())) {
            System.out.println("Brak dostępnych terminów po podanej dacie.");
        }

        availableAppointments.sort(Comparator.comparing(Appointment::getDate));
        return availableAppointments;
    }

    public void removeExpiredAppointments() {
        List<Appointment> expiredAppointments = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.isCompleted()) {
                expiredAppointments.add(appointment);
            }
        }
        appointments.removeAll(expiredAppointments);
    }
}

public class Main {
    public static void main(String[] args) {
        // Utworzenie przychodni
        Clinic clinic = new Clinic();

        // Utworzenie obiektu Scanner do odczytu danych z konsoli
        Scanner scanner = new Scanner(System.in);

        // Dodawanie lekarzy do przychodni
        Doctor doctor1 = new Doctor("Dr. Smith", List.of("Pediatrics", "Family Medicine"));
        Doctor doctor2 = new Doctor("Dr. Johnson", List.of("Dermatology", "Oncology"));
        clinic.addDoctor(doctor1);
        clinic.addDoctor(doctor2);

        // Dodawanie terminów wizyt dla lekarza doctor1
        Appointment appointment1a = new Appointment("2022-02-12", doctor1);
        doctor1.addAppointment(appointment1a);
        Appointment appointment1b = new Appointment("2022-02-12", doctor1);
        doctor1.addAppointment(appointment1b);
        Appointment appointment1c = new Appointment("2022-02-15", doctor1);
        doctor1.addAppointment(appointment1c);
        Appointment appointment1d = new Appointment("2023-04-12", doctor1);
        doctor1.addAppointment(appointment1d);
        Appointment appointment1e = new Appointment("2024-06-20", doctor1);
        doctor1.addAppointment(appointment1e);
        Appointment appointment1f = new Appointment("2025-09-18", doctor1);
        doctor1.addAppointment(appointment1f);
        Appointment appointment1g = new Appointment("2026-11-05", doctor1);
        doctor1.addAppointment(appointment1g);
        Appointment appointment1h = new Appointment("2027-12-25", doctor1);
        doctor1.addAppointment(appointment1h);
        Appointment appointment1i = new Appointment("2028-03-09", doctor1);
        doctor1.addAppointment(appointment1i);
        Appointment appointment1j = new Appointment("2029-05-17", doctor1);
        doctor1.addAppointment(appointment1j);
        Appointment appointment1k = new Appointment("2030-07-24", doctor1);
        doctor1.addAppointment(appointment1k);
        Appointment appointment1l = new Appointment("2031-10-22", doctor1);
        doctor1.addAppointment(appointment1l);

        // Dodawanie terminów wizyt dla lekarza doctor2
        Appointment appointment2a = new Appointment("2022-02-12", doctor2);
        doctor2.addAppointment(appointment2a);
        Appointment appointment2b = new Appointment("2022-02-13", doctor2);
        doctor2.addAppointment(appointment2b);
        Appointment appointment2c = new Appointment("2022-02-14", doctor2);
        doctor2.addAppointment(appointment2c);
        Appointment appointment2d = new Appointment("2023-03-10", doctor2);
        doctor2.addAppointment(appointment2d);
        Appointment appointment2e = new Appointment("2024-04-15", doctor2);
        doctor2.addAppointment(appointment2e);
        Appointment appointment2f = new Appointment("2025-05-20", doctor2);
        doctor2.addAppointment(appointment2f);
        Appointment appointment2g = new Appointment("2026-06-25", doctor2);
        doctor2.addAppointment(appointment2g);
        Appointment appointment2h = new Appointment("2027-07-30", doctor2);
        doctor2.addAppointment(appointment2h);
        Appointment appointment2i = new Appointment("2028-08-05", doctor2);
        doctor2.addAppointment(appointment2i);
        Appointment appointment2j = new Appointment("2029-09-10", doctor2);
        doctor2.addAppointment(appointment2j);
        Appointment appointment2k = new Appointment("2030-10-15", doctor2);
        doctor2.addAppointment(appointment2k);
        Appointment appointment2l = new Appointment("2031-11-20", doctor2);
        doctor2.addAppointment(appointment2l);

        // Interakcja z użytkownikiem
        System.out.println("Witaj w systemie obsługi przychodni!");
        System.out.println("Dostępni lekarze:");
        for (Doctor doctor : clinic.getDoctors()) {
            System.out.println(doctor.getName());
        }

        System.out.print("Wybierz lekarza: ");
        String selectedDoctor = scanner.nextLine();

        Doctor doctor = null;
        for (Doctor d : clinic.getDoctors()) {
            if (d.getName().equals(selectedDoctor)) {
                doctor = d;
                break;
            }
        }

        if (doctor == null) {
            System.out.println("Niepoprawny wybór lekarza.");
            return;
        }

        System.out.println("Dostępne specjalizacje:");
        for (String specialty : doctor.getSpecialties()) {
            System.out.println(specialty);
        }

        System.out.print("Wybierz specjalizację: ");
        String selectedSpecialty = scanner.nextLine();

        System.out.print("Wybierz datę (w formacie RRRR-MM-DD): ");
        String selectedDate = scanner.nextLine();

        List<Appointment> availableAppointments = clinic.findAvailableAppointments(selectedSpecialty, selectedDate);
        System.out.println("Dostępne terminy:");
        for (int i = 0; i < Math.min(5, availableAppointments.size()); i++) {
            Appointment appointment = availableAppointments.get(i);
            System.out.println((i + 1) + ". " + appointment.getDate() + " - " + appointment.getDoctor().getName());
        }

        System.out.print("Wybierz numer terminu: ");
        int selectedAppointmentIndex;
        try {
            selectedAppointmentIndex = scanner.nextInt();
            scanner.nextLine(); // Pobranie znaku nowej linii po wczytaniu liczby
        } catch (InputMismatchException e) {
            System.out.println("Niepoprawny wybór terminu.");
            return;
        }

        if (selectedAppointmentIndex < 1 || selectedAppointmentIndex > availableAppointments.size()) {
            System.out.println("Niepoprawny wybór terminu.");
            return;
        }

        Appointment selectedAppointment = availableAppointments.get(selectedAppointmentIndex - 1);
        String selectedAppointmentDate = selectedAppointment.getDate();

        if (!selectedAppointmentDate.equals(selectedDate)) {
            System.out.println("Niepoprawny wybór terminu.");
            return;
        }

        System.out.print("Podaj imię i nazwisko pacjenta: ");
        String patientName = scanner.nextLine();

        Patient patient = new Patient(patientName);
        selectedAppointment.reserve(patient);

        System.out.println("Termin został zarezerwowany dla pacjenta " + patient.getName());
    }
}