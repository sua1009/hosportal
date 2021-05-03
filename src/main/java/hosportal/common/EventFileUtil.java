package hosportal.common;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import hosportal.dto.FileDto;

@Component
public class EventFileUtil {
	public List<FileDto> parseFileInfo(int eventNo, MultipartHttpServletRequest uploadFiles) throws Exception{
		if (ObjectUtils.isEmpty(uploadFiles)) {
			return null;
		}
		
		List<FileDto> fileList = new ArrayList<>();
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
		ZonedDateTime current = ZonedDateTime.now();
		
		String path = "imgs/" + current.format(format);
	
		File file = new File(path);
		if (file.exists() == false) {
			file.mkdirs();
		}
		
		Iterator<String> iterator = uploadFiles.getFileNames();
		
		String newFileName, oriFileExtension, contentType;
		
		while (iterator.hasNext()) {
			List<MultipartFile> list = uploadFiles.getFiles(iterator.next());
			
			for (MultipartFile multiFile : list) {
				if (multiFile.isEmpty() == false) {
					contentType = multiFile.getContentType();
					
					if(ObjectUtils.isEmpty(contentType)) {
						break;
					}
					else {
						if(contentType.contains("image/jpeg")) {
							oriFileExtension = ".jpg";
						}
						else if (contentType.contains("image/png")) {
							oriFileExtension = ".png";
						}
						else if (contentType.contains("image/gif")) {
							oriFileExtension = ".gif";
						}
						else {
							break;
						}
					}
					
					newFileName = Long.toString(System.nanoTime()) + oriFileExtension;
					
					FileDto hosFile = new FileDto();
					hosFile.setEventNo(eventNo);
//					hosFile.setFileName(multiFile.getOriginalFilename());					
					hosFile.setFileName("/" + path + "/" + newFileName);	
					
					fileList.add(hosFile);
					
					file = new File(path + "/" + newFileName);
					multiFile.transferTo(file);
				}
			}
		}
		
		return fileList;
	}
}
