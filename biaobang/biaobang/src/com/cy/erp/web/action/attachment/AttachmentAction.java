	package com.cy.erp.web.action.attachment;
	
	import java.io.ByteArrayInputStream;
	import java.io.File;
	import java.io.InputStream;
	
	import com.cy.erp.web.common.BaseAction;
	
	public class AttachmentAction extends BaseAction {
		private static final long serialVersionUID = -2407572876245484007L;
	
		private AttachmentService attachmentService;
		
		private File uploadAtt;
	
		private String uploadAttContentType;
	
		private String uploadAttFileName;
		
		private InputStream inputStream;
		
		private String id;
		
		private String downFileName;

		/**
		 * 上传附件
		 * @return
		 */
		public String uploadAtt() {
			try {
				String msg = attachmentService.saveAtt(uploadAtt,uploadAttFileName);
				inputStream = new ByteArrayInputStream(msg.getBytes("GBK"));
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return SUCCESS;
		}
		
		/**
		 * 下载附件
		 * @return
		 */
		public String downAtt() {
			try {
				inputStream = attachmentService.downAtt(id);
				//必须要转换成ISO8859-1，否则会出现乱码
				downFileName = new String(downFileName.getBytes(),"ISO8859-1");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return SUCCESS;
		}
	
		public File getUploadAtt() {
			return uploadAtt;
		}

		public void setUploadAtt(File uploadAtt) {
			this.uploadAtt = uploadAtt;
		}

		public String getUploadAttContentType() {
			return uploadAttContentType;
		}

		public void setUploadAttContentType(String uploadAttContentType) {
			this.uploadAttContentType = uploadAttContentType;
		}

		public String getUploadAttFileName() {
			return uploadAttFileName;
		}

		public void setUploadAttFileName(String uploadAttFileName) {
			this.uploadAttFileName = uploadAttFileName;
		}

		public AttachmentService getCommonTableService() {
			return attachmentService;
		}
	
		public void setCommonTableService(AttachmentService commonTableService) {
			this.attachmentService = commonTableService;
		}
		
		public InputStream getInputStream() {
			return inputStream;
		}
	
		public void setInputStream(InputStream inputStream) {
			this.inputStream = inputStream;
		}
	
		public AttachmentService getAttachmentService() {
			return attachmentService;
		}

		public void setAttachmentService(AttachmentService attachmentService) {
			this.attachmentService = attachmentService;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getDownFileName() {
			return downFileName;
		}

		public void setDownFileName(String downFileName) {
			this.downFileName = downFileName;
		}

	}
