package ReadExcelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.print.attribute.standard.MediaSize.Other;
import javax.swing.text.AbstractDocument.BranchElement;

import org.apache.poi.ss.examples.formula.CheckFunctionsSupported.FormulaEvaluationProblems;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class readFromFile 
{

	
	String parsingPath, academicPath, unionPath, changePath;
	
	String cellValue = "";
	int numOfSheets , numOfCells , numOfRows ;
	
	
	public void copy(String parsingPath , String academicPath, String unionPath, String changePath)
	{
		this.parsingPath = parsingPath;
		this.academicPath = academicPath;
		this.unionPath = unionPath;
		this.changePath = changePath;

	}
	
	public void parsingFileRead()
	{
		System.out.println("parsingFileRead");

		writeToFile write  = new writeToFile();
		write.creatParsFile();
		parsing p = new parsing();
		try
		{
			
		File scr = new File("C:\\Users\\erez\\Desktop\\ab.xlsx");
		
		FileInputStream fis = new FileInputStream(scr);
	
		XSSFWorkbook wb = new XSSFWorkbook(scr);
		
		FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
		
		XSSFSheet sheet1 = wb.getSheetAt(0);
			
		int i =3;
			for(Row row : sheet1)
			{
				i++;
				Cell date = row.getCell(2); // date string

				Cell time = row.getCell(3); // time string

				Cell numOfApp = row.getCell(4); // num int

				Cell message = row.getCell(11); // pars string

				Cell id = row.getCell(14); // ID int

				write.writeCell(date, time, numOfApp, id);
				p.pars(message.getStringCellValue() , write );
				if(i==15)
					break;
			}
			wb.close();
				fis.close();
		}
		
		
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		

	}
	
}



