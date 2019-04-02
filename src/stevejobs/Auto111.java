package stevejobs;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Alignment;
import jxl.write.Colour;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;

public class Auto111 
{
	public static void main(String[] args) throws Exception
	{
		//connect to .xls file
		File f=new File("Book1.xls");
		//open .xls for reading
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0);//0 means sheet 1
		int nour=rsh.getRows();
		// open same .xls for writing
		WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
		WritableSheet wsh=wwb.getSheet(0);
		//data driven fom second row
		//1st row(index is 0) have name for columns
		for(int i=1;i<nour;i++)
		{
			int x=Integer.parseInt(rsh.getCell(0, i).getContents());
			int y=Integer.parseInt(rsh.getCell(1, i).getContents());
			int z=x+y;
			Number n=new Number(2,i,z);
			wsh.addCell(n);
			//decorations for result text and corresponding cell
			/*WritableFont wf=new WritableFont(WritableFont.TIMES,11,WritableFont.BOLD);
			wf.setColour(Colour.GREEN);
			WritableCellFormat wcf=new WritableCellFormat(wf);
			wcf.setBackground(Colour.YELLOW);
			wcf.setAlignment(Alignment.CENTRE);*/
		}
		//save and close excel
		wwb.write();
		wwb.close();
		rwb.close();
		

	}

}
 