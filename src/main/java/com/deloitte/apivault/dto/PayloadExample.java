package com.deloitte.apivault.dto;


public class PayloadExample {
	
	public static final String applyPrepayments = "e.g:\r\n\n"
											    		+"  {\r\n"
														+ "    \"InvoiceNumber\": \"AND-SI-1\"\r\n"
														+ "  }";
	
	public static final String calculateTax = "e.g:\r\n\n"
										    		+"{\r\n"
													+ "	\"InvoiceNumber\": \"REST_Invoice\",\r\n"
													+ "	\"BusinessUnit\": \"Vision Operations\",\r\n"
													+ "	\"Supplier\": \"Advanced Network Devices\"\r\n"
													+ "}";
	
	public static final String cancelInvoice = "e.g:\r\n\n"
										    		+"	{\r\n"
													+ "		\"InvoiceNumber\": \"REST_Invoice\",\r\n"
													+ "		\"BusinessUnit\": \"Vision Operations\",\r\n"
													+ "		\"Supplier\": \"Advanced Network Devices\"\r\n"
													+ "	}";
	
	public static final String cancelLineInvoice = "e.g:\r\n\n"
											    		+"{\r\n"
														+ "		\"InvoiceNumber\": \"REST_Invoice\",\r\n"
														+ "		\"BusinessUnit\": \"Vision Operations\",\r\n"
														+ "		\"Supplier\": \"Advanced Network Devices\",\r\n"
														+ "		\"LineNumber\": 1\r\n"
														+ "	}";

    public static final String createInvoice = "e.g:\r\n\n"
										    		+"{\r\n"
										    		+ "    \"InvoiceNumber\": \"AND_Unmatched_Invoice\",\r\n"
										    		+ "    \"InvoiceCurrency\": \"USD\",\r\n"
										    		+ "    \"InvoiceAmount\": 2212.75,\r\n"
										    		+ "    \"InvoiceDate\": \"2019-02-01\",\r\n"
										    		+ "    \"BusinessUnit\": \"Vision Operations\",\r\n"
										    		+ "    \"Supplier\": \"Advanced Network Devices\",\r\n"
										    		+ "    \"SupplierSite\": \"FRESNO\",\r\n"
										    		+ "    \"Requester\": \"Johnson,Mary\",\r\n"
										    		+ "    \"InvoiceGroup\": \"01Feb2019\",\r\n"
										    		+ "    \"Description\": \"Office Supplies\",\r\n"
										    		+ "   \r\n"
										    		+ "    \"attachments\": [{\r\n"
										    		+ "        \"Type\": \"File\",\r\n"
										    		+ "        \"FileName\": \"REST Invoice related attachment.txt\",\r\n"
										    		+ "        \"Title\": \"REST Invoice related attachment\",\r\n"
										    		+ "        \"Description\": \"REST Invoice related attachment\",\r\n"
										    		+ "        \"Category\": \"From Supplier\",\r\n"
										    		+ "        \"FileUrl\": \"/content/conn/ContentRepository/uuid/dDocID%3a407437?XFND_SCHEME_ID=1&XFND_CERT_FP=01A8AFB3277D68B1E0D8CFC44C59578044ADBAE0&XFND_RANDOM=2869500116500884411&XFND_EXPIRES=1536137883284&XFND_SIGNATURE=j1ybpNkr471dYeRg85cBp-j~nC38M-jZhC048FSZs13sKO5O9uEmyObHD1nwCO6vg2BB5msYya2tBqfYiZBE380SWm4xLWF6XEgl23nNnYpqfV~36JNI3b~gXHSP-7yrs5qB~MDT7rPRDi9eGUUByuXtkV1Qb~QZdnSxBYiTPl~5GKLPgRygYWjiq1VykWln0X52US98VW4G5aS6KVewwAPJsusw51c14Z1tkAkbX5No08eQgw2fCEft0syNgzSkWcu9r04681rv-JMZW8tv43waaI3ZDefbysjoo7vXWjYjcwKx~1p0~OMBfQc2Qp~Te1hvTgjoOy8EdMtnz1FmJA__&ld=407437&download\"\r\n"
										    		+ "   \r\n"
										    		+ "    }],\r\n"
										    		+ "   \r\n"
										    		+ "    \"invoiceDff\": [{\r\n"
										    		+ "        \"test1\": \"Urgent\"\r\n"
										    		+ "    }],\r\n"
										    		+ "   \r\n"
										    		+ "    \"invoiceInstallments\": [{\r\n"
										    		+ "            \"InstallmentNumber\": 1,\r\n"
										    		+ "            \"DueDate\": \"2019-02-10\",\r\n"
										    		+ "            \"GrossAmount\": 1100,\r\n"
										    		+ "            \"invoiceInstallmentDff\": [{\r\n"
										    		+ "                \"_Payment__mode\": \"W\"\r\n"
										    		+ "            }]\r\n"
										    		+ "        },\r\n"
										    		+ "        {\r\n"
										    		+ "            \"InstallmentNumber\": 2,\r\n"
										    		+ "            \"DueDate\": \"2019-02-25\",\r\n"
										    		+ "            \"GrossAmount\": 1212.75,\r\n"
										    		+ "            \"invoiceInstallmentDff\": [{\r\n"
										    		+ "                \"_Payment__mode\": \"W\"\r\n"
										    		+ "            }]\r\n"
										    		+ "        }\r\n"
										    		+ "    ],\r\n"
										    		+ "   \r\n"
										    		+ "    \"invoiceLines\": [{\r\n"
										    		+ "        \"LineNumber\": 1,\r\n"
										    		+ "        \"LineAmount\": 2112.75,\r\n"
										    		+ "   \r\n"
										    		+ "        \"invoiceDistributions\": [{\r\n"
										    		+ "            \"DistributionLineNumber\": 1,\r\n"
										    		+ "            \"DistributionLineType\": \"Item\",\r\n"
										    		+ "            \"DistributionAmount\": 2112.75,\r\n"
										    		+ "            \"DistributionCombination\": \"01-420-7110-0000-000\"\r\n"
										    		+ "   \r\n"
										    		+ "        }]\r\n"
										    		+ "        },\r\n"
										    		+ "        {\r\n"
										    		+ "            \"LineNumber\": 2,\r\n"
										    		+ "            \"LineType\": \"Freight\",\r\n"
										    		+ "            \"LineAmount\": 100,\r\n"
										    		+ "            \"ProrateAcrossAllItemsFlag\": true\r\n"
										    		+ "        }]\r\n"
										    		+ "   \r\n"
										    		+ "}";

	public static final String getInvoiceById = "eg : 300100175278468";
	
	public static final String updateInvoiceById = "eg : 300100175278468";
	
	public static final String updateInvoice = "e.g : \r\n\n"
										    		+"{\r\n"
													+ "\"PayGroup\": \"Netting Invoices\"\r\n"
													+ "}";
	
	public static final String createReceivableInvoice = "e.g:\r\n\n" 
															+"{\r\n"
															+ "    \"BillingDate\":\"2018-10-10\",\r\n"
															+ "    \"BillToCustomerNumber\":\"1008\",\r\n"
															+ "    \"BusinessUnit\":\"Vision Operations\",\r\n"
															+ "    \"Comments\":\"Test comments\",\r\n"
															+ "    \"DueDate\":\"2018-10-10\",\r\n"
															+ "    \"InternalNotes\":\"Test internal notes\",\r\n"
															+ "    \"InvoiceCurrencyCode\":\"USD\",\r\n"
															+ "    \"PaymentTerms\":\"30 Net\",\r\n"
															+ "    \"TransactionDate\":\"2018-10-10\",\r\n"
															+ "    \"TransactionSource\":\"Manual-NES\",\r\n"
															+ "    \"ShipToCustomerName\":\"Total Internet\",\r\n"
															+ "    \"ShipToCustomerNumber\":\"1008\",\r\n"
															+ "    \"ShipToSite\":\"1042\",\r\n"
															+ "    \"TransactionType\":\"Invoice\",\r\n"
															+ "    \"StructuredPaymentReference\":\"TestRef\",\r\n"
															+ "    \"receivablesInvoiceLines\":[\r\n"
															+ "       {\r\n"
															+ "          \"Description\":\"Item\",\r\n"
															+ "          \"LineNumber\":1,\r\n"
															+ "          \"Quantity\":102,\r\n"
															+ "          \"UnitSellingPrice\":100,\r\n"
															+ "          \"TaxClassificationCode\":\"VAT20\",\r\n"
															+ "          \"receivablesInvoiceLineTaxLines\":[\r\n"
															+ "             {\r\n"
															+ "                \"TaxAmount\":680,\r\n"
															+ "                \"TaxRegimeCode\":\"FUS_STCC_REGIME-UES\",\r\n"
															+ "                \"TaxRateCode\":\"VAT20\"\r\n"
															+ "             }\r\n"
															+ "          ]\r\n"
															+ "       },\r\n"
															+ "       {\r\n"
															+ "          \"Description\":\"Item\",\r\n"
															+ "          \"LineNumber\":2,\r\n"
															+ "          \"Quantity\":10,\r\n"
															+ "          \"UnitSellingPrice\":100.2,\r\n"
															+ "          \"TaxClassificationCode\":\"VAT20\",\r\n"
															+ "          \"receivablesInvoiceLineTaxLines\":[\r\n"
															+ "             {\r\n"
															+ "                \"TaxAmount\":180.4,\r\n"
															+ "                \"TaxRegimeCode\":\"FUS_STCC_REGIME-UES\",\r\n"
															+ "                \"TaxRateCode\":\"VAT20\"\r\n"
															+ "             }\r\n"
															+ "          ]\r\n"
															+ "       }\r\n"
															+ "    ]\r\n"
															+ " }";
	
