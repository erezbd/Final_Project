
/* Erez Ben David 
 * This class gets a string that contain the system message, with info of the wanted korss, way it's been rejected, and more.
 * this class will get the wanted info from the string, be running on the string and search a saved words, 
 * and cut the info, and delete it,from the string, each info that i get will be delete from the copied string.
 * be notice the string that i get is copy the info twice.  
 */

package ReadExcelData;

import java.io.File;
import java.io.FileInputStream;

import javax.print.attribute.standard.MediaSize.Other;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class parsing
{

	final String reject = "הודעת הדחיה :";
	final String corss = "הקורס:";
	final String korssName = "שם נושא:";
	final String res1 = "סיבות דחיה:";
	final String res2 = "סיבת דחיה:";
	final String del1 = "סיבות דחיה:אי עמידה בתנאי קדם - עליך לעבור את הקורס שמשמאל או קורס חליפי לו לפני שתוכל להירשם לקורס המבוקש";
	final String del2 = "סיבת דחיה:אי עמידה בתנאי קדם - עליך לעבור את הקורס שמשמאל או קורס חליפי לו לפני שתוכל להירשם לקורס המבוקש";
	final String d = "אי עמידה בתנאי קדם - עליך לעבור את הקורס שמשמאל או קורס חליפי לו לפני שתוכל להירשם לקורס המבוקש";
	final String d2 = "אי עמידה בתנאי מקביל - עליך להירשם לקורס שמשמאל או קורס חליפי לו לפני שתוכל להירשם לקורס המבוקש";
	
	String[] arr ;
	String korssCode = "";
	String korssInfo = "";   	// contain the korss info. format: /xxxx/xxxx/xxxx/xxxx...
	String wantedKorss = ""; 	// contain the name of the wanted korss the student want .
	String rejectRes = "";   	// contain the hole message way the student can't sign to the korss.
	String studentMessage = "";	// contain the message of the student - if there is one.
	String[] res ;				// array that contain all the reasons separated way the request was rejected 
	boolean f = false;			// a flag to know if in the message there is res1 or res2 
	//String par = "";
	String par = "";			// copy the all string that i get all the work will be on this variable
	int rowPars=1;
	
	

	//writeToFile write = new writeToFile();

	
	
	public void pars (String s , writeToFile write ) // a builder constructor that copy the message and do all the work
	{
		System.out.println(s);
		this.par = s; //
	

		
		par = par.replace(".", "");  				// delete all the dotes in the message 
		par = par.replace("(", "");
		par = par.replace(")", "");
		
		if(par.startsWith(reject)) 				// Check if the message start with -  הודעת הדחיה - it means that it's in the right format 
												//there are some cases that not so i will copy them as is and not do any work on them
		{
				
				par = par.replace(reject , "");	// delete the opening words
				System.out.println(par);
				
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
				korssInfo = par.substring(par.indexOf(corss), par.indexOf(korssName)); 	// cut the korss info from the message 
				
				
				arr = korssInfo.split("/");
				korssCode = arr[2];
				System.out.println(korssCode);
				par = par.replaceAll(korssInfo, "");                                   	// delete the korss info from the message it's appear 2 times  
				korssInfo =korssInfo.replaceAll(corss, "");
				System.out.println(korssInfo);
				System.out.println(par);
			////////////////////////////////////////////////////////////////////////////////////////////////////////////
					if(par.contains(res1)==true)										// check if is - סיבות דחיה
					{
						f = true;														// change the flag to true
						wantedKorss =  par.substring(par.indexOf(korssName), par.indexOf(res1)); // cut the name of the wanted korss
					
						
						par = par.replaceAll(wantedKorss, ""); 							// delete the wanted korss		
						wantedKorss = wantedKorss.replaceAll(korssName, "");
						System.out.println(wantedKorss);
						System.out.println(par);
				
					}
				
					
				
					else //  it's סיבת דחיה    
					{
					
							wantedKorss =  par.substring(par.indexOf(korssName), par.indexOf(res2)); // cut the name of the wanted korss
					
						
							par = par.replaceAll(wantedKorss, "");						// delete the wanted korss		
							wantedKorss = wantedKorss.replaceAll(korssName, "");
							System.out.println(wantedKorss);
					}
				
				if(f==true)  // check if there was סיבות דחיה
				{
				//	System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

					f=false; // return the flag to false
					rejectRes = par.substring(par.indexOf(res1), par.indexOf(res1 , 10)); // cut the message way the student can't sign to the korss.
					
					System.out.println("this is the rej : " +rejectRes);
					par = par.replaceAll(rejectRes, "");  // delete the reject mess from the string
					par = par.replaceAll(rejectRes, "");  // delete the reject mess from the string

				//	System.out.println(rejectRes);
					System.out.println("this is the left message : " +par);
				}
				else  //  it's סיבת דחיה  do the same
				{
					rejectRes = par.substring(par.indexOf(res2), par.indexOf(res2 , 10));
					par = par.replaceAll(rejectRes, "");
					System.out.println(rejectRes);
					System.out.println(par);
					
				}
				
				studentMessage = par;  // after we delete all the info the only thing that left is the student message if he write one.
				res = rejectRes.split(","); // take the message way the student can't sign to the korss.
											// and each reasons(it can be few) enter to array cell 
				res[0]=res[0].replaceAll(res1, "");
				res[0]=res[0].replaceAll(res2, "");
				studentMessage = studentMessage.replace(res1, "");
				studentMessage = studentMessage.replace(res2, "");
				studentMessage = studentMessage.replace(",", "");

				for (int i = 0; i < res.length; i++) 
				{
					studentMessage = studentMessage.replace(res[i], "");

					if((res[i].contains(d))==true)
					{
						//System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");

					res[i] = res[i].replaceAll(d, "");
					res[i] = res[i].substring(res[i].lastIndexOf(' ') + 1);	
					System.out.println(res[i]);
					}
					if((res[i].contains(d2))==true)
					{
						//System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

					res[i] = res[i].replaceAll(d2, "");
					res[i] = res[i].substring(res[i].lastIndexOf(' ') + 1);	
					System.out.println(res[i]);
					}
					
					
				}
				
				par = "";
				
				write.writeParsingFile(korssInfo, wantedKorss, korssCode, studentMessage, res, par, rowPars); // send all the info to write class 
				rowPars++;
				
				
			}
	
	
		else  // if the message not start with - הודעת הדחיה - i will write the string as is to the new excel file
		{
			
			write.writeParsingFile(korssInfo, wantedKorss, korssCode, studentMessage, res, par, rowPars);
			rowPars++;
			//reset();
		}
			
	//	reset();
	}

	
	public void reset()
	{
		par = "";
		korssCode = "";
		korssInfo = "";
		wantedKorss = "";
		rejectRes = "";
		studentMessage = "";
		for (int i = 0; i < arr.length; i++) {
			if (res[i]==null)
				res[i] = "";
		}
	}
	
	
}

