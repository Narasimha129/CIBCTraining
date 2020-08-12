package Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.helpers.XSSFRowShifter;

import Constants.Constants;
import Constants.NewLog;

@SuppressWarnings("unused")

public class ExcelUtils {

	private static HSSFSheet ExcelWSheet,TestNameWSheet,TestDataWSheet,TestHarnessWSheet;
	private static HSSFWorkbook ExcelWBook,TestNameWBook,TestDataWBook,TestHarnessWBook;
	private static org.apache.poi.ss.usermodel.Cell Cell;
	private static XSSFCell cello;
	private static HSSFRow Cell1;
	private static HSSFRow Row;

	public static void setTestExcelFile(String Path) throws Exception {
		try {
			FileInputStream testNameFile = new FileInputStream(Path);
			TestNameWBook = new HSSFWorkbook(testNameFile);

		} catch (Exception e){
			
		}
	}

	public static void setTestDataExcel(String Path) throws Exception {
		try {
			FileInputStream testDataFile = new FileInputStream(Path);
			TestDataWBook = new HSSFWorkbook(testDataFile);
		} catch (Exception e){
			
		}
	}
	
	

	public static void setHarnessExcel(String Path) throws Exception {
		try {
			FileInputStream testHarnessFile = new FileInputStream(Path);
			TestHarnessWBook = new HSSFWorkbook(testHarnessFile);
		} catch (Exception e){
			
		}
	}

	public static void setHarnessExcelFile(String Path) throws Exception {
		try {
			FileInputStream ExcelHarnessFile = new FileInputStream(Path);
			TestHarnessWBook = new HSSFWorkbook(ExcelHarnessFile);
		} catch (Exception e){
			
		}
	}

	public static String getCellData(int RowNum, int ColNum, String SheetName ) throws Exception{
		try{
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			HSSFRow row = ExcelWSheet.getRow(RowNum);
			if(row != null){
				Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
				String CellData = Cell.getStringCellValue();
				return CellData;
			}
			else
				return "";
		}catch (Exception e){
			
			return"";
		}
	}
	public static String getMethodNamefromLibrarySheet(String Path, String excelSheetName,String functionName) throws Exception{
		String librayKeywordName = "";
		try{
		File file =    new File(Path);
		FileInputStream libraryMappingFile = new FileInputStream(file);
		XSSFWorkbook excelWorkBook = new XSSFWorkbook(libraryMappingFile);
	    XSSFSheet ipSheet = excelWorkBook.getSheetAt(0);
		int totalNoofRows = ipSheet.getLastRowNum();
			
		XSSFRow row;
			for(int i=0;i<=totalNoofRows;i++){
				
				row = ipSheet.getRow(i);
				 String column1Val = "";
 	            XSSFCell cell0 = row.getCell(0);
 	            
 	            if (cell0 != null)
 	            column1Val = cell0.getStringCellValue().trim();
 	            if(column1Val.contentEquals(functionName)){
 	            	 XSSFCell cell1 = row.getCell(1);
 	 	            
 	 	            if (cell1 != null)
 	 	            	librayKeywordName = cell1.getStringCellValue().trim();
 	            }
				
			}	
			libraryMappingFile.close();
			return librayKeywordName;
		}catch (Exception e){
			
			e.printStackTrace();
		}
		return librayKeywordName;
	}
	
	public static int getParameterNofromLibrarySheet(String Path, String excelSheetName,String functionName) throws Exception{
		int noofParameters = 0;
		try{
		File file =    new File(Path);
		FileInputStream libraryMappingFile = new FileInputStream(file);
		XSSFWorkbook excelWorkBook = new XSSFWorkbook(libraryMappingFile);
	    XSSFSheet ipSheet = excelWorkBook.getSheetAt(0);
		int totalNoofRows = ipSheet.getLastRowNum();
			
		XSSFRow row;
			for(int i=0;i<=totalNoofRows;i++){
				
				row = ipSheet.getRow(i);
				  String column1Val = "";
 	            XSSFCell cell0 = row.getCell(0);
 	            
 	            if (cell0 != null)
 	            column1Val = cell0.getStringCellValue().trim();
 	            if(column1Val.contentEquals(functionName)){
 	            	 XSSFCell cell1 = row.getCell(2);
 	 	            
 	 	            if (cell1 != null){
 	 	            	noofParameters =   Integer.parseInt(cell1.getStringCellValue());
 	 	            	break;
 	 	            }
 	            }
				
			}	
			
			return noofParameters;
		}catch (Exception e){
			
			e.printStackTrace();
		}
		return noofParameters;
	}
	
