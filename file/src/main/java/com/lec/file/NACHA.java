 package com.lec.file;
import org.beanio.*;
import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

import java.io.*;

@Record(maxOccurs=100)

public class NACHA {
	
	@Field(at = 0, length = 1, keepPadding =true)
	private String recordTypeCode;
	// File Header Format
	@Field(at = 1, length = 2, keepPadding =true)
	private String priorityCode;
	@Field(at = 3, length = 10, keepPadding =true)
	private String iDestination;
	@Field(at = 13, length = 10, keepPadding =true)
	private String iOrigin;
	@Field(at = 23, length = 6, keepPadding =true)
	private String fileCDate;
	@Field(at = 29, length = 4, keepPadding =true)
	private String fileCTime;
	@Field(at = 33, length = 1, keepPadding =true)
	private String fileIDMod;
	@Field(at = 34, length = 3, keepPadding =true)
	private String recordSize;
	@Field(at = 37, length = 2, keepPadding =true)
	private String blockingFac;
	@Field(at = 39, length = 1, keepPadding =true)
	private String formatCode;
	@Field(at = 40, length = 23, keepPadding =true)
	private String iDestinationName;
	@Field(at = 63, length = 23, keepPadding =true)
	private String iOrginName;
	@Field(at = 86, length = 8, keepPadding =true)
	private String referencecode;
	// Company Batch Header
	@Field(at = 1, length = 3, keepPadding =true)
	private String serviceCode;
	@Field(at = 4, length = 16, keepPadding =true)
	private String comapanyName;
	@Field(at = 20, length = 20, keepPadding =true)
	private String discretionaryDataCBH;
	@Field(at = 40, length = 10, keepPadding =true)
	private String compIdentification;
	@Field(at = 50, length = 3, keepPadding =true)
	private String standardEntry;
	@Field(at = 53, length = 10, keepPadding =true)
	private String companyEntryDescription;
	@Field(at = 63, length = 6, keepPadding =true)
	private String companyDescriptive;
	@Field(at = 69, length = 6, keepPadding =true)
	private String effectiveEntryDate;
	@Field(at = 75, length = 3, keepPadding =true)
	private String settlementDate;
	@Field(at = 78, length = 1, keepPadding =true)
	private String originator;
	@Field(at = 79, length = 8, keepPadding =true)
	private String originationgDFI;
	@Field(at = 87, length = 7, keepPadding =true)
	private String batchNumberCBH;
	// Entry Detail
	@Field(at = 1, length = 2, keepPadding =true)
	private String transactionCode;
	@Field(at = 3, length = 8, keepPadding =true)
	private String routingNumber;
	@Field(at = 11, length = 1, keepPadding =true)
	private String routingNumberCredit;
	@Field(at = 12, length = 17, keepPadding =true)
	private String routingNumberAccount;
	@Field(at = 29, length = 10, keepPadding =true)
	private String amount;
	@Field(at = 39, length = 15, keepPadding =true)
	private String receiverID;
	@Field(at = 54, length = 22, keepPadding =true)
	private String reciever;
	@Field(at = 76, length = 2, keepPadding =true)
	private String discretionaryDataED;
	@Field(at = 78, length = 1, keepPadding =true)
	private String addendaRecord;
	@Field(at = 79, length = 15, keepPadding =true)
	private String traceNumber;
	//Company/Batch Control Record Format 
	@Field(at = 1, length = 3, keepPadding =true)
	private String serviceClass;
	@Field(at = 4, length = 6, keepPadding =true)
	private String addendaCount;
	@Field(at = 10, length = 10, keepPadding =true)
	private String entryHashCBC;
	@Field(at = 20, length = 12, keepPadding =true)
	private String totalDebitAmountCBC;
	@Field(at = 32, length = 12, keepPadding =true)
	private String totalCreditAmountCBC;
	@Field(at = 44, length = 10, keepPadding =true)
	private String companyID;
	@Field(at = 54, length = 19, keepPadding =true)
	private String messageAuth;
	@Field(at = 73, length = 6, keepPadding =true)
	private String bankUseCBC;
	@Field(at = 79, length = 8, keepPadding =true)
	private String dfiID;
	@Field(at = 87, length = 7, keepPadding =true)
	private String batchNumberCBC;
	//File Control Record Format
	@Field(at = 1, length = 6, keepPadding =true)
	private String batchCount;
	@Field(at = 7, length = 6, keepPadding =true)
	private String blockCount;
	@Field(at = 13, length = 8, keepPadding =true)
	private String AddendaCount;
	@Field(at = 21, length = 10, keepPadding =true)
	private String entryHashFC;
	@Field(at = 31, length = 12, keepPadding =true)
	private String totalDebitAmountFC;
	@Field(at = 43, length = 12, keepPadding =true)
	private String totalCreditAmountFC;
	@Field(at = 55, length = 39, keepPadding =true)
	private String bankUseFC;
	
	
	public String getRecordTypeCode() {
		return recordTypeCode;
	}
	public void setRecordTypeCode(String recordTypeCode) {
		this.recordTypeCode = recordTypeCode;
	}
	public String getPriorityCode() {
		return priorityCode;
	}
	public void setPriorityCode(String priorityCode) {
		this.priorityCode = priorityCode;
	}
	public String getiDestination() {
		return iDestination;
	}
	public void setiDestination(String iDestination) {
		this.iDestination = iDestination;
	}
	public String getiOrigin() {
		return iOrigin;
	}
	public void setiOrigin(String iOrigin) {
		this.iOrigin = iOrigin;
	}
	public String getFileCreateDate() {
		return fileCDate;
	}
	public void setFileCreateDate(String fileCDate) {
		this.fileCDate = fileCDate;
	}
	public String getFileCreateTime() {
		return fileCDate;
	}
	public void setFileCreateTime(String fileCTime) {
		this.fileCTime = fileCTime;
	}
	public String getfileIDMod() {
		return fileIDMod;
	}
	public void setfileIDMod(String fileIDMod) {
		this.fileIDMod = fileIDMod;
	}
	public String getrecordSize() {
		return recordSize;
	}
	public void setrecordSize(String recordSize) {
		this.recordSize = recordSize;
	}
	public String getblockingFac() {
		return blockingFac;
	}
	public void setblockingFac(String blockingFac) {
		this.blockingFac = blockingFac;
	}
	public String getformatCode() {
		return formatCode;
	}
	public void setformatCode(String formatCode) {
		this.formatCode = formatCode;
	}
	public String getiDestinationName() {
		return iDestinationName;
	}
	public void setiDestinationName(String iDestinationName) {
		this.iDestinationName = iDestinationName;
	}
	public String getiOrginName() {
		return iOrginName;
	}
	public void setiOrginName(String iOrginName) {
		this.iOrginName = iOrginName;
	}
	public String getReferencecode() {
		return referencecode;
	}
	public void setReferencecode(String referencecode) {
		this.referencecode = referencecode;
	}
	
	
	
