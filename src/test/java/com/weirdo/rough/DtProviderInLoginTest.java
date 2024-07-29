package com.weirdo.rough;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.weirdo.pages.HomePage;
import com.weirdo.pages.LoginPage;
import com.weirdo.testcases.BaseTest;
import com.weirdo.utilities.ExcelReader;

public class DtProviderInLoginTest extends BaseTest {
/*After creating the test part and data provider structure. very first we need to create a object to read the Excel reader class file in line no 13 and then go to line no 36  */
	public static ExcelReader excel=null;
	/*test part-Starts here*/
	@Test (dataProvider = "getData")
	public void doLogin(Hashtable<String, String>data) {
		try {
			System.out.println("UserName from excel via data provider-->"+data.get("userName")+"Password as "+data.get("password"));
			HomePage hp=new HomePage();
			hp.goToSignIn();
			Thread.sleep(4000);
			LoginPage lp=new LoginPage();
			lp.doLogin(data.get("userName"),data.get("password") );
			//System.out.println("UserName from excel via data provider-->"+userName+"PAssword as "+password);
		} /*
			 * catch (InterruptedException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */ catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*test part-Ends here*/
	/*DataProvider structure*/
	@DataProvider
	public Object[][] getData() {
		
		/*Verify the object is null--> if null get the path of the testdata file then we need the read the sheet name for that
		 *  got to line no 42 */
		if(excel== null) {
			excel= new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\weirdo\\testdata\\testdata.xlsx");
			
		}
		/*Create the String variable for sheetName*/
		String sheetName="doLogin";
		/*get the rowCount and store it in the integer variable */
	int rowCount=	excel.getRowCount(sheetName);
	/*then get the columnCount and store it in the integer variable.
	 * Now we have row and column count from the sheet and we need to pass it in line no 50 but in excel 1 row is header,
	 * we dont wants that therefore we say it as rowCount-1,
	 * then we need to get all data from the sheet, so we are creating for loop, got to line no 53 */
		int columnCount=excel.getColumnCount(sheetName);
		
		Object[][] data= new Object[rowCount-1][1];
		/*to store each rows */
		Hashtable<String, String> hTable=null;
	/*creating ForLoop for row*/
		for(int rowNum=2;rowNum<=rowCount;rowNum++) {
			/*for column*/
			hTable=new Hashtable<String, String>();
			for(int colNum=0;colNum<columnCount;colNum++) {
				/*Store the value in data */
			//	data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
				hTable.put(excel.getCellData(sheetName, colNum, 1),excel.getCellData(sheetName, colNum, rowNum));
				/*convert this to 2D array */
				data[rowNum-2][0]=hTable;
			}
		}
		
		
		return data;
		
		
	}
	
}