	public static String getStepData(int RowNum, int ColNum, String SheetName ) throws Exception{
		try{
			TestDataWSheet = TestDataWBook.getSheet(SheetName);
			HSSFRow row = TestDataWSheet.getRow(RowNum);
			if(row != null){
				Cell = TestDataWSheet.getRow(RowNum).getCell(ColNum);
				String CellData = Cell.getStringCellValue();

				return CellData;
			}
			else
				return "";
		}catch (Exception e){
			if(e.getMessage()!=null && e.getMessage().equals("Cannot get a text value from a numeric cell")){
				int value = (int) Cell.getNumericCellValue();
				return String.valueOf(value);
			}

			return"";
		}
	}
	public static String getHarnessData(int RowNum, int ColNum, String SheetName ) throws Exception{
		try{
			TestHarnessWSheet = TestHarnessWBook.getSheet(SheetName);
			HSSFRow row = TestHarnessWSheet.getRow(RowNum);
			if(row != null){
				Cell = TestHarnessWSheet.getRow(RowNum).getCell(ColNum);
				String CellData = Cell.getStringCellValue();
				return CellData;
			}
			else
				return "";
		}catch (Exception e){
			
			return"";
		}
	}
	public static String getTDCellData(int RowNum, int ColNum, String SheetName ) throws Exception{
		try{
			TestDataWSheet = TestDataWBook.getSheet(SheetName);
			HSSFRow row = TestDataWSheet.getRow(RowNum);
			if(row != null){
				Cell = TestDataWSheet.getRow(RowNum).getCell(ColNum);
				String CellData = Cell.getStringCellValue();
				return CellData;
			}
			else
				return "";
		}catch (Exception e){
			return"";
		}
	}

	public static String getTestCellData(int RowNum, int ColNum, String SheetName ) throws Exception{
		try{
			TestNameWSheet = TestNameWBook.getSheet(SheetName);
			HSSFRow row = TestNameWSheet.getRow(RowNum);

			if(row != null){
				Cell = TestNameWSheet.getRow(RowNum).getCell(ColNum);
				String CellData = Cell.getStringCellValue();
				return CellData;
			}
			else
				return "";
		}catch (Exception e){
			return"";
		}
	}


	@SuppressWarnings("static-access")
	public static void setVerdictCellData(String Result,  int RowNum, int ColNum, String SheetName) throws Exception    {
		try{

			TestNameWSheet = TestNameWBook.getSheet(SheetName);
			Row  = TestNameWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}
			FileOutputStream fileOut = new FileOutputStream(Constants.Path_TestExecution);
			TestNameWBook.write(fileOut);
			fileOut.close();
			TestNameWBook = new HSSFWorkbook(new FileInputStream(Constants.Path_TestExecution));
		}catch(Exception e){
			
		}
	}


	public static int getRowCount(String SheetName){
		int iNumber=0;
		try {
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			iNumber=ExcelWSheet.getLastRowNum()+1;
		} catch (Exception e){
			
		}
		return iNumber;
	}
	public static int getStepCount(String SheetName){
		int iNumber=0;
		try {
			TestDataWSheet = TestDataWBook.getSheet(SheetName);
			iNumber=TestDataWSheet.getLastRowNum()+1;
		} catch (Exception e){
			
		}
		return iNumber;
	}
	public static int getTestRowCount(String SheetName){
		int iNumber=0;
		try {
			TestNameWSheet = TestNameWBook.getSheet(SheetName);
			iNumber=TestNameWSheet.getLastRowNum()+1;
		} catch (Exception e){
			
		}
		return iNumber;
	}
	@SuppressWarnings("static-access")
	public static void setTestCaseResult(String Result,  int RowNum, int ColNum, String SheetName) throws Exception    {
		try{

			TestNameWSheet = TestNameWBook.getSheet(SheetName);
			Row  = TestNameWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}
			FileOutputStream fileOut = new FileOutputStream(Constants.Path_TestExecution);
			TestNameWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
			TestNameWBook = new HSSFWorkbook(new FileInputStream(Constants.Path_TestExecution));

		}catch(Exception e){
			
		}

	}
	public static int getRowContains(String sTestCaseName, int colNum,String SheetName) throws Exception{
		int iRowNum=0;	
		try {
			int rowCount = ExcelUtils.getRowCount(SheetName);
			for (; iRowNum<rowCount; iRowNum++){
				if  (ExcelUtils.getCellData(iRowNum,colNum,SheetName).equalsIgnoreCase(sTestCaseName)){
					break;
				}
			}       			
		} catch (Exception e){
			
		}
		return iRowNum;
	}

	public static int getTestStepsCount(String SheetName) throws Exception{
		try {
			TestDataWSheet = TestDataWBook.getSheet(SheetName);
			int number=TestDataWSheet.getLastRowNum()+1;
			return number;
		} catch (Exception e){
			return 0;
		}
	}
	public static int getHarnessStepsCount(String SheetName) throws Exception{
		try {
			TestHarnessWSheet = TestHarnessWBook.getSheet(SheetName);
			int number=TestHarnessWSheet.getLastRowNum()+1;
			return number;
		} catch (Exception e){
			return 0;
		}
	}

	@SuppressWarnings("static-access")
	public static void setCellData(String Result,  int RowNum, int ColNum, String SheetName) throws Exception    {
		try{

			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			Row  = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}

		}catch(Exception e){
			
		}
	}

	public static ArrayList<String> getParameterValues(String sTestCaseID, int iTestStep, int noOfParamters) {
		ArrayList<String> paramValues = new ArrayList<>();
		
		try {
	    File file =    new File(Constants.Path_TestCase);
		FileInputStream libraryMappingFile = new FileInputStream(file);
		HSSFWorkbook excelWorkBook = new HSSFWorkbook(libraryMappingFile);
		HSSFSheet ipSheet = excelWorkBook.getSheet(sTestCaseID);
		int totalNoofRows = iTestStep+noOfParamters;
		for(int i=iTestStep; i<totalNoofRows; i++){
			HSSFCell Cell = ipSheet.getRow(i).getCell(4);
			String CellData = Cell.getStringCellValue();
			paramValues.add(CellData);
		}
		return paramValues;
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return paramValues;
	}

}