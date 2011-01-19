package com.cy.erp.web.action.attachment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import com.cy.erp.web.dataGate.Globe;

public class AttachmentService {
	
	public String saveAtt(File f,String fileName){
		try {
			FileInputStream file = new FileInputStream(f);
			String id=Globe.dao.saveAtt(file, fileName,Globe.df.format(new Date()),"");
			return id;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public InputStream downAtt(String id){
		try {
			InputStream iStream=Globe.dao.downAtt(id);
			return iStream;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
