package com.lec.file;

import org.davidmoten.text.utils.WordWrap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringJoiner;

@Controller
public class HomeController {

	//Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "C://temp//";

    String filename ;
    
    
    @GetMapping("/")
    public String index() {
        return "upload";
    }

    //@RequestMapping(value = "/upload", method = RequestMethod.POST)
    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message", 
                        "You successfully uploaded '" + file.getOriginalFilename() + "'");
            
            filename = file.getOriginalFilename();
            
//            redirectAttributes.addFlashAttribute("message2", "These are your errors: " + BeanReader.validate((File) file) + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

    
    @PostMapping("/validate") // //new annotation since 4.3
    public String singleFileUpload(Model model) {

    	int error;
    	int i; 
    	int j;
    	String[][] holder;
    	String output ="";
    	String noError = "NO Error!";
    	String amountError = "Amount Error!";
    	String hashError = "Hash Error!";
    	String doubleError = "Amount and Hash Error!";
    	String broken = "Broken";
    	String file = UPLOADED_FOLDER+filename;
    	BeanReader beanreader = new BeanReader();
    	error = beanreader.validate(file);
    	holder = beanreader.storeFile(file);
    	output = beanreader.fileToString(file);
    	
    	model.addAttribute("outcome", output);
    	
    	if (error == 1) {
    		model.addAttribute("error", noError);
    	}
    	else if (error == 2) {
  		  for (i = 0; i < holder.length; i++) {
	        	if (holder[i][0].equals("5")) {	
	        		if (holder[i][1].equals("200")) {
	        			// Debt and Credit
	        	        for (j = 0; j < holder.length; j++) {
	        	        	if (holder[j][0].equals("8")) {	
	        	        		amountError += " Located at Line: " + j + " Fields: 5 and 6 - " + holder[j][4] + " and " + holder[j][5];
	        	        		}
	        	        	}
	        		}
	        		else if (holder[i][1].equals("220")) {
	        			// Credit
	        	        for (j = 0; j < holder.length; j++) {
	        	        	if (holder[j][0].equals("8")) {	
	        	        		amountError += " Located at Line: " + j + " Field: 6 - " + holder[j][5];
	        	        	}
	        	        }
	        		}
	        		else if (holder[i][1].equals("225")) {
	        			// Debt
	        	        for (j = 0; j < holder.length; j++) {
	        	        	if (holder[j][0].equals("8")) {	
	        	        		amountError += " Located at Line: " + j + " Fields: 5 - " + holder[j][4];
	        	        	}
	        	        }
	        		}
	        	}
		  }
    		model.addAttribute("error", amountError);
    	}
    	else if (error == 3) {
    		for (i = 0; i < holder.length; i++) {
    			if (holder[i][0].equals("8")) {
    				hashError += " Located at Line: " + i + " and " + (i+1) + " Field: 4 - " + holder[i][3] + " and " + holder[i+1][4];
    			}
    		}
    		model.addAttribute("error", hashError);
    	}
    	else if (error == 4) {
    		  for (i = 0; i < holder.length; i++) {
  	        	if (holder[i][0].equals("5")) {	
  	        		if (holder[i][1].equals("200")) {
  	        			// Debt and Credit
  	        	        for (j = 0; j < holder.length; j++) {
  	        	        	if (holder[j][0].equals("8")) {	
  	        	        		doubleError += " Located at Line: " + j + " Fields: 5 and 6 - " + holder[j][4] + " and " + holder[j][5];
  	        	        		}
  	        	        	}
  	        		}
  	        		else if (holder[i][1].equals("220")) {
  	        			// Credit
  	        	        for (j = 0; j < holder.length; j++) {
  	        	        	if (holder[j][0].equals("8")) {	
  	        	        		doubleError += " Located at Line: " + j + " Field: 6 - " + holder[j][5];
  	        	        	}
  	        	        }
  	        		}
  	        		else if (holder[i][1].equals("225")) {
  	        			// Debt
  	        	        for (j = 0; j < holder.length; j++) {
  	        	        	if (holder[j][0].equals("8")) {	
  	        	        		doubleError += " Located at Line: " + j + " Fields: 5 - " + holder[j][4];
  	        	        	}
  	        	        }
  	        		}
  	        	}
    			if (holder[i][0].equals("8")) {
    				doubleError += " Located at Line: " + i + " and " + (i+1) + " Field: 4 - " + holder[i][3] + " and " + holder[i+1][4];
    			}
  		  }
    		model.addAttribute("error", doubleError);
    	}
    	else if (error == 5)
    		model.addAttribute("error", broken);

//    	model.addAttribute("outcome", outcome);
    	
    	return  "validationResult";
    }	
}