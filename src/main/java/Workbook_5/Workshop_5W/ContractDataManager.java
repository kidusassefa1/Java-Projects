
package Workbook_5.Workshop_5W;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {
    private static final String fileName = "DataFile_Workshop_5w/contracts.csv";

    public void saveContract(Contract contract) {
        try (BufferedWriter bufWriter = new BufferedWriter(new FileWriter(fileName, true))) {

            bufWriter.write(contract.toString());
            bufWriter.newLine();

        } catch (IOException e) {
            System.out.println("ERROR: Could not save contract.");
            e.printStackTrace();
        }
    }
}
