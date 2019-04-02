package stevejobs;

import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Auto113 
{
	public static void main(String[] args) throws Exception
	{
		//connect to a file
		File f=new File("mypdf.pdf");
		//take write permission on file
		FileOutputStream fo=new FileOutputStream(f);
		//take that file as a pdf file
		Document doc=new Document();
		PdfWriter pw=PdfWriter.getInstance(doc, fo);
		//write data as paragraphs
		doc.open();
		Font font=new Font();
		font.setSize(Font.BOLD);
		font.setSize(11);
		//add para1
		String rec1="pandureddy211,valid";
		Paragraph p1=new Paragraph(rec1,font);
		doc.add(p1);
		//add para2
		String rec2=",invalid";
		Paragraph p2=new Paragraph(rec2,font);
		doc.add(p2);
		//add para3
		String rec3="pandureddy2110,invalid";
		Paragraph p3=new Paragraph(rec3,font);
		doc.add(p3);
		doc.close(); //save pdf
		
		

	}

}
