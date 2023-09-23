package Services;

import java.io.*;
import java.time.LocalDateTime;

public class AuditService {
    public static AuditService auditService;

    private AuditService() {}

    public static AuditService getAuditService(){
        if (auditService == null)
            auditService = new AuditService();
        return auditService;
    }

    public void writeAction(String action){
        try (FileWriter fileWriter = new FileWriter("C:\\Users\\Alex\\OneDrive\\Desktop\\PAO\\Proiect-magazinArticoleSportive\\data\\audit.csv", true)){
            File file = new File("C:\\Users\\Alex\\OneDrive\\Desktop\\PAO\\Proiect-magazinArticoleSportive\\data\\audit.csv");

            if (file.length() == 0){
                fileWriter.append("nume_actiune").append(",").append("timestamp").append("\n");
            }

            LocalDateTime date = LocalDateTime.now();
            fileWriter.append(action).append(",").append(String.valueOf(date)).append("\n");
            fileWriter.flush();

        } catch (IOException e) {
            System.out.println("\n\texceptie: " + e.getMessage());
        }
    }
}
