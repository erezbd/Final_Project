package ReadExcelData;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.standard.MediaSize.Other;

import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.formula.SheetRangeIdentifier;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.streaming.SheetDataWriter;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writeToFile 
{
	Cell date , time, num, id ;
	
	Workbook work = new XSSFWorkbook();
	Sheet sheet1 = work.createSheet();
	Sheet sheet2 ;  
	public void writeCell(Cell date , Cell time , Cell num , Cell id)
	{
		this.date = date;
		this.time = time;
		this.num=num;
		this.id=id;
		
	}
	
	
	
	public void creatParsFile() // יש ליצור פה את כל הקבצים הדרושים ושדותיהם
	{
		System.out.println("creatParsFile class");

		
			try
			{

	        Row rowHeading = sheet1.createRow(0);
	        
	       // Cell cell;
	        
	    	   rowHeading.createCell(0).setCellValue("ID    ");
	        	    
			   rowHeading.createCell(1).setCellValue("AppNamber  ");
			   

			   rowHeading.createCell(2).setCellValue("Date");
	        

			   rowHeading.createCell(3).setCellValue("Time    ");

			    
	        rowHeading.createCell(4).setCellValue("Course Name");
	        
	        rowHeading.createCell(5).setCellValue("Course Code");
	        
	        rowHeading.createCell(6).setCellValue("Course Detail");
	        
	        rowHeading.createCell(7).setCellValue("Reason Of Rejection 1");
	        
	        rowHeading.createCell(8).setCellValue("Reason Of Rejection 12");
	        
	        rowHeading.createCell(9).setCellValue("Reason Of Rejection 1");
	        
	        rowHeading.createCell(10).setCellValue("Student Message   ");
	        
	        rowHeading.createCell(11).setCellValue("Other    ");
	        
        	sheet1.setAutoFilter(new CellRangeAddress(0, sheet1.getLastRowNum() + 1, 0, 11));
        	
	        
	        
		        for (int i = 0; i < 12; i++) 
		        {
					CellStyle style = work.createCellStyle();
	
					Font font = work.createFont();
					font.setBold(true);
					font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
					font.setFontHeightInPoints((short) 11);
					style.setFont(font);
					style.setVerticalAlignment(CellStyle.ALIGN_CENTER);
					rowHeading.getCell(i).setCellStyle(style);
			
		
					sheet1.autoSizeColumn(i);
					sheet1.getColumnOutlineLevel(i);
				}

			}
			
			catch (Exception e)
			{
				System.out.println(e.toString() + "  " + e.getMessage());
			}
		
	}
	
	
	
	public void writeParsingFile(String korssInfo ,String wantedKorss,String korssCode, String studentMessage,String[] res , String unParsingMessage ,int rowPars)
	{
		

		try
		{

			Row row = sheet1 .createRow(rowPars);			
			row.createCell(0).setCellValue(id.getNumericCellValue());
			sheet1.autoSizeColumn(0);

			row.createCell(1).setCellValue(num.getNumericCellValue());
			sheet1.autoSizeColumn(1);
			

			row.createCell(2).setCellValue(date.toString());
			sheet1.autoSizeColumn(2);

			row.createCell(3).setCellValue(time.toString());
			sheet1.autoSizeColumn(3);

			row.createCell(4).setCellValue(wantedKorss);
			sheet1.autoSizeColumn(5);

			row.createCell(5).setCellValue(korssCode);
			sheet1.autoSizeColumn(6);


	        row.createCell(6).setCellValue(korssInfo);
			sheet1.autoSizeColumn(7);

	       
        for (int i = 0; i < res.length; i++) {
            row.createCell(7+i).setCellValue(res[i]);
			//sheet1.autoSizeColumn(7+i);

		}
        
	    
	        row.createCell(10).setCellValue(studentMessage);
		//	sheet1.autoSizeColumn(10);

	        row.createCell(11).setCellValue(unParsingMessage);
		//	sheet1.autoSizeColumn(11);



		}
		
		catch (Exception e)
		{
			System.out.println(e.toString() + "  " + e.getMessage());
		}
		

	}
	

	public void writeObj()
	{
		try 
		{
			
	        FileOutputStream fileOut = new FileOutputStream("C:\\Users\\erez\\Desktop\\בשם השם נעשה ונצליח!!\\writeTest\\Books.xlsx");

	        work.write(fileOut);
	      
		    fileOut.close();
		    work.close();
		} 
		catch (Exception e) 
		{
			System.out.println(e.toString() + "  " + e.getMessage());

		}
	}
	
	

}
