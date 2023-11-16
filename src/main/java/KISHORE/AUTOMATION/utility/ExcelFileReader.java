package KISHORE.AUTOMATION.utility;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelFileReader {
    FileInputStream inputStream ;
    HSSFWorkbook wb;
    public void getData(String filePath,String sheetName){
        File file =    new File(filePath);
        //Create an object of FileInputStream class to read excel file
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //creating workbook instance that refers to .xls file
        try {
            wb = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //creating a Sheet object
        HSSFSheet sheet=wb.getSheet(sheetName);
        //get all rows in the sheet
        int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
        //iterate over all the row to print the data present in each cell.
        for(int i=0;i<=rowCount;i++){
            //get cell count in a row
            int cellcount=sheet.getRow(i).getLastCellNum();
            //iterate over each cell to print its value
            System.out.println("Row"+ i+" data is :");
            for(int j=0;j<cellcount;j++){
                System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() +",");
            }
            System.out.println();
            //return based on the requirements
        }
    }
}