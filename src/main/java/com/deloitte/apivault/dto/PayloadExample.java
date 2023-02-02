package com.deloitte.apivault.dto;


public class PayloadExample {
	
	public static final String applyPrepayments = "e.g:\r\n\n"
											    		+"  {\r\n"
														+ "    \"InvoiceNumber\": \"AND-SI-1\"\r\n"
														+ "  }";
	
	public static final String calculateTax = "e.g:\r\n\n"
										    		+"{\r\n"
										    		+ "	\"InvoiceNumber\": \"9988776\",\r\n"
										    		+ "	\"BusinessUnit\": \"Lookahead US BU\",\r\n"
										    		+ "	\"Supplier\": \"Lookahead Test Supplier\"\r\n"
										    		+ "}";
	
	public static final String cancelInvoice = "e.g:\r\n\n"
										    		+"{\r\n"
										    		+ "	\"InvoiceNumber\": \"9988776\",\r\n"
										    		+ "	\"BusinessUnit\": \"Lookahead US BU\",\r\n"
										    		+ "	\"Supplier\": \"Lookahead Test Supplier\"\r\n"
										    		+ "}";
	
	public static final String cancelLineInvoice = "e.g:\r\n\n"
											    		+"{\r\n"
											    		+ "	\"InvoiceNumber\": \"9988776\",\r\n"
											    		+ "	\"BusinessUnit\": \"Lookahead US BU\",\r\n"
											    		+ "	\"Supplier\": \"Lookahead Test Supplier\",\r\n"
											    		+"	\"LineNumber\": 1"
											    		+ "}";
	
	public static final String validateInvoice = "e.g:\r\n\n"
											    		+"{\r\n"
											    		+ "    \"InvoiceNumber\": \"12MAT\",\r\n"
											    		+ "    \"BusinessUnit\": \"Lookahead US BU\",\r\n"
											    		+ "    \"Supplier\": \"Lookahead Test Supplier\",\r\n"
											    		+ "    \"ProcessAction\": \"Validate\"}";

    public static final String createInvoice = "e.g:\r\n\n"
                                                    +"{\r\n"
													+ "  \"InvoiceNumber\": \"9980706\",\r\n"
													+ "  \"InvoiceCurrency\": \"USD\",\r\n"
													+ "  \"InvoiceAmount\": 2212.75,\r\n"
													+ "  \"InvoiceDate\": \"2019-02-01\",\r\n"
													+ "  \"BusinessUnit\": \"Lookahead US BU\",\r\n"
													+ "  \"Supplier\": \"Lookahead Test Supplier\",\r\n"
													+ "  \"SupplierSite\": \"LA Remittance\",\r\n"
													+ "  \"Description\": \"Office Supplies\",\r\n"
													+ "  \"PaymentMethod\": \"Wire\",\r\n"
													+ "  \"invoiceLines\": [{\r\n"
													+ "        \"LineNumber\": 1,\r\n"
													+ "        \"LineAmount\": 2112.75\r\n"
													+ "   \r\n"
													+ "        },\r\n"
													+ "        {\r\n"
													+ "            \"LineNumber\": 2,\r\n"
													+ "            \"LineType\": \"Freight\",\r\n"
													+ "            \"LineAmount\": 100,\r\n"
													+ "            \"ProrateAcrossAllItemsFlag\": true\r\n"
													+ "        }]\r\n"
													+ "}";

	public static final String getInvoiceById = "eg : 300100175278468";
	
	public static final String updateInvoiceById = "eg : 300100175278468";
	
	public static final String updateInvoice = "{\r\n"
												+ "  \"InvoiceNumber\": \"INV639_22\",\r\n"
												+ "  \"InvoiceCurrency\": \"USD\",\r\n"
												+ "  \"PaymentCurrency\": \"USD\",\r\n"
												+ "  \"InvoiceAmount\": 0,\r\n"
												+ "  \"InvoiceDate\": \"2020-12-04\",\r\n"
												+ "  \"BusinessUnit\": \"Lookahead US BU\",\r\n"
												+ "  \"Supplier\": \"Stephan 1\",\r\n"
												+ "  \"SupplierNumber\": \"101316\"}"	;
	
	public static final String createReceivableInvoice = "e.g:\r\n\n" 
															+"{\r\n"
															+ "    \"TransactionNumber\": \"5747310-R3\",\r\n"
															+ "    \"BillingDate\": \"2022-10-10\",\r\n"
															+ "    \"BillToCustomerNumber\": \"990001\",\r\n"
															+ "    \"BillToSite\": \"9900012\",\r\n"
															+ "    \"BusinessUnit\": \"Lookahead US BU\",\r\n"
															+ "    \"Comments\": \"Test comments\",\r\n"
															+ "    \"DueDate\": \"2022-10-10\",\r\n"
															+ "    \"InternalNotes\": \"Test internal notes\",\r\n"
															+ "    \"InvoiceCurrencyCode\": \"USD\",\r\n"
															+ "    \"PaymentTerms\": \"30 Net\",\r\n"
															+ "    \"TransactionDate\": \"2022-10-10\",\r\n"
															+ "    \"TransactionSource\": \"Manual\",\r\n"
															+ "    \"RemitToAddress\": \"Attention: General Billing Administration, 55 Trinity Avenue, SW Suite #1350\",\r\n"
															+ "    \"ShipToCustomerNumber\": \"720106\",\r\n"
															+ "    \"ShipToSite\": \"9900012\",\r\n"
															+ "    \"TransactionType\": \"Invoice\",\r\n"
															+ "    \"StructuredPaymentReference\": \"TestRef\",\r\n"
															+ "    \"receivablesInvoiceLines\": [\r\n"
															+ "        {\r\n"
															+ "            \"Description\": \"Item\",\r\n"
															+ "            \"LineNumber\": 1,\r\n"
															+ "            \"Quantity\": 102,\r\n"
															+ "            \"UnitSellingPrice\": 100.5\r\n"
															+ "        },\r\n"
															+ "        {\r\n"
															+ "            \"Description\": \"Item\",\r\n"
															+ "            \"LineNumber\": 2,\r\n"
															+ "            \"Quantity\": 10,\r\n"
															+ "            \"UnitSellingPrice\": 100.6\r\n"
															+ "        }\r\n"
															+ "    ]\r\n"
															+ "}";
	
	public static final String getReceivableInvoiceById = "eg : 300100552587636";  
	
	public static final String updateReceivableInvoiceById = "eg : 300100169169047";
	
	public static final String updateReceivableInvoice = "{\r\n"
															+ "      \"DueDate\": \"2020-12-14\",\r\n"
															+ "      \"ConversionDate\": null,\r\n"
															+ "      \"ConversionRate\": null,\r\n"
															+ "      \"InvoiceCurrencyCode\": \"USD\",\r\n"
															+ "      \"SpecialInstructions\": null,\r\n"
															+ "      \"CrossReference\": \"300000011989194\"\r\n"
															+ "}";
	
	public static final String deleteReceivableInvoiceById = "eg : 300100169169061";
													
	public static final String createProject = "e.g:\r\n\n" 
													+"{\r\n"
													+ "    \"ProjectName\": \"Cloud_Api_Vault438\",\r\n"
													+ "    \"ProjectNumber\": \"Cloud_Api_Vault438\"\r\n"
													+ "}";
	
	public static final String createProjectAddTask = "e.g:\r\n\n"  
															+"{\r\n"
															+ "    \"type\":\"object\",\r\n"
															+ "    \"properties\":{\r\n"
															+ "        \"taskNumberPrefix\":{\r\n"
															+ "            \"type\":\"string\",\r\n"
															+ "            \"description\":\"Task Number Prefix\",\r\n"
															+ "            \"nullable\":true\r\n"
															+ "        },\r\n"
															+ "        \"referenceTaskNumber\":{\r\n"
															+ "            \"type\":\"string\",\r\n"
															+ "            \"description\":\"Reference Task Number\",\r\n"
															+ "            \"nullable\":true\r\n"
															+ "        },\r\n"
															+ "        \"workplanTemplateName\":{\r\n"
															+ "            \"type\":\"string\",\r\n"
															+ "            \"description\":\"Work Plan Template Name\",\r\n"
															+ "            \"nullable\":true\r\n"
															+ "        },\r\n"
															+ "        \"isPeer\":{\r\n"
															+ "            \"type\":\"boolean\",\r\n"
															+ "            \"description\":\"Is Peer\",\r\n"
															+ "            \"nullable\":true\r\n"
															+ "        },\r\n"
															+ "        \"referenceTaskId\":{\r\n"
															+ "            \"type\":\"number\",\r\n"
															+ "            \"description\":\"Reference Task ID\",\r\n"
															+ "            \"nullable\":true\r\n"
															+ "        },\r\n"
															+ "        \"workplanTemplateId\":{\r\n"
															+ "            \"type\":\"number\",\r\n"
															+ "            \"description\":\"Work Plan Template ID\",\r\n"
															+ "            \"nullable\":true\r\n"
															+ "        }\r\n"
															+ "    },\r\n"
															+ "    \"additionalProperties\":false\r\n"
															+ "}";
	
	public static final String getProjectId = "eg : 300100169169047";
	
