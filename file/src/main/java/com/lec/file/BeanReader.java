package com.lec.file;

import org.beanio.*;

import java.io.*;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter; 

public class BeanReader {    
    public int validate (String file) {  	
    	int i;
    	int j;
    	String[][] tester = storeFile(file);
                  
    	
    	// Format Validation
    	for (i = 0; i < tester.length; i++) {
    		for (j = 0; j < tester[i].length; j++) {
    			
    		}
    	}
    	
        // Amount Validation
        int totalCredit = 0;
        int totalDebit = 0;
        int amountCredit = 0;
        int amountDebit = 0;
        boolean equalAmount = true;
        for (i = 0; i < tester.length; i++) {
        	if (tester[i][0].equals("5")) {	
        		if (tester[i][1].equals("200")) {
        			// Debt and Credit
        	        for (j = 0; j < tester.length; j++) {
        	        	if (tester[j][0].equals("6")) {	
        	        		totalCredit += Integer.parseInt(tester[j][5]);
        	        		totalDebit += Integer.parseInt(tester[j][4]);
        	        	}
        	        	if (tester[j][0].equals("8")) {
        	        		amountCredit = Integer.parseInt(tester[j][5]);
        	        		amountDebit = Integer.parseInt(tester[j][4]);
        	        	}
        	        }
        	        equalAmount = totalCredit == amountCredit && totalDebit == amountDebit;
//        	        System.out.println("Credit and Debit: " + totalCredit + " " + totalDebit + " " + amountCredit + " " + amountDebit);
//        	        if (!equalAmount)
//        	        	return equalAmount;
        		}
        		else if (tester[i][1].equals("220")) {
        			// Credit only
        	        for (j = 0; j < tester.length; j++) {
        	        	if (tester[j][0].equals("6")) {	
        	        		totalCredit += Integer.parseInt(tester[j][5]);
        	        	}
        	        	if (tester[j][0].equals("8")) {
        	        		amountCredit = Integer.parseInt(tester[j][5]);
        	        	}
        	        }
        	        equalAmount = totalCredit == amountCredit;
//        	        System.out.println("Credit: " + totalCredit + " " + amountCredit);
//        	        if (!equalAmount)
//        	        	return equalAmount;
        		}
        		else if (tester[i][1].equals("225")) {
        			// Debt Only
        	        for (j = 0; j < tester.length; j++) {
        	        	if (tester[j][0].equals("6")) {	
        	        		totalDebit += Integer.parseInt(tester[j][5]);
        	        	}
        	        	if (tester[j][0].equals("8")) {
        	        		amountDebit = Integer.parseInt(tester[j][4]);
        	        	}
        	        }
        	        equalAmount = totalDebit == amountDebit;
//        	        if (!equalAmount)
//        	        	return equalAmount;
        		}
        	}
        	if (tester[i][0].equals("8")) {
        		amountCredit = Integer.parseInt(tester[i][4]);
        		amountDebit = Integer.parseInt(tester[i][5]);
        	}
        }
       
        // Hash Validation
        int hashes = 0;
        int totalHashesA = 0;
        int totalHashesB = 0;
        boolean equalHash = true;
        for (i = 0; i < tester.length; i++) {
        	if (tester[i][0].equals("6")) {	
        		hashes += Integer.parseInt(tester[i][2]);
        	}
        	else if (tester[i][0].equals("8")) {	
        		totalHashesA = Integer.parseInt(tester[i][3]);
        		continue;
        	}
        	else if (tester[i][0].equals("9")) {	
        		totalHashesB = Integer.parseInt(tester[i][4]);
        		break;
        	}
        }
        equalHash = totalHashesA == totalHashesB;
        equalHash = hashes == totalHashesA;
        equalHash = hashes == totalHashesB;
//        if (!equalHash)
//        	return equalHash;
//        else
//        	return true;
        
        // Amount is correct and Hash is Correct
        if (equalAmount && equalHash)
        	return 1;
        // Amount is Wrong and Hash is Correct
        else if (!equalAmount && equalHash)
        	return 2;
        // Amount is correct and Hash is Wrong
        else if (equalAmount && !equalHash)
        	return 3;
        // Amount is Wrong and Hash is Wrong
        else if (!equalAmount && !equalHash)
        	return 4;
        else
        	return 5;
    }
    public String fileToString(String file) {
    	String display = "";
    	String line = "";
    	int error = validate(file);
    	String[][] temp = storeFile(file);
    	for (int i = 0; i < temp.length; i++) {
    		for (int j = 0; j < temp[i].length; j++) {
    			line += temp[i][j];
    		}
    	}
    	return line;
    }
    public String[][] storeFile(String file){
        // create a StreamFactory
        StreamFactory factory = StreamFactory.newInstance();
        // load the mapping file
        factory.load("C:\\Users\\Holly Rose\\OneDrive\\Desktop\\UCM\\Spring 2020\\Software Engineering - Commerce Files\\ZIPS\\FINAL\\file\\file\\file\\src\\main\\java\\com\\lec\\file\\mapping.xml");
        
        //String path = file.getAbsolutePath();
        
        org.beanio.BeanReader in =  factory.createReader("data", file);
        
        NACHA nacha;
        Object bean = null;
        bean = (Object) bean;      
        bean = in.read();   
        nacha = (NACHA) bean;
        String[][] tester = new String[30][15];
        int i = 0;
        int j = 0;
        for (i = 0; i < tester.length; i++)
        	for (j = 0; j < tester[i].length; j++)
        		tester[i][j] = "";
        i = 0;
        j = 0;
        String temp;
       
        while ((nacha = (NACHA) bean) != null) {
        	j = 0;
        	if (nacha.getRecordTypeCode().equals("1")) {
        		temp = nacha.getRecordTypeCode();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getPriorityCode();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getiDestination();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getiOrigin();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getFileCreateDate();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getFileCreateTime();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getfileIDMod();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getrecordSize();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getblockingFac();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getformatCode();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getiDestinationName();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getiOrginName();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getReferencecode();
            	tester[i][j] = temp;
            	j++;
            	tester[i][j] = "<br>";
                bean = (Object) bean;      
                bean = in.read();   
                nacha = (NACHA) bean; 
                i++;
        	}
        	else if (nacha.getRecordTypeCode().equals("5")) {
        		temp = nacha.getRecordTypeCode();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getserviceCode();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getcomapanyName();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getdiscretionaryDataCBH();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getcompIdentification();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getstandardEntry();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getcompanyEntryDescription();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getcompanyDescriptive();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.geteffectiveEntryDate();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getsettlementDate();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getoriginator();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getoriginationgDFI();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getbatchNumberCBH();
            	tester[i][j] = temp;
            	j++;
            	tester[i][j] = "<br>";
                bean = (Object) bean;      
                bean = in.read();   
                nacha = (NACHA) bean; 
                i++;
        	}
        	else if (nacha.getRecordTypeCode().equals("6")) {
        		j = 0;
            	temp = nacha.getRecordTypeCode();
            	tester[i][j] = temp;
            	j++;
            	temp = nacha.gettransactionCode();
            	tester[i][j] = temp;
            	j++;
            	temp = nacha.getroutingNumber();
            	tester[i][j] = temp;
            	j++;
            	temp = nacha.getroutingNumberCredit();
            	tester[i][j] = temp;
            	j++;
            	temp = nacha.getroutingNumberAccount();
            	tester[i][j]= temp;
            	j++;
            	temp = nacha.getamount();
            	tester[i][j] = temp;
            	j++;
            	temp = nacha.getreceiverID();
            	tester[i][j] = temp;
            	j++;
            	temp = nacha.getreciever();
            	tester[i][j] = temp;
            	j++;
            	temp = nacha.getdiscretionaryDataED();
            	tester[i][j] = temp;
            	j++;
            	temp = nacha.getaddendaRecord();
            	tester[i][j] = temp;
            	j++;
            	temp = nacha.gettraceNumber();
            	tester[i][j] = temp;
            	j++;
            	tester[i][j] = "<br>";
                bean = (Object) bean;      
                bean = in.read();   
                nacha = (NACHA) bean; 
                i++;
        	}
        	else if (nacha.getRecordTypeCode().equals("8")) {
                temp = nacha.getRecordTypeCode();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getserviceClass();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getaddendaCountCBC();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getentryHashCBC();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.gettotalDebitAmountCBC();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.gettotalCreditAmountCBC();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getcompanyID();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getmessageAuth();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getbankUseCBC();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getdfiID();
            	tester[i][j] = temp;
            	j++;
                temp = nacha.getbatchNumberCBC();
            	tester[i][j] = temp;
            	j++;
            	tester[i][j] = "<br>";
                bean = (Object) bean;      
                bean = in.read();   
                nacha = (NACHA) bean; 
                i++;
        	}
        	else if (nacha.getRecordTypeCode().equals("9")) {
        	       temp = nacha.getRecordTypeCode();
	               	tester[i][j] = temp;
	               	j++;
        	        temp = nacha.getbatchCount();
                	tester[i][j] = temp;
                	j++;
        	        temp = nacha.getblockCount();
                	tester[i][j] = temp;
                	j++;
        	        temp = nacha.getAddendaCountFC();
                	tester[i][j] = temp;
                	j++;
        	        temp = nacha.getentryHashFC();
                	tester[i][j] = temp;
                	j++;
        	        temp = nacha.gettotalDebitAmountFC();
                	tester[i][j] = temp;
                	j++;
        	        temp = nacha.gettotalCreditAmountFC();
                	tester[i][j] = temp;
                	j++;
        	        temp = nacha.getbankUseFC();
                	tester[i][j] = temp;
                	j++;   
        	        temp = nacha.getbankUseFC();
                	tester[i][j] = temp;
                	j++;
                	tester[i][j] = "<br>";
                    bean = (Object) bean;      
                    bean = in.read();   
                    nacha = (NACHA) bean; 
                    i++;
        	}        	

        }
		return tester;
    	
    }
}

