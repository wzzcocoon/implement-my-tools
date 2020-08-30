package cn.wzz.controller.bigdata.down;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class DownController {

	 
    @RequestMapping("/down")
    public String index(){
        return "down";
    }
    
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<Object> downloadFile() throws FileNotFoundException {
        String fileName = "C:\\Users\\wzz\\git\\implement-my-tools\\src\\main\\resources\\templates\\a.txt";
    	
        File file = new File(fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream((file)));

         HttpHeaders headers = new HttpHeaders();
         headers.add("Content-Disposition",String.format("attachment;filename=\"%s\"",file.getName()));
         headers.add("Cache-Control","no-cache,no-store,must-revalidate");
         headers.add("Pragma","no-cache");
         headers.add("Expires","0");

         ResponseEntity<Object> responseEntity = ResponseEntity.ok()
                                                .headers(headers)
                                                .contentLength(file.length())
                                                .contentType(MediaType.parseMediaType("application/text"))
                                                .body(resource);
          return responseEntity;
        }
    


}
