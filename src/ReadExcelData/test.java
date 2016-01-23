package ReadExcelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.TempFile;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class test {

	public static void main(String[] args) 
	{
		

//		final String reject = "הודעת הדחיה :";
//		final String corss = "הקורס:";
//		final String korssName = "שם נושא:";
//		final String res1 = "סיבות דחיה:";
//		final String res2 = "סיבת דחיה:";	
//		
//		String korssInfo = "";
//		String wantedKorss = "";
//		String rejactRes = "";
//		String studentMessage = "";
//		String[] res ;
//		boolean f = false;
//		String temp = "";
		
		try
		{
			readFromFile r = new readFromFile();
			r.parsingFileRead();
		//	FileInputStream scr = new FileInputStream(new File("C:\\Users\\erez\\Desktop\\erez.xlsx"));
		//	System.out.println("1");
		//	writeTest w = new writeTest();
		//	w.write();
//			File scr = new File("C:\\Users\\erez\\Desktop\\ab.xlsx");
//			
//			FileInputStream fis = new FileInputStream(scr);
//		
//			XSSFWorkbook wb = new XSSFWorkbook(scr);
//			
//			
//			XSSFSheet sheet1 = wb.getSheetAt(0);
//			writeToFile write = new writeToFile();
//			write.creatParsFile();
//		//	System.out.println("xxxxxxx");
//			//String data001 = sheet1.getRow(3).getCell(11).getStringCellValue();
//			Row row = sheet1.getRow(4);
//			CellStyle style = wb.createCellStyle();
//			System.out.println(style.getBorderBottom());
//			System.out.println(style.getBorderLeft());
//			System.out.println(style.getBorderRight());
//			System.out.println(style.getBorderTop());
//
//			Cell date = row.getCell(2); // date
//			System.out.println(date.getCellType());
//
//			Cell time = row.getCell(3); // time
//			System.out.println(time.getCellType());
//
//			Cell numOfApp = row.getCell(4); // num
//			System.out.println(numOfApp.getCellType());
//
//			Cell message = row.getCell(11); // pars
//			System.out.println(message.getCellType());
//
//			Cell ID = row.getCell(14); // ID
//			System.out.println(ID.getCellType());
//			parsing p = new parsing();
//			for (int i = 2; i < 9; i++) {
//				String data01 = sheet1.getRow(i).getCell(11).getStringCellValue();
//				p.pars(data01);
			}
			
//			String data01 = sheet1.getRow(3).getCell(11).getStringCellValue();
//			parsing p = new parsing(data01);
			//writeToFile w = new writeToFile();
			//w.
			//parsing p =  new parsing(data01);
			
			
//	
//			temp = data01;
//			
//			System.out.println(temp);
//			fis.close();
//			wb.close();
			//System.out.println("data from Excel is:"+data01);
//		}
		
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
//
//	
////		
////		temp = temp.replace(".", "");
////		if(temp.startsWith(reject))
////		{
////			
////			
////		temp = temp.replace(reject , "");
////		System.out.println(temp);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////	//	int startCut = 21;
////		korssInfo = temp.substring(temp.indexOf(corss), temp.indexOf(korssName));
////		//int howMuchToCut = korssInfo.length()+startCut;
////		
////		//temp = temp.substring(howMuchToCut, temp.length());
////		temp = temp.replaceAll(korssInfo, "");
////	//	korssInfo = korssInfo.replace(corss, "");
////		//temp = temp.replace(korssInfo, "");
////		System.out.println(korssInfo);
////		System.out.println(temp);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		if(temp.contains(res1)==true){
//			f = true;
//			wantedKorss =  temp.substring(temp.indexOf(korssName), temp.indexOf(res1));
//		//	howMuchToCut = nameOfKorss.length()+9;
//		//	nameOfKorss = nameOfKorss.replace(".", "");
//			
//			temp = temp.replaceAll(wantedKorss, "");
//		//	wantedKorss = wantedKorss.replace(korssName, "");
//			System.out.println(wantedKorss);
//			System.out.println(temp);
//
//			
//		//	temp = temp.substring(howMuchToCut, temp.length());
//			
//		}
//		else{
//			
//			wantedKorss =  temp.substring(temp.indexOf(korssName), temp.indexOf(res2));
//		//	howMuchToCut = nameOfKorss.length()+9;
//			//nameOfKorss = nameOfKorss.replace(".", "");
//		
//			temp = temp.replaceAll(wantedKorss, "");
//		//	wantedKorss = wantedKorss.replace(korssName, "");
//			System.out.println(wantedKorss);
//	//		temp = temp.substring(howMuchToCut, temp.length());
//		}
//		
//		if(f==true){
//		
//			f=false;
//			rejactRes = temp.substring(temp.indexOf(res1), temp.indexOf(res1 , 10));
//			
//			rejactRes = rejactRes.replace("(", "");
//			rejactRes = rejactRes.replace(")", "");
//			temp = temp.replace("(", "");
//			temp = temp.replace(")", "");
//			System.out.println(rejactRes);
//			temp = temp.replaceAll(rejactRes, "");
//			//rejactRes = rejactRes.replace(res1, "");
//			System.out.println(temp);
//		}
//		else{
//			rejactRes = temp.substring(temp.indexOf(res2), temp.indexOf(res2 , 10));
//			
//			rejactRes = rejactRes.replace("(", "");
//			rejactRes = rejactRes.replace(")", "");
//			temp = temp.replace("(", "");
//			temp = temp.replace(")", "");
//			temp = temp.replaceAll(rejactRes, "");
//			//rejactRes = rejactRes.replace(res2, "");
//			System.out.println(rejactRes);
//			System.out.println(temp);
//			
//		}
//		studentMessage = temp;
//		}
//		
//		
//		else{
//			System.out.println(temp);
//			//לכתוב את ההודעה כמו שהיא
//		}
//		
//		res = rejactRes.split(",");
//		for (int i = 0; i < res.length; i++) {
//			System.out.println("resons to reject:" + i +" ," + res[i]);
//		}
//	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		//System.out.println(temp);
//		
//		String resToReject = temp.substring(temp.indexOf("סיבות דחיה"), temp.indexOf("הקורס:"));
//		System.out.println(resToReject);
//		System.out.println(temp);
//	
//		
////		howMuchToCut = resToReject.length()+11;
////	//	resToReject = resToReject.replace(".", "");
////		temp = temp.substring(howMuchToCut, temp.length());
////		System.out.println(temp);
//
//		
//		
//		
//		
//		
//		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		
//	//	 = temp.substring(temp.indexOf("סיבות דחיה"),temp.length());
//		temp = temp.replace(resToReject, "");
//		temp = temp.replace(korssInfo, "");
//		temp = temp.replace(bla, "");
//		temp = temp.replace("הקורס:", "");
//		temp = temp.replace("שם נושא:", "");
//		System.out.println(temp);
//		//String studentMesg = temp;
//		
//		
////		final String tnayKedem = "עליך לעבור את הקורס שמשמאל (או קורס חליפי לו) לפני שתוכל להירשם לקורס המבוקש.";
////		String temp2 = temp.substring(temp.indexOf("סיבות דחיה"), temp.length());
//////		System.out.println(temp2);
////			int start3 = temp2.indexOf("סיבות דחיה");
////			int end3 = temp2.indexOf("הקורס:");
////			System.out.println(temp2.substring(start3, end3));
////			String missingKorss = temp2.substring(temp.indexOf(tnayKedem), temp2.indexOf("הקורס:"));
////			System.out.println(missingKorss);
//		
//		//String openS = "הודעת הדחיה";
////		if(temp.toLowerCase().contains("הודעת הדחיה"))
////		{
////			if(temp.toLowerCase().contains("אי עמידה בתנאי קדם"))
////			{
////				System.out.println("do things");
////			}
////			else if(){
////				
////			}
////		}
////		else{
////			//copy the row as is, no need to parsing
////		}
		
		
		
		
		
		
		
	}

}