	public static final String getReceivableInvoiceById = "eg : 300100552587636";  
	
	public static final String updateReceivableInvoiceById = "eg : 300100169169047";
	
	public static final String updateReceivableInvoice = "e.g:\r\n\n" 
															+ "{\r\n"
															+ "\"InvoiceStatus\":\"Complete\"\r\n"
															+ "}";
	
	public static final String deleteReceivableInvoiceById = "eg : 300100169169061";
													
	public static final String createProject = "e.g:\r\n\n" 
													+"{\r\n"
													+ "\"AllowCapitalizedInterestFlag\": true,\r\n"
													+ "\"SourceTemplateName\": \"T, Consulting & Construction (VO)\",\r\n"
													+ "\"ProjectName\": \"Rest_prj_test006\",\r\n"
													+ "\"ProjectNumber\": \"Rest_prj_test006\",\r\n"
													+ "\"AssetAllocationMethodCode\": \"CE\",\r\n"
													+ "\"BurdenScheduleName\":\"Cost Plus Costing-Fusion\",\r\n"
													+ "\"BurdenScheduleFixedDate\" : \"2003-03-23\",\r\n"
													+ "\"CapitalEventProcessingMethodCode\" : \"N\",\r\n"
													+ "\"CIntRateSchName\":\"Operations Interest\",\r\n"
													+ "\"CIntStopDate\": \"2020-03-24\",\r\n"
													+ "\"CurrencyConvDate\" : \"2019-04-22\",\r\n"
													+ "\"CurrencyConvRateType\" : \"100000013585009\",\r\n"
													+ "\"CurrencyConvDateTypeCode\" : \"F\",\r\n"
													+ "\"IncludeNotesInKPINotificationsFlag\": \"true\",\r\n"
													+ "\"KPINotificationEnabledFlag\": \"true\",\r\n"
													+ "\"LegalEntityName\": \"Vision Leasing\",\r\n"
													+ "\"OwningOrganizationId\": \"5186\",\r\n"
													+ "\"PlanningProjectFlag\": \"false\",\r\n"
													+ "\"ProjectCurrencyCode\": \"INR\"\r\n"
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
	
	public static final String updateProject = "e.g:\r\n\n"   
													+"{\r\n"
													+ "\"OwningOrganizationName\": \"Vision Operations\"\r\n"
													+ "}";
	
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
													
	
											
	
	

    
    
    
}
