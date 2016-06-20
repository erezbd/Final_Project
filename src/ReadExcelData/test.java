package ReadExcelData;


public class test 
{

	public static void main(String[] args) 
	{
		
		try
		{		
			
			MainFrame frame = new MainFrame();
			frame.run();
		}

		catch (Exception e)
		{
			
			System.out.println(e.toString() + "  " + e.getMessage());
		}	
	}

}





