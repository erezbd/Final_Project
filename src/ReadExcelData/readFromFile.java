package ReadExcelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.print.attribute.standard.MediaSize.Other;
import javax.swing.text.AbstractDocument.BranchElement;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class readFromFile 
{
	XSSFWorkbook wb ;
	XSSFSheet sheet1 ;

	public unionCourse [] courseArray;
	public academicRespo [] academicArr;
	public  Object[] temp;
	public String [] sortHeadOfDep;	
	public int [] sortCourseCode;

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
	
		 wb = new XSSFWorkbook(scr);
		
	//	FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
		
		 sheet1 = wb.getSheetAt(0);
			
		 	int i =2;
			for(Row row : sheet1)
			{
			
			row = sheet1.getRow(i);
			
			Cell date = row.getCell(2); // date string

			Cell time = row.getCell(3); // time string

			Cell numOfApp = row.getCell(4); // num int

			Cell message = row.getCell(11); // pars string

			Cell id = row.getCell(14); // ID int

			write.writeCell(date, time, numOfApp, id);
			p.pars(message.getStringCellValue() , write );

			i++;
				if(i==sheet1.getLastRowNum()+1)
					break;
			}
			write.writeObj();
			wb.close();
			fis.close();
		}
		
		
		catch (Exception e)
		{
			System.out.println(e.toString() + "  " + e.getMessage());
			
		}


	}
	
	
	
	public void unionKorss()
	{
		
		
		try
		{
			File scr = new File("C:\\Users\\erez\\Desktop\\בשם השם נעשה ונצליח!!\\files\\איחוד קורסים תשעה.xlsx");
			
			FileInputStream stream = new FileInputStream(scr);
		
			 wb = new XSSFWorkbook(scr);
			 sheet1 = wb.getSheetAt(0);
			
			int start = 1 , end = 0 , newCourseCode ;

			courseArray = new unionCourse[sheet1.getLastRowNum()];
			
			for (int i = 0; i < courseArray.length; i++) {
				courseArray[i] = new unionCourse();
			}
			System.out.println(sheet1.getLastRowNum());
			newCourseCode = (int)sheet1.getRow(1).getCell(7).getNumericCellValue();
			int temp =0;
			for (int i = 2; i < sheet1.getLastRowNum(); i++) 
			{
				System.out.println(i);

				if(sheet1.getRow(i).getCell(7).getCellType() == 0)
				{
					end = i;
					
					temp = (int)sheet1.getRow(i).getCell(7).getNumericCellValue();
					System.out.println(temp);

					for (int j = start; j < end; j++) 
					{
						
						courseArray[j-1].setDepartment(sheet1.getRow(j).getCell(0).getStringCellValue());
						courseArray[j-1].setOldCourse((int)sheet1.getRow(j).getCell(1).getNumericCellValue());
						courseArray[j-1].setDepHead( sheet1.getRow(j).getCell(6).getStringCellValue());
						courseArray[j-1].setNewCourse(newCourseCode);
						
					}
					newCourseCode = temp;
					start = end;	
				}
			}
			for (int i = 0; i < courseArray.length; i++) {
				System.out.println(courseArray[i].toString());
			}
			
			wb.close();
			stream.close();
			
		}
		
		catch (Exception e)
		{
			System.out.println(e.toString());
			
		}	
	
	}

	
	
	public void academic()
	{
		try 
		{
			File scr = new File("C:\\Users\\erez\\Desktop\\אחראים אקדמים.xlsx");	
			wb = new XSSFWorkbook(scr);
			int sizeOfArray = 0;
			
			for (int i = 0; i < wb.getNumberOfSheets();  i++) {
				sizeOfArray = sizeOfArray + wb.getSheetAt(i).getLastRowNum();
			}
			
			academicArr = new academicRespo[sizeOfArray];
			int cellOfCode = 0;
			int cellOfAca = 1;
			int count = 0;


			for (int i = 0; i < wb.getNumberOfSheets();  i++) {
				for (int j = 1; j <= wb.getSheetAt(i).getLastRowNum(); j++) {
					
					academicArr[count] = new academicRespo();
					academicArr[count].setCourseCode((int) wb.getSheetAt(i).getRow(j).getCell(cellOfCode).getNumericCellValue());
					academicArr[count].setHeadOfDep(wb.getSheetAt(i).getRow(j).getCell(cellOfAca).getStringCellValue());
					count++;
					
				}
			}
				
				Set<Integer> set = new HashSet<Integer>();
				
			    for(int i = 0; i<academicArr.length; i++)
			     {
			         set.add(academicArr[i].getCourseCode());
			     }
		    
			    temp = new Object[set.size()]; 
			    temp = set.toArray();
			    sortCourseCode = new int[set.size()];
			    for (int i = 0; i < temp.length; i++) {
			    	sortCourseCode[i] = (int)temp[i];
				}
			    Arrays.sort(sortCourseCode);
			    boolean f = false;
			    
			    sortHeadOfDep = new String[sortCourseCode.length];
			    
			    for (int i = 0; i < sortCourseCode.length; i++) {
					for (int j = 0; j < academicArr.length ; j++) {
						
						if(sortCourseCode[i]==academicArr[j].getCourseCode())
						{
							sortHeadOfDep[i] = academicArr[j].getHeadOfDep();
							break;
						}
						
					}
					
				}
			    
			    for (int i = 0; i < sortHeadOfDep.length; i++) {
			    	
					System.out.println("row num "+ i + "  "+ sortHeadOfDep[i] + "  " + sortCourseCode[i]);

				}
			    
			    wb.close();
			
			
		} 
		catch (Exception e) 
		{
			System.out.println(e.toString() + "  " + e.getMessage());
		}

	}
	
	
	
	
}

