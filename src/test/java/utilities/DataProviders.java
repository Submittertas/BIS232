package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	// Can Be Reusable, Change the "name", "Method name (getData1)", and path of the file 
	
	//DataProvider 1
	
		@DataProvider(name="BIS_LoginData")
		public String [][] getData1() throws IOException  
		{
			//String path=".\\testData\\Opencart_LoginData.xlsx";//taking xl file from testData
			
			String path = System.getProperty("user.dir") + "\\testData\\BIS_LoginData.xlsx";
			
			ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
			
			int totalrows=xlutil.getRowCount("Sheet1");	
			int totalcols=xlutil.getCellCount("Sheet1",1);
					
			String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
			
			for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
			{		
				for(int j=0;j<totalcols;j++)  //0    i is rows j is col
				{
					logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
				}
			}
		return logindata;//returning two dimension array
					
		}
		
		//DataProvider 2
		
		@DataProvider(name="ErrorMessageForm")
		public String [][] getData2() throws IOException  
		{
			//String path=".\\testData\\Opencart_LoginData.xlsx";//taking xl file from testData
			
			String path = System.getProperty("user.dir") + "\\testData\\ErrorMessageForm.xlsx";
			
			ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
			
			int totalrows=xlutil.getRowCount("Sheet1");	
			int totalcols=xlutil.getCellCount("Sheet1",1);
					
			String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
			
			for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
			{		
				for(int j=0;j<totalcols;j++)  //0    i is rows j is col
				{
					logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
				}
			}
		return logindata;//returning two dimension array
					
		}
		
		//DataProvider 3
		
		//DataProvider 4


}