	public String getserviceCode() {
		return serviceCode;
	}
	public void setserviceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getcomapanyName() {
		return comapanyName;
	}
	public void setcomapanyName(String comapanyName) {
		this.comapanyName = comapanyName;
	}
	public String getdiscretionaryDataCBH() {
		return discretionaryDataCBH;
	}
	public void setdiscretionaryDataCBH(String discretionaryDataCBH) {
		this.discretionaryDataCBH = discretionaryDataCBH;
	}
	public String getcompIdentification() {
		return compIdentification;
	}
	public void setcompIdentification(String compIdentification) {
		this.compIdentification = compIdentification;
	}
	public String getstandardEntry() {
		return standardEntry;
	}
	public void setstandardEntry(String standardEntry) {
		this.standardEntry = standardEntry;
	}
	public String getcompanyEntryDescription() {
		return companyEntryDescription;
	}
	public void setcompanyEntryDescription(String companyEntryDescription) {
		this.companyEntryDescription = companyEntryDescription;
	}
	public String getcompanyDescriptive() {
		return companyDescriptive;
	}
	public void setcompanyDescriptive(String companyDescriptive) {
		this.companyDescriptive = companyDescriptive;
	}
	public String geteffectiveEntryDate() {
		return effectiveEntryDate;
	}
	public void seteffectiveEntryDate(String effectiveEntryDate) {
		this.effectiveEntryDate = effectiveEntryDate;
	}
	public String getsettlementDate() {
		return settlementDate;
	}
	public void setsettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}
	public String getoriginator() {
		return originator;
	}
	public void setoriginator(String originator) {
		this.originator = originator;
	}
	public String getoriginationgDFI() {
		return originationgDFI;
	}
	public void setoriginationgDFI(String originationgDFI) {
		this.originationgDFI = originationgDFI;
	}
	public String getbatchNumberCBH() {
		return batchNumberCBH;
	}
	public void setbatchNumberCBH(String batchNumberCBH) {
		this.batchNumberCBH = batchNumberCBH;
	}


	public String gettransactionCode() {
		return transactionCode;
	}
	public void settransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}
	public String getroutingNumber() {
		return routingNumber;
	}
	public void setroutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}
	public String getroutingNumberCredit() {
		return routingNumberCredit;
	}
	public void setroutingNumberCredit(String routingNumberCredit) {
		this.routingNumberCredit = routingNumberCredit;
	}
	public String getroutingNumberAccount() {
		return routingNumberAccount;
	}
	public void setroutingNumberAccount(String routingNumberAccount) {
		this.routingNumberAccount = routingNumberAccount;
	}
	public String getamount() {
		return amount;
	}
	public void setamount(String amount) {
		this.amount = amount;
	}
	public String getreceiverID() {
		return receiverID;
	}
	public void setreceiverID(String receiverID) {
		this.receiverID = receiverID;
	}
	public String getreciever() {
		return reciever;
	}
	public void setreciever(String reciever) {
		this.reciever = reciever;
	}
	public String getdiscretionaryDataED() {
		return discretionaryDataED;
	}
	public void setdiscretionaryDataED(String discretionaryDataED) {
		this.discretionaryDataED = discretionaryDataED;
	}
	public String getaddendaRecord() {
		return addendaRecord;
	}
	public void setaddendaRecord(String addendaRecord) {
		this.addendaRecord = addendaRecord;
	}
	public String gettraceNumber() {
		return traceNumber;
	}
	public void settraceNumber(String traceNumber) {
		this.traceNumber = traceNumber;
	}


	public String getserviceClass() {
		return serviceClass;
	}
	public void setserviceClass(String serviceClass) {
		this.serviceClass = serviceClass;
	}
	public String getaddendaCountCBC() {
		return addendaCount;
	}
	public int getaddendaCount1CBC() {
		return Integer.parseInt(addendaCount);
	}
	public void setaddendaCountCBC(String addendaCount) {
		this.addendaCount = addendaCount;
	}
	public String getentryHashCBC() {
		return entryHashCBC;
	}
	public void setentryHashCBC(String entryHashCBC) {
		this.entryHashCBC = entryHashCBC;
	}
	public String gettotalDebitAmountCBC() {
		return totalDebitAmountCBC;
	}
	public void settotalDebitAmountCBC(String totalDebitAmountCBC) {
		this.totalDebitAmountCBC = totalDebitAmountCBC;
	}
	public String gettotalCreditAmountCBC() {
		return totalCreditAmountCBC;
	}
	public void settotalCreditAmountCBC(String totalCreditAmountCBC) {
		this.totalCreditAmountCBC = totalCreditAmountCBC;
	}
	public String getcompanyID() {
		return companyID;
	}
	public void setcompanyID(String companyID) {
		this.companyID = companyID;
	}
	public String getmessageAuth() {
		return messageAuth;
	}
	public void setmessageAuth(String messageAuth) {
		this.messageAuth = messageAuth;
	}
	public String getbankUseCBC() {
		return bankUseCBC;
	}
	public void setbankUseCBC(String bankUse) {
		this.bankUseCBC = bankUse;
	}
	public String getdfiID() {
		return dfiID;
	}
	public void setdfiID(String dfiID) {
		this.dfiID = dfiID;
	}
	public String getbatchNumberCBC() {
		return batchNumberCBC;
	}
	public void setbatchNumberCBC(String batchNumberCBC) {
		this.batchNumberCBC = batchNumberCBC;
	}


	public String getbatchCount() {
		return batchCount;
	}
	public void setbatchCount(String batchCount) {
		this.batchCount = batchCount;
	}
	public String getblockCount() {
		return blockCount;
	}
	public void setblockCount(String blockCount) {
		this.blockCount = blockCount;
	}
	public String getAddendaCountFC() {
		return AddendaCount;
	}
	public void setAddendaCountFC(String AddendaCount) {
		this.AddendaCount = AddendaCount;
	}
	public String getentryHashFC() {
		return entryHashFC;
	}
	public void setentryHashFC(String entryHashFC) {
		this.entryHashFC = entryHashFC;
	}
	public String gettotalDebitAmountFC() {
		return totalDebitAmountFC;
	}
	public void settotalDebitAmountFC(String totalDebitAmountFC) {
		this.totalDebitAmountFC = totalDebitAmountFC;
	}
	public String gettotalCreditAmountFC() {
		return totalCreditAmountFC;
	}
	public void settotalCreditAmountFC(String totalCreditAmountFC) {
		this.totalCreditAmountFC = totalCreditAmountFC;
	}
	public String getbankUseFC() {
		return bankUseFC;
	}
	public void setbankUseFC(String bankUseFC) {
		this.bankUseFC = bankUseFC;
	}
}
