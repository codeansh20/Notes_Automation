package notesAutomation.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DP {

    @DataProvider(name = "data-provider")
    public static Object[][] getData() throws IOException {
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/notesAutomation/Utilities/RandomData.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int col_length = sheet.getRow(0).getLastCellNum(); // Number of cells in the header row
        int actualRows = 0;

        // Loop through rows to determine the last non-empty row
        for (int r = 1; r <= sheet.getLastRowNum(); r++) { // Start from row 1 to skip header
            XSSFRow row = sheet.getRow(r);
            if (row == null || row.getPhysicalNumberOfCells() == 0) {
                break; // Stop if we encounter an empty row
            }
            actualRows++; // Count only non-empty rows
        }

        System.out.println("Actual Rows with Data: " + actualRows + ", Columns: " + col_length);

        // Initialize data array based on the actual number of rows with data
        Object[][] data = new Object[actualRows][col_length];

        // Populate data array
        for (int r = 1; r <= actualRows; r++) { // Start from row 1 to skip header
            XSSFRow row = sheet.getRow(r);
            for (int c = 0; c < col_length; c++) {
                XSSFCell cell = row.getCell(c);
                data[r - 1][c] = cell != null ? cell.toString().trim() : ""; // Store data and trim whitespace
            }
        }

        workbook.close();
        file.close();
        return data;
    }
}
