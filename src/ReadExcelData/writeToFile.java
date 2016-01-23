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

import org.apache.poi.ss.formula.SheetRangeIdentifier;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.streaming.SheetDataWriter;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writeToFile 
{
//	int nextRowToWrite = 3;
	Cell date , time, num, id ;

	
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
			Workbook wb = new XSSFWorkbook();
			Sheet sheet1 = wb.createSheet("הודעות דחייה");
		//	CellStyle style = wb.createCellStyle();

			 
			
	        Row rowHeading = sheet1.createRow(0);
	        
	       // Cell cell;
	        
	    	   rowHeading.createCell(0).setCellValue("ת.ז");
	        
//	        	style.setBorderBottom(CellStyle.BORDER_THIN);
//			    style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
//			    style.setBorderLeft(CellStyle.BORDER_THIN);
//			    style.setLeftBorderColor(IndexedColors.GREEN.getIndex());
//			    style.setBorderRight(CellStyle.BORDER_THIN);
//			    style.setRightBorderColor(IndexedColors.BLUE.getIndex());
//			    style.setBorderTop(CellStyle.BORDER_MEDIUM_DASHED);
//			    style.setTopBorderColor(IndexedColors.BLACK.getIndex());
//			    cell.setCellStyle(style);
			    
			   rowHeading.createCell(1).setCellValue("מספר פנייה");
			   
//	        	style.setBorderBottom(CellStyle.BORDER_THIN);
//			    style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
//			    style.setBorderLeft(CellStyle.BORDER_THIN);
//			    style.setLeftBorderColor(IndexedColors.GREEN.getIndex());
//			    style.setBorderRight(CellStyle.BORDER_THIN);
//			    style.setRightBorderColor(IndexedColors.BLUE.getIndex());
//			    style.setBorderTop(CellStyle.BORDER_MEDIUM_DASHED);
//			    style.setTopBorderColor(IndexedColors.BLACK.getIndex());
//			    cell.setCellStyle(style);
	        
			   rowHeading.createCell(2).setCellValue("תאריך פנייה");
	        
//	        	style.setBorderBottom(CellStyle.BORDER_THIN);
//			    style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
//			    style.setBorderLeft(CellStyle.BORDER_THIN);
//			    style.setLeftBorderColor(IndexedColors.GREEN.getIndex());
//			    style.setBorderRight(CellStyle.BORDER_THIN);
//			    style.setRightBorderColor(IndexedColors.BLUE.getIndex());
//			    style.setBorderTop(CellStyle.BORDER_MEDIUM_DASHED);
//			    style.setTopBorderColor(IndexedColors.BLACK.getIndex());
//			    cell.setCellStyle(style);
			    
			   rowHeading.createCell(3).setCellValue("שעת פנייה");
	        
//	       		style.setBorderBottom(CellStyle.BORDER_THIN);
//			    style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
//			    style.setBorderLeft(CellStyle.BORDER_THIN);
//			    style.setLeftBorderColor(IndexedColors.GREEN.getIndex());
//			    style.setBorderRight(CellStyle.BORDER_THIN);
//			    style.setRightBorderColor(IndexedColors.BLUE.getIndex());
//			    style.setBorderTop(CellStyle.BORDER_MEDIUM_DASHED);
//			    style.setTopBorderColor(IndexedColors.BLACK.getIndex());
//			    cell.setCellStyle(style);
			    
	        rowHeading.createCell(4).setCellValue("שם הקורס המבוקש");
	        
	        rowHeading.createCell(5).setCellValue("קוד קורס המבוקש");
	        
	        rowHeading.createCell(6).setCellValue("פרטי הקורס");
	        
	        rowHeading.createCell(7).setCellValue("סיבת דחייה1");
	        
	        rowHeading.createCell(8).setCellValue("סיבת דחייה2");
	        
	        rowHeading.createCell(9).setCellValue("סיבת דחייה3");
	        
	        rowHeading.createCell(10).setCellValue("הודעת סטודנט");
	        
	        rowHeading.createCell(11).setCellValue("אחר");
	
	        
	        
	        for (int i = 0; i < 12; i++) {
				CellStyle style = wb.createCellStyle();
//				 style.setBorderBottom(CellStyle.BORDER_THIN);
//				    style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
//				    style.setBorderLeft(CellStyle.BORDER_THIN);
//				    style.setLeftBorderColor(IndexedColors.GREEN.getIndex());
//				    style.setBorderRight(CellStyle.BORDER_THIN);
//				    style.setRightBorderColor(IndexedColors.BLUE.getIndex());
//				    style.setBorderTop(CellStyle.BORDER_MEDIUM_DASHED);
//				    style.setTopBorderColor(IndexedColors.BLACK.getIndex());
//				    cell.setCellStyle(style);
				Font font = wb.createFont();
				font.setBold(true);
				font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
				font.setFontHeightInPoints((short) 11);
				style.setFont(font);
				style.setVerticalAlignment(CellStyle.ALIGN_CENTER);
				rowHeading.getCell(i).setCellStyle(style);
		
	
				sheet1.autoSizeColumn(i);
				sheet1.getColumnOutlineLevel(i);
				 

			}
	        
	        FileOutputStream fileOut = new FileOutputStream("C:\\Users\\erez\\Desktop\\בשם השם נעשה ונצליח!!\\writeTest\\JavaBooks.xlsx");
	        wb.write(fileOut);
	        wb.close();
		    fileOut.close();
			System.out.println("Success1"); 
	
			}
			
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
		
	}
	
	
	
	public void writeParsingFile(String korssInfo ,String wantedKorss,String korssCode, String studentMessage,String[] res , String unParsingMessage ,int rowPars)
	{
		
		System.out.println("writeParsingFile "); 

		try
		{
			//File scr = new File("C:\\Users\\erez\\Desktop\\בשם השם נעשה ונצליח!!\\writeTest\\JavaBooks.xlsx");
			InputStream inp = new FileInputStream("C:\\Users\\erez\\Desktop\\בשם השם נעשה ונצליח!!\\writeTest\\JavaBooks.xlsx");
			//FileInputStream fis = new FileInputStream(scr);
		
			
			Workbook wb = new XSSFWorkbook(inp);
		
		//Sheet sheet1 = wb.createSheet("הודעות דחייה");
	    
	        Sheet sheet1 = wb.getSheetAt(0);
			Row row = sheet1 .createRow(rowPars);			
			row.createCell(0).setCellValue(id.getNumericCellValue());
			row.createCell(1).setCellValue(num.getNumericCellValue());
			row.createCell(2).setCellValue(date.toString());
			row.createCell(3).setCellValue(time.toString());
			row.createCell(4).setCellValue(wantedKorss);
			row.createCell(5).setCellValue(korssCode);

	        row.createCell(6).setCellValue(korssInfo);
	       
        for (int i = 0; i < res.length; i++) {
            row.createCell(7+i).setCellValue(res[i]);
		}
        
	    
	        row.createCell(10).setCellValue(studentMessage);
	        row.createCell(11).setCellValue(unParsingMessage);
	        
	
	        
	        
	        FileOutputStream fileOut = new FileOutputStream("C:\\Users\\erez\\Desktop\\בשם השם נעשה ונצליח!!\\writeTest\\JavaBooks.xlsx");
	        wb.write(fileOut);
	      
		    fileOut.close();
		    wb.close();
			System.out.println("Success2"); 

		}
		
		catch (Exception e)
		{
			System.out.println(e.getMessage()+"error is here");
		}
		
		 //
		 
	//	 nextRowToWrite++;
		
	}
	

	
	
	

}
