package day09;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day09/test4")
public class test4 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uploadPath = req.getServletContext().getRealPath("/testUpload4");
		System.out.println( uploadPath );
		
		File file = new File(uploadPath);
		if( !file.exists() ) { file.mkdir(); System.out.println("파일 생성 완료"); }
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(file);
			factory.setSizeThreshold( 1024 * 1024 );
			factory.setDefaultCharset("UTF-8");
		
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		try {
			List<FileItem> fileItems = fileUpload.parseRequest(req);
			if( fileItems != null && !fileItems.isEmpty() ) {
				for( int i = 0 ; i < fileItems.size() ; i++ ) {
					FileItem fileItem = fileItems.get(i);
					if( fileItem.isFormField() ) {
						System.out.println("첨부파일이 아닌 일반 텍스트 : " + fileItem.toString() );
					}else {
						System.out.println("첨부파일 : " + fileItem.getName() );
							String uuid = UUID.randomUUID().toString();
							System.out.println(uuid);
							String fileName = uuid + "-"+fileItem.getName().replaceAll("-", "_");
							
							File uploadFile = new File( uploadPath + "/" + fileName );
						fileItem.write(uploadFile);
					} // if end
				} // for end
			} // if end
		}catch( Exception e ) { System.out.println(e); }
			
		
	} // f end
	
}
