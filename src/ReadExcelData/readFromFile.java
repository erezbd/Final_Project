package ReadExcelData;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class readFromFile 
{
	XSSFWorkbook wb , work ;
	XSSFSheet sheet1 , chackSheet;
	public unionCourse [] courseArray;
	public academicRespo [] academicArr;
	public  Object[] temp; 
	public String [] sortHeadOfDep;	
	public int [] sortCourseCode;
	File academic , pars , chack , union;
	String newParsingPath;
	writeToFile write  = new writeToFile();
	Component frame = null;

	
	
	public void parsingFileRead(String path)
	{
		write.creatParsFile();      // create the layout of the new file
		parsing p = new parsing(); // pointer to pars class
		try
		{
			
		 pars = new File(path);  // create connection to the old file that need parsing

		 wb = new XSSFWorkbook(pars); // create new workbook 
				
		 sheet1 = wb.getSheetAt(0);  // get the sheet from workbook
			
		 	int i =0;				// start from 2 , the first 2 rows if headline			
			for(Row row : sheet1)  // run on all the rows
			{
			
			row = sheet1.getRow(i); // get row 
			
			String date =(String) row.getCell(2).getStringCellValue(); 						// date string

			String time =(String) row.getCell(3).getStringCellValue(); 						// time string

			int numOfApp =(int) row.getCell(4).getNumericCellValue(); 						// num int

			String message =(String) row.getCell(11).getStringCellValue();					// pars string

			int id = (int) row.getCell(14).getNumericCellValue(); 							// ID int
			
			String nemeOfStudent = (String)row.getCell(15).getStringCellValue(); 			// student name string
			
			String departmant = (String)row.getCell(16).getStringCellValue();  				// name of dep' string
			
			int numOfyears = (int)row.getCell(17).getNumericCellValue(); 					// years of studying int

			write.writeCell(date, time, numOfApp, id,nemeOfStudent,departmant,numOfyears);	// sand the info to write class
			p.pars(message , write ); 														// sand to message to parsing class , with pointer to write class

			i++; // count
				if(i==sheet1.getLastRowNum()+1) // break
					break;
			}

			newParsingPath = pars.getParent()+"\\newParingFile.xlsx"; // create path to new file, in the old file folder 
			write.writeObj(newParsingPath); 						 // send the new path to write the parsing data to the file
			wb.close();
		}
		
		
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(frame,
				    e.toString(),
				    "parsingFileRead error",
				    JOptionPane.ERROR_MESSAGE);		}


	}
	
	
	// create array of abject's, that each obj' contain several vars of change course codes 
	public void unionKorss(String path)
	{
		
		try
		{
			File scr = new File(path);//get the file that contain the info
			
			//FileInputStream stream = new FileInputStream(scr); // open stream to the file
		
			 wb = new XSSFWorkbook(scr); // get the workbook of the file
			 sheet1 = wb.getSheetAt(0);  // get the sheet of the workbook
			
			int start = 1 , end = 0 , newCourseCode , index = 7 ; // index is the colon that contain the new curse code in the file

			courseArray = new unionCourse[sheet1.getLastRowNum()];//create new array of abject in the size of the file 
			
			for (int i = 0; i < courseArray.length; i++) { // loop that create empty objects
				courseArray[i] = new unionCourse();
			}
			newCourseCode = (int)sheet1.getRow(1).getCell(index).getNumericCellValue();//get the first row
			int temp =0;
			for (int i = 2; i < sheet1.getLastRowNum(); i++) 
			{
				System.out.println(i);

				if(sheet1.getRow(i).getCell(index).getCellType() == 0) // check how many rows change to same new curse code cell type == 0 check if we get numeric value
				{
					end = i; // num of rows that need to change to same new course code
					
					temp = (int)sheet1.getRow(i).getCell(index).getNumericCellValue(); // temp contain the new course code
					System.out.println(newCourseCode);

					for (int j = start; j < end; j++) // loop that write to array the info. 
					{	
						courseArray[j-1].setDepartment(sheet1.getRow(j).getCell(0).getStringCellValue()); // set to array the dep value
						courseArray[j-1].setOldCourse((int)sheet1.getRow(j).getCell(1).getNumericCellValue()); // set to array the old curse code
						courseArray[j-1].setDepHead( sheet1.getRow(j).getCell(6).getStringCellValue()); // set the head of the dep - have no use so far
						courseArray[j-1].setNewCourse(newCourseCode); //set  the new curse code 
					}
					newCourseCode = temp;
					start = end;	// update the start to know from where to run next loop
				}
			}

			for (int i = start; i < sheet1.getLastRowNum()+1; i++) // run for the last rows in the file 
			{
				courseArray[i-1].setDepartment(sheet1.getRow(i).getCell(0).getStringCellValue()); // set to array the dep value
				courseArray[i-1].setOldCourse((int)sheet1.getRow(i).getCell(1).getNumericCellValue()); // set to array the old curse code
				courseArray[i-1].setDepHead( sheet1.getRow(i).getCell(6).getStringCellValue()); // set the head of the dep - have no use so far
				courseArray[i-1].setNewCourse(newCourseCode); //set  the new curse code 
			}
			for (int i = 0; i < courseArray.length; i++) {
				System.out.println(courseArray[i].toString());
			}
			
		}
		
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(frame,
				    e.toString(),
				    "unionKorss error",
				    JOptionPane.ERROR_MESSAGE);			}	
	
	}

	
	// create array of abject's, that each obj' contain several vars of head of dep' 
	public void academic(String path)
	{
		try 
		{
			academic = new File(path);	// get the file of academics 

			wb = new XSSFWorkbook(academic); // get the workbook
			int sizeOfArray = 0;
			
			for (int i = 0; i < wb.getNumberOfSheets();  i++) // the file contain few sheet's so it's run on all of them and count the rows num   
			{
				sizeOfArray = sizeOfArray + wb.getSheetAt(i).getLastRowNum();
			}

			academicArr = new academicRespo[sizeOfArray]; // create new array of abj in the correct size
			int cellOfCode = 0; // the info is in colon 0 
			int cellOfAca = 1;  // the info is in colon 1
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
	
		} 
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(frame,
				    e.toString(),
				    "academic error",
				    JOptionPane.ERROR_MESSAGE);			}

	}
	
	
	
	public void chack()
	{
		int indexCorseCode , indexHeadOfDep;
		indexCorseCode = 8;
		indexHeadOfDep = 15;
		try
		{

			//write.writeObj("C:\\Users\\erez\\Desktop\\בשם השם נעשה ונצליח!!\\writeTest\\academic.xlsx" , wb);
			//chack = new File (newParsingPath);
			FileInputStream chack = new FileInputStream(newParsingPath);

			wb = new XSSFWorkbook(chack);

			sheet1 = wb.getSheetAt(0);
			System.out.println("chack : BEFOR LOOP");

			for (int i = 1; i <sheet1.getLastRowNum() ; i++) 
			{
				System.out.println("loop 1");
				System.out.println(i);
				System.out.println(sheet1.getRow(i).getCell(indexCorseCode));

		//		System.out.println(sortCourseCode.length);
				//System.out.println(sortCourseCode[sortCourseCode.length-1]);

				if(sheet1.getRow(i).getCell(indexCorseCode).getNumericCellValue() != -1)
				{
					System.out.println("if 1");

					int course = (int) sheet1.getRow(i).getCell(indexCorseCode).getNumericCellValue();
					System.out.println(course);

					//s = s.replace(" ", "");
				//	int course = Integer.parseInt(s);
					//System.out.println(course);

					int index = 0;
					for (int j = 0; j < sortCourseCode.length-1; j++) 
					{
						System.out.println("loop 2");

						if(sortCourseCode[j]==course)
						{
							System.out.println("if 2");
							index = j;
							break;
						}
					}
					System.out.println("befor insert");
					//System.out.println(chackSheet.getRow(i).getCell(12).getCellType());

					sheet1.getRow(i).getCell(indexHeadOfDep).setCellValue(sortHeadOfDep[index]);
					System.out.println("after insert");

				}
				System.out.println("not go in");

			}
			System.out.println("not go in2");

	        FileOutputStream fileOut = new FileOutputStream(newParsingPath);
			wb.write(fileOut);
			fileOut.close();
			wb.close();
			chack.close();
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(frame,
				    e.toString(),
				    "chack error",
				    JOptionPane.ERROR_MESSAGE);			}
		
	}
	
	public void unionCodeCheck()
	{
		try{
			System.out.println("unionCodeCheck");
		    FileInputStream fis = new FileInputStream(newParsingPath);
		    
		 //  wb = new XSSFWorkbook(fis);
	//	wb = new XSSFWorkbook(new FileInputStream(newParsingPath));

			System.out.println("open file");

		//union = new File (newParsingPath);
		
		wb = new XSSFWorkbook(fis);

		sheet1 = wb.getSheetAt(0);
		int index = 16;
		String reject1,reject2,reject3;
		String temp="";
		for (int i = 1; i <sheet1.getLastRowNum() ; i++) 
		{
			reject1= sheet1.getRow(i).getCell(10).getStringCellValue();
			reject2= sheet1.getRow(i).getCell(11).getStringCellValue();
			reject3= sheet1.getRow(i).getCell(12).getStringCellValue();
			for (int j = 0; j < courseArray.length; j++) 
			{
				String oldCorse =String.valueOf(courseArray[j].getOldCourse());
				if(reject1 !="Null" && reject1.contains(oldCorse)){
					//sheet1.getRow(i).getCell(index).setCellValue(String.valueOf(courseArray[j].getNewCourse())+ ", ");
					temp = temp + String.valueOf(courseArray[j].getNewCourse())+ ", ";
				}
				if(reject2 !="Null" && reject2.contains(oldCorse)){
					//sheet1.getRow(i).getCell(index).setCellValue(String.valueOf(courseArray[j].getNewCourse())+ ", ");
					temp = temp + String.valueOf(courseArray[j].getNewCourse())+ ", ";

				}
				if(reject3 !="Null" && reject3.contains(oldCorse)){
					//sheet1.getRow(i).getCell(index).setCellValue(String.valueOf(courseArray[j].getNewCourse())+ ", ");
					temp = temp + String.valueOf(courseArray[j].getNewCourse())+ ", ";

				}
			}
			sheet1.getRow(i).getCell(index).setCellValue(temp);
			temp = "";
		}
		System.out.println("'WRITE file");

        FileOutputStream fileOut = new FileOutputStream(newParsingPath);
		wb.write(fileOut);
		fileOut.close();
		wb.close();
		fis.close();
		
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(frame,
				    e.toString(),
				    "unionCodeCheck error",
				    JOptionPane.ERROR_MESSAGE);			}	
	}
	public void color()
	{
		try
		{
			System.out.println("1");
	
		    FileInputStream fis = new FileInputStream(newParsingPath);
			wb = new XSSFWorkbook(fis);
			sheet1 = wb.getSheetAt(0);
	
			String ignore1 ="הקורס חסום לרישום באינטרנט";
			String ignore2 = "קורס מלא";
			String ignore3 = "ישנה מגבלה בקורס זה לאוכלוסיות מסוימות ואינך מוגדר באוכלוסיות אלו";
			CellStyle style = null;
			
			for (int i = 1; i < sheet1.getLastRowNum(); i++)
				{
					System.out.println(i);
		
					for (int j = 10; j < 13; j++) 
					{
						String temp = sheet1.getRow(i).getCell(j).getStringCellValue();
						Cell cell;
						if(temp.contains(ignore1)||temp.contains(ignore2)||temp.contains(ignore3))
						{
							style = wb.createCellStyle();
					        style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
					        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
					        for (int k = 0; k < 17; k++) 
					        {
						        cell = sheet1.getRow(i).getCell(k);
						        cell.setCellStyle(style);
							}

						}
					}
				}
		    FileOutputStream fileOut = new FileOutputStream(newParsingPath);
		    wb.write(fileOut);
			fileOut.close();
			wb.close();
			fis.close();
		}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(frame,
					    e.toString(),
					    "color error",
					    JOptionPane.ERROR_MESSAGE);				}		
	}
	
}