	public static final String updateProjectId = "eg : 300100180571436";
	
	public static final String updateProject = "{\"AllowCapitalizedInterestFlag\": null,\r\n"
												+ "      \"AllowCrossChargeFlag\": false,\r\n"
												+ "      \"AssetAllocationMethodCode\": \"N\",\r\n"
												+ "      \"BurdenScheduleId\": 300000004017317,\r\n"
												+ "      \"BurdenScheduleFixedDate\": null,\r\n"
												+ "      \"BurdenScheduleName\": \"No Burden\"}";

	public static final String cancelPurchaseOrder = "e.g:\r\n\n"  
															+"{\r\n"
															+ "	\"name\": \"cancel\",\r\n"
															+ "	\"parameters\": [\r\n"
															+ "	{\r\n"
															+ "		\"cancellationReason\": \"No longer required\"\r\n"
															+ "	},\r\n"
															+ "	{\r\n"
															+ "		\"initiatingParty\": \"buyer\"\r\n"
															+ "	}\r\n"
															+ "	]\r\n"
															+ "}";
	
	public static final String closePurchaseOrder = "e.g:\r\n\n"  
														+"{\r\n"
														+ "	\"name\": \"close\",\r\n"
														+ "	\"parameters\": [\r\n"
														+ "	{\r\n"
														+ "		\"closeAction\": \"close\"\r\n"
														+ "	},\r\n"
														+ "	{\r\n"
														+ "		\"closeReason\": \"Header close reason\"\r\n"
														+ "	}\r\n"
														+ "	]\r\n"
														+ "}";
	
	public static final String recommunicatePurchaseOrder = "BODY";
	
	public static final String renumberPurchaseOrder = "e.g:\r\n\n"  
															+"{\r\n"
															+ "    \"name\": \"renumberPO\",\r\n"
															+ "    \"parameters\": [\r\n"
															+ "        {\r\n"
															+ "        \"newOrderNumber\": \"422092_POToBeCancelled\"\r\n"
															+ "        }\r\n"
															+ "     ]\r\n"
															+ "}\r\n"
															+ "";
													
	public static final String resubmitPurchaseOrder = "e.g:\r\n\n"  
															+"{\r\n"
															+ "  \"name\": \"submit\",\r\n"
															+ "  \"parameters\": [\r\n"
															+ "    {\r\n"
															+ "      \"bypassApprovalsFlag\": \"false\"\r\n"
															+ "    }\r\n"
															+ "  ]\r\n"
															+ "}";

	public static final String createWorker = "e.g:\r\n\n"
			                                        +"{\r\n"
			                                        + "\r\n"
			                                        + "      \"names\": [\r\n"
			                                        + "\r\n"
			                                        + "        {\r\n"
			                                        + "\r\n"
			                                        + "          \"LastName\": \"CloudAPIVault-1111\",\r\n"
			                                        + "\r\n"
			                                        + "          \"LegislationCode\": \"US\",\r\n"
			                                        + "\r\n"
			                                        + "          \"FirstName\": \"John\"\r\n"
			                                        + "\r\n"
			                                        + "        }\r\n"
			                                        + "\r\n"
			                                        + "      ],\r\n"
			                                        + "\r\n"
			                                        + "      \"DateOfBirth\": \"1987-01-01\",\r\n"
			                                        + "\r\n"
			                                        + "      \"workRelationships\": [\r\n"
			                                        + "\r\n"
			                                        + "        {\r\n"
			                                        + "\r\n"
			                                        + "          \"LegalEmployerName\": \"Lookahead US Corp.\",\r\n"
			                                        + "\r\n"
			                                        + "          \"WorkerType\": \"E\",\r\n"
			                                        + "\r\n"
			                                        + "          \"assignments\": [ \r\n"
			                                        + "\r\n"
			                                        + "            {\r\n"
			                                        + "\r\n"
			                                        + "              \"ActionCode\": \"HIRE\",\r\n"
			                                        + "\r\n"
			                                        + "              \"BusinessUnitName\": \"Lookahead US BU\"\r\n"
			                                        + "\r\n"
			                                        + "            }\r\n"
			                                        + "\r\n"
			                                        + "          ]\r\n"
			                                        + "\r\n"
			                                        + "        }\r\n"
			                                        + "\r\n"
			                                        + "      ]\r\n"
			                                        + "\r\n"
			                                        + "    }";

	public static final String updateWorker = "e.g:\r\n\n" 
			                                        +"{\r\n"
			                                        + " \"DateOfBirth\": \"1987-01-01\",\r\n"
			                                        + " \"CountryOfBirth\" : \"US\"\r\n"
			                                        + " }";
													
	
											
	
	

    
    
    
}
