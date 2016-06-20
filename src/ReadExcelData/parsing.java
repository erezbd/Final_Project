
/* Erez Ben David 
 * This class gets a string that contain the system message, with info of the wanted korss, way it's been rejected, and more.
 * this class will get the wanted info from the string, be running on the string and search a saved words, 
 * and cut the info, and delete it,from the string, each info that i get will be delete from the copied string.
 * be notice the string that i get is copy the info twice.  
 */

package ReadExcelData;





public class parsing
{

	final String reject = "הודעת הדחיה :";
	final String corss = "הקורס:";
	final String korssName = "שם נושא:";
	final String res1 = "סיבות דחיה:";
	final String res2 = "סיבת דחיה:";
	final String del1 = "סיבות דחיה:אי עמידה בתנאי קדם - עליך לעבור את הקורס שמשמאל או קורס חליפי לו לפני שתוכל להירשם לקורס המבוקש";
	final String del2 = "סיבת דחיה:אי עמידה בתנאי קדם - עליך לעבור את הקורס שמשמאל או קורס חליפי לו לפני שתוכל להירשם לקורס המבוקש";
	final String d = "עליך לעבור את הקורס שמשמאל או קורס חליפי לו לפני שתוכל להירשם לקורס המבוקש";
	final String d2 = "עליך להירשם לקורס שמשמאל או קורס חליפי לו לפני שתוכל להירשם לקורס המבוקש";
	String del3 = "קורס זה אינו כלול בתוכנית הלימודים שלך";
	String del4 = "הקורס לא נלמד בסמסטר זה";

	String[] arr ;					// contain the Korss Code from Korss info
	int korssCode = -1 ;			
	String korssInfo = "";   		// contain the korss info. format: /xxxx/xxxx/xxxx/xxxx...
	String wantedKorss = ""; 		// contain the name of the wanted korss the student want .
	String rejectRes = "";   		// contain the hole message way the student can't sign to the korss.
	String studentMessage = "Null";	// contain the message of the student - if there is one.
	String[] res ;     //= {"Null" , "Null" , "Null"}  ;					// array that contain all the reasons separated way the request was rejected 
	boolean f = false;				// a flag to know if in the message there is res1 or res2 
	//String par = "";
	String par = "Null";			// copy the all string that i get all the work will be on this variable
	int rowPars=1;			// count to num of rows that been parsing - start from 1 because i sand this var to write class and row 0 is label's
	String convertTemp = "";
	int temp = 0;


	
	
