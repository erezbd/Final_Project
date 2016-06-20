package ReadExcelData;

import java.awt.Component;
import java.io.FileOutputStream;






import javax.swing.JOptionPane;

import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class writeToFile 
{
	String date , time ,nemeOfStudent,departmant;
	int  num, id ,numOfyears;
	Workbook work = new XSSFWorkbook();
	Sheet sheet1 = work.createSheet();
	Row row;
	Component frame = null;

	// copy the data
	public void writeCell(String date , String time , int num , int id ,String nemeOfStudent ,String departmant,int numOfyears)
	{
		this.date = date;
		this.time = time;
		this.num=num;
		this.id=id;
		this.nemeOfStudent=nemeOfStudent;
		this.departmant = departmant;
		this.numOfyears = numOfyears;
		
	}
	
	
	
	public void creatParsFile() // create the layout of the new file 
	{
		System.out.println("creatParsFile class");

		
			try
			{

	        row = sheet1.createRow(0);
	
	    	row.createCell(0).setCellValue("   תעודת  זהות");
			row.createCell(1).setCellValue("   שם הסטודנט");
			row.createCell(2).setCellValue("      מחלקה");
			row.createCell(3).setCellValue("    שנת לימוד");
			row.createCell(4).setCellValue("   תאריך פנייה");    
	        row.createCell(5).setCellValue("    שעת פנייה");
	        row.createCell(6).setCellValue("    מספר פנייה");
	        row.createCell(7).setCellValue("    שם הקורס המבוקש");
	        row.createCell(8).setCellValue("     קוד הקורס המבוקש");
	        row.createCell(9).setCellValue("    פרטי הקורס המבוקש");
	        row.createCell(10).setCellValue("      סיבת דחייה 1");
	        row.createCell(11).setCellValue("     סיבת דחייה 2");
	        row.createCell(12).setCellValue("     סיבת דחייה 3");
	        row.createCell(13).setCellValue("     מלל סטודנט מקורי");
	        row.createCell(14).setCellValue("     פנייה לא דרך מערכת רישום");
	        row.createCell(15).setCellValue("     אחראי תחום");
	        row.createCell(16).setCellValue("     שינוי קוד קורס");
	        sheet1.setAutoFilter(new CellRangeAddress(0, sheet1.getLastRowNum() + 1, 0, 16));
		        for (int i = 0; i < 16; i++)  // style the headline
		        {
					CellStyle style = work.createCellStyle();
	
					Font font = work.createFont();
					font.setBold(true);
					font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
					font.setFontHeightInPoints((short) 11);
					style.setFont(font);
					style.setVerticalAlignment(CellStyle.ALIGN_CENTER);
					row.getCell(i).setCellStyle(style);
			
		
					sheet1.autoSizeColumn(i);
					sheet1.getColumnOutlineLevel(i);
				}
		        

			}
			
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(frame,
					    e.toString(),
					    "creatParsFile error",
					    JOptionPane.ERROR_MESSAGE);				
			}
		
	}
	
	
	// each row from the old file sand to this method that create new row with all the info
	public void writeParsingFile(String korssInfo ,String wantedKorss,int korssCode, 
									String studentMessage,String[] res , String unParsingMessage ,int rowPars)
	{
		

		try
		{

			row = sheet1 .createRow(rowPars);			
			row.createCell(0).setCellValue(id);
			sheet1.autoSizeColumn(0); // this make the cell in the size of length of the data
			row.createCell(1).setCellValue(nemeOfStudent);
			sheet1.autoSizeColumn(1);
			row.createCell(2).setCellValue(departmant);
			sheet1.autoSizeColumn(2);
			row.createCell(3).setCellValue(numOfyears);
			sheet1.autoSizeColumn(3);
			row.createCell(4).setCellValue(date.toString());
			sheet1.autoSizeColumn(4);
			

			row.createCell(5).setCellValue(time.toString());
			sheet1.autoSizeColumn(5);

			row.createCell(6).setCellValue(num);
			sheet1.autoSizeColumn(6);
			

			row.createCell(7).setCellValue(wantedKorss);
			sheet1.autoSizeColumn(7);

			row.createCell(8).setCellValue(korssCode);;
			sheet1.autoSizeColumn(8);


	        row.createCell(9).setCellValue(korssInfo);
			sheet1.autoSizeColumn(9);

	       int i;
        for ( i = 0; i < res.length; i++) // Setting null to res to reject if there is no res 
        {
        	
        	if(res.length == 0){
        		row.createCell(10).setCellValue("Null");
        		row.createCell(11).setCellValue("Null");
        		row.createCell(12).setCellValue("Null");
        	}
        	if(res.length == 1){
        		row.createCell(11).setCellValue("Null");
        		row.createCell(12).setCellValue("Null");
        	}
        	if(res.length == 2)
        		row.createCell(12).setCellValue("Null");
        	
        
    		row.createCell(10+i).setCellValue(res[i]);

			//sheet1.autoSizeColumn(10+i);
		}
        
	    
	        row.createCell(13).setCellValue(studentMessage);
		//	sheet1.autoSizeColumn(10);

	        row.createCell(14).setCellValue(unParsingMessage);
		//	sheet1.autoSizeColumn(11);
	        
	        row.createCell(15).setCellValue("Null");
	        row.createCell(16).setCellValue("Null");


		}
		
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(frame,
				    e.toString(),
				    "writeParsingFile error",
				    JOptionPane.ERROR_MESSAGE);		
		}
		

	}
	
	// create the new file with the layout the all the info from the old file after parsing
	// in this point headOfDep and changeKorssCode columns will be Null
	public void writeObj(String path)  // all the writing in this class been on 'work' object. 
										
	{
		try 
		{	
	        FileOutputStream fileOut = new FileOutputStream(path);
	        this.work.write(fileOut);	        
		    fileOut.close();
		    work.close();
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(frame,
				    e.toString(),
				    "writeObj error",
				    JOptionPane.ERROR_MESSAGE);				}
	}

}
