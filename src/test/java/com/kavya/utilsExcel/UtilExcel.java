package com.kavya.utilsExcel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class UtilExcel {
    // this has to read the data - testdata.xlsx
    // 1. create workbook
    // 2. work with sheet
    // 3. reading data from rows and column
    // 4. convert to 2D - getData()

    public static String file_path = System.getProperty("user.dir")+"/src/test/resources/TestData.xlsx";
    static Workbook workbook;
    static Sheet sheet;

    public static Object[][] getTestDataFromExcel(String sheetName){

        FileInputStream fileInputStream=null;
        try{
            fileInputStream = new FileInputStream(file_path);
            workbook = WorkbookFactory.create(fileInputStream);
            sheet = workbook.getSheet(sheetName);

        }catch(IOException e){
            System.out.println("File Not Found");
        }

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i=0; i<sheet.getLastRowNum();i++){
            for (int j=0; j<sheet.getRow(0).getLastCellNum();j++){
                data[i][j]=sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return data;
    }


}