	public void pars (String s , writeToFile write ) // a builder constructor that copy the message and do all the work
	{
		temp++;
		this.par = s; 
		par.trim();
		par = par.replace("(", "");
		par = par.replace(")", "");
		
		if(par.startsWith(reject)) 				// Check if the message start with -  הודעת הדחיה - it means that it's in the right format 
												//there are some cases that not so i will copy them as is and not do any work on them
		{
				par = par.replace(reject , "");	// delete the opening words
				
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
				korssInfo = par.substring(par.indexOf(corss), par.indexOf(korssName)); 	// cut the korss info from the message 
				
				
				arr = korssInfo.split("/"); 					  // pars the korssinfo var by / 
				convertTemp = arr[2];      						 // get the korss code from the info
				convertTemp =convertTemp.replaceAll("\\s+",""); // delete - / - if there is
				korssCode = Integer.parseInt(convertTemp);     // convet string to int
				par = par.replaceAll(korssInfo, "");          // delete the korss info from the message it's appear 2 times  
				korssInfo =korssInfo.replaceAll(corss, "");
			////////////////////////////////////////////////////////////////////////////////////////////////////////////
					if(par.contains(res1)==true)													// check if it's - סיבות דחיה
					{
						f = true;																   	// change the flag to true
						wantedKorss =  par.substring(par.indexOf(korssName), par.indexOf(res1)); 	// cut the name of the wanted korss
						par = par.replaceAll(wantedKorss, ""); 										// delete the wanted korss		
						wantedKorss = wantedKorss.replaceAll(korssName, "");
					}
			
					else //  it's סיבת דחיה    
					{
							wantedKorss =  par.substring(par.indexOf(korssName), par.indexOf(res2)); // cut the name of the wanted korss		
							par = par.replaceAll(wantedKorss, "");									// delete the wanted korss		
							wantedKorss = wantedKorss.replaceAll(korssName, "");                   // cut the start
					}
				
				if(f==true)  						   // check if there was סיבות דחיה
				{
					f=false; 						 // return the flag to false
					
													// cut the message way the student can't sign to the korss.
						if(par.indexOf("...")==-1) // in some messages there in 3 point in the last of the messages and in some 2 - it's to know when to stop
						{
							rejectRes = par.substring(par.indexOf(res1), par.indexOf(".."));
						}
						
						else
							rejectRes = par.substring(par.indexOf(res1), par.indexOf("...")); 
					
					par = par.replaceAll(rejectRes, "");  // delete the reject message from the string
				}
				
				else  //  it's סיבת דחיה  do the same
				{					
					if(par.indexOf("...")==-1)
					{
						rejectRes = par.substring(par.indexOf(res2), par.indexOf(".."));
					}
					
					else
						rejectRes = par.substring(par.indexOf(res2), par.indexOf("..."));		
				
					par = par.replaceAll(rejectRes, "");
					
				}
				
				studentMessage = par;  			// after we delete all the info the only thing that left is the student message if he write one.
				res = rejectRes.split(",");    // take the message way the student can't sign to the korss.
											  // and each reasons(it can be few) enter to array cell 
				res[0]=res[0].replaceAll(res1, ""); // delete the start of the message if it's סיבות דחיה
				res[0]=res[0].replaceAll(res2, ""); // delete the start of the message if it's סיבת דחיה
				studentMessage = studentMessage.replace(res1, ""); // delete it from the rest of the message
				studentMessage = studentMessage.replace(res2, ""); 
				studentMessage = studentMessage.replace(",", "");

				for (int i = 0; i < res.length; i++) // try to delete info that didn't get deleted and delete start of reject mess'
				{
					studentMessage = studentMessage.replace(res[i], "");
					studentMessage = studentMessage.replace(korssInfo, "");

					if((res[i].contains(d))==true)
					{
					res[i] = res[i].replaceAll(d, ""); // delete עליך לעבור את הקורס שמשמאל או קורס חליפי לו לפני שתוכל להירשם לקורס המבוקש
					}
					
					if((res[i].contains(d2))==true)
					{
					res[i] = res[i].replaceAll(d2, ""); // delete עליך להירשם לקורס שמשמאל או קורס חליפי לו לפני שתוכל להירשם לקורס המבוקש
					}
					
				}
				// delete rest of character if there is.
				par = "";
				korssInfo = korssInfo.replace(".", "");
				wantedKorss = wantedKorss.replace(".", "");
				studentMessage = studentMessage.replace(".", "");
				
				for (int i = 0; i < res.length; i++) 
				{
					if (res[i]!=null)
						res[i] = res[i].replace(".", "");

				}
				//sand to info to write class		 	
				write.writeParsingFile(korssInfo, wantedKorss, korssCode, studentMessage, res, par, rowPars); // send all the info to write class 
				rowPars++; 
				
				
			}
	
	
		else  // if the message not start with - הודעת הדחיה - i will write the string as is to the new excel file
		{
			write.writeParsingFile("Null", "Null", korssCode, studentMessage, res, par, rowPars);
			rowPars++;
		}
			
		reset();
	}

	
	public void reset()
	{
		par = "";
		korssCode = -1;
		korssInfo = "";
		wantedKorss = "";
		rejectRes = "";
		studentMessage = "";
		for (int i = 0; i < res.length; i++) {
			if (res[i]!=null)
				res[i] = "";
		}
	}
	
	
}

