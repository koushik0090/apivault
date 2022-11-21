package com.deloitte.apivault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.apivault.service.SupplierAddressService;
import com.deloitte.apivault.service.SupplierContactService;
import com.deloitte.apivault.service.SupplierService;
import com.deloitte.apivault.service.SupplierSiteService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "ApiVaultapi")
public class SupplierController {

	@Autowired
	SupplierService supplierService;

	@Autowired
	SupplierSiteService supplierSiteService;

	@Autowired
	SupplierContactService supplierContactService;

	@Autowired
	SupplierAddressService supplierAddressService;

	// Get all suppliers
	@GetMapping("/suppliers")
	public ResponseEntity<Object> getAllSuppliers() {
		return supplierService.getAllSupplier();
	}

	// Get suppliers by supplier number
	@GetMapping("/suppliers/{SupplierId}")
	public ResponseEntity<Object> getSupplierBySupplierNumber(
			@Parameter(description = "eg. 300000003091951", required = true) @PathVariable("SupplierId") String SupplierId) {
		return supplierService.getSupplierByNumber(SupplierId);
	}

	// Create supplier
	@PostMapping("/suppliers")
	public ResponseEntity<Object> createSupplier(
			@Parameter(description = "e.g:\r\n\n" + "	{\r\n" + "	    \"Supplier\": \"manufacturer engine\",\r\n"
					+ "	    \"SupplierNumber\": \"10224005\",\r\n"
					+ "	    \"TaxOrganizationType\": \"Corporation\",\r\n" + "	    \"SupplierType\": \"Services\",\r\n"
					+ "	    \"BusinessRelationship\": \"Prospective\",\r\n" + "	    \"DUNSNumber\": \"123557789\",\r\n"
					+ "	    \"OneTimeSupplierFlag\": false,\r\n" + "	    \"TaxpayerCountry\": \"United States\",\r\n"
					+ "	    \"TaxpayerId\": \"98-22654\"\r\n" + "	}", required = true) @RequestBody Object supplier)
			 {
		return supplierService.createSupplier(supplier);
	}

	// Update supplier
	@PatchMapping("/suppliers/{SupplierId}")
	public ResponseEntity<Object> updateSupplier(
			@Parameter(description = "e.g:\r\n\n" + "	{\r\n" + "	    \"CorporateWebsite\": \"demo test\",\r\n"
					+ "	    \"TaxpayerCountry\": \"India\",\r\n" + "	    \"Supplier\": \"koushik\"\r\n"
					+ "	}", required = true) @RequestBody Object supplier,
			@Parameter(description = "e.g: 300000003091951", required = true) @PathVariable("SupplierId") String SupplierId) {
		return supplierService.updateSupplier(supplier, SupplierId);
	}

	// Get all suppliers site
	@GetMapping("/suppliers/{SupplierId}/child/sites")
	public ResponseEntity<Object> getAllSuppliersSites(
			@Parameter(description = "e.g: 300000003091951", required = true) @PathVariable("SupplierId") String SupplierId) {
		return supplierSiteService.getAllSupplierSite(SupplierId);
	}

	// Get suppliers site by supplier site id
	@GetMapping("/suppliers/{SupplierId}/child/sites/{SupplierSiteId}")
	public ResponseEntity<Object> getSupplierSiteBySupplierNumber(
			@Parameter(description = "e.g: 300000003091951", required = true) @PathVariable("SupplierId") String SupplierId,
			@Parameter(description = "e.g: 300000003169026", required = true) @PathVariable("SupplierSiteId") String SupplierSiteId) {
		return supplierSiteService.getSupplierSiteByNumber(SupplierId, SupplierSiteId);
	}

	// Create supplier site
	@PostMapping("/suppliers/{SupplierId}/child/sites")
	public ResponseEntity<Object> createSupplierSite(
			@Parameter(description = "e.g: 300000003091951", required = true) @PathVariable("SupplierId") String SupplierId,
			@Parameter(description = "e.g:\r\n\n" + "{\r\n" + "		  \"SupplierSite\": \"REST-DS2\",\r\n"
					+ "		  \"ProcurementBUId\": 300000003086146,\r\n"
					+ "		  \"SupplierAddressName\": \"Headquarter\",\r\n"
					+ "		  \"SitePurposeSourcingOnlyFlag\": false,\r\n"
					+ "		  \"SitePurposePurchasingFlag\": false,\r\n"
					+ "		  \"SitePurposeProcurementCardFlag\": false,\r\n"
					+ "		  \"SitePurposePayFlag\": true,\r\n" + "		  \"SitePurposePrimaryPayFlag\": false,\r\n"
					+ "		  \"IncomeTaxReportingSiteFlag\": false,\r\n"
					+ "		  \"AlternateSiteName\": \"site_alt\",\r\n" + "		  \"CustomerNumber\": \"12350\",\r\n"
					+ "		  \"B2BCommunicationMethodCode\": \"NONE\",\r\n"
					+ "		  \"B2BCommunicationMethod\": \"None\",\r\n"
					+ "		  \"CommunicationMethodCode\": \"EMAIL\",\r\n"
					+ "		  \"CommunicationMethod\": \"E-Mail\",\r\n" + "		  \"Email\": \"aaTest@oracle.com\",\r\n"
					+ "		  \"HoldAllNewPurchasingDocumentsFlag\": true,\r\n"
					+ "		  \"PurchasingHoldReason\": \"Test Reason\",\r\n"
					+ "		  \"RequiredAcknowledgmentCode\": \"D\",\r\n"
					+ "		  \"RequiredAcknowledgment\": \"Document\",\r\n"
					+ "		  \"AcknowledgmentWithinDays\": 7,\r\n" + "		  \"FreightTermsCode\": \"AIR\",\r\n"
					+ "		  \"FreightTerms\": \"AIR\",\r\n" + "		  \"PayOnReceiptFlag\": true,\r\n"
					+ "		  \"FOBCode\": \"DEST\",\r\n" + "		  \"FOB\": \"DEST\",\r\n"
					+ "		  \"CountryOfOriginCode\": \"US\",\r\n"
					+ "		  \"CountryOfOrigin\": \"United States\",\r\n"
					+ "		  \"BuyerManagedTransportationCode\": \"Y\",\r\n"
					+ "		  \"BuyerManagedTransportation\": \"Yes\",\r\n" + "		  \"PayOnUseFlag\": true,\r\n"
					+ "		  \"AgingOnsetPointCode\": \"SHIPMENT\",\r\n"
					+ "		  \"AgingOnsetPoint\": \"Shipment\",\r\n" + "		  \"AgingPeriodDays\": 10,\r\n"
					+ "		  \"ConsumptionAdviceFrequencyCode\": \"DAILY\",\r\n"
					+ "		  \"ConsumptionAdviceFrequency\": \"Daily\",\r\n"
					+ "		  \"ConsumptionAdviceSummaryCode\": \"ALL_INVENTORY_ORGS\",\r\n"
					+ "		  \"ConsumptionAdviceSummary\": \"All organizations\",\r\n"
					+ "		  \"InvoiceSummaryLevelCode\": \"PACKING_SLIP\",\r\n"
					+ "		  \"InvoiceSummaryLevel\": \"Packing Slip\",\r\n"
					+ "		  \"GaplessInvoiceNumberingFlag\": true,\r\n"
					+ "		  \"SellingCompanyIdentifier\": \"1234545\",\r\n"
					+ "		  \"CreateDebitMemoFromReturnFlag\": true,\r\n"
					+ "		  \"ShipToExceptionCode\": \"REJECT\",\r\n" + "		  \"ShipToException\": \"Reject\",\r\n"
					+ "		  \"ReceiptRoutingId\": 3,\r\n" + "		  \"ReceiptRouting\": \"Direct delivery\",\r\n"
					+ "		  \"OverReceiptTolerance\": 1231212,\r\n"
					+ "		  \"OverReceiptActionCode\": \"REJECT\",\r\n"
					+ "		  \"OverReceiptAction\": \"Reject\",\r\n"
					+ "		  \"EarlyReceiptToleranceInDays\": 10,\r\n"
					+ "		  \"LateReceiptToleranceInDays\": 10,\r\n"
					+ "		  \"AllowSubstituteReceiptsCode\": \"Y\",\r\n"
					+ "		  \"AllowSubstituteReceipts\": \"Yes\",\r\n"
					+ "		  \"AllowUnorderedReceiptsFlag\": true,\r\n"
					+ "		  \"ReceiptDateExceptionCode\": \"REJECT\",\r\n"
					+ "		  \"ReceiptDateException\": \"Reject\",\r\n"
					+ "		  \"InvoiceCurrencyCode\": \"USD\",\r\n"
					+ "		  \"InvoiceCurrency\": \"US Dollar\",\r\n" + "		  \"InvoiceAmountLimit\": 1500,\r\n"
					+ "		  \"InvoiceMatchOptionCode\": \"P\",\r\n"
					+ "		  \"InvoiceMatchOption\": \"Order\",\r\n"
					+ "		  \"MatchApprovalLevelCode\": \"THREE\",\r\n"
					+ "		  \"MatchApprovalLevel\": \"3 Way\",\r\n" + "		  \"PaymentCurrencyCode\": \"USD\",\r\n"
					+ "		  \"PaymentCurrency\": \"US Dollar\",\r\n" + "		  \"PaymentPriority\": 2,\r\n"
					+ "		  \"PayGroupCode\": \"DOMESTIC\",\r\n" + "		  \"PayGroup\": \"Domestic\",\r\n"
					+ "		  \"HoldAllInvoicesFlag\": true,\r\n" + "		  \"HoldUnmatchedInvoicesCode\": \"D\",\r\n"
					+ "		  \"HoldUnmatchedInvoices\": \"Default from Payables Options\",\r\n"
					+ "		  \"HoldUnvalidatedInvoicesFlag\": false,\r\n"
					+ "		  \"PaymentHoldDate\": \"2019-10-31\",\r\n"
					+ "		  \"PaymentHoldReason\": \"Test Hola All invoices\",\r\n"
					+ "		  \"PaymentTermsId\": 10045,\r\n" + "		  \"PaymentTerms\": \"1/10 NET 30\",\r\n"
					+ "		  \"PaymentTermsDateBasisCode\": \"Invoice Received\",\r\n"
					+ "		  \"PaymentTermsDateBasis\": \"Invoice received date\",\r\n"
					+ "		  \"PayDateBasisCode\": \"DISCOUNT\",\r\n" + "		  \"PayDateBasis\": \"Discount\",\r\n"
					+ "		  \"BankChargeDeductionTypeCode\": \"S\",\r\n"
					+ "		  \"BankChargeDeductionType\": \"Standard\",\r\n"
					+ "		  \"AlwaysTakeDiscountCode\": \"D\",\r\n"
					+ "		  \"AlwaysTakeDiscount\": \"Default from Payables Options\",\r\n"
					+ "		  \"ExcludeFreightFromDiscountCode\": \"Y\",\r\n"
					+ "		  \"ExcludeFreightFromDiscount\": \"Yes\",\r\n"
					+ "		  \"ExcludeTaxFromDiscountCode\": \"N\",\r\n"
					+ "		  \"ExcludeTaxFromDiscount\": \"No\",\r\n"
					+ "		  \"CreateInterestInvoicesCode\": \"N\",\r\n"
					+ "		  \"CreateInterestInvoices\": \"No\"\r\n"
					+ "		}", required = true) @RequestBody Object supplier) {
		return supplierSiteService.createSupplierSite(SupplierId, supplier);
	}

	// Update supplier site
	@PatchMapping("/suppliers/{SupplierId}/child/sites/{SupplierSiteId}")
	public ResponseEntity<Object> updateSupplierSite(
			@Parameter(description = "e.g: 300000003091951", required = true) @PathVariable("SupplierId") String SupplierId,
			@Parameter(description = "e.g:\r\n\n" + "{\r\n" + "	\"SupplierSite\": \"REST14\",\r\n"
					+ "	\"SitePurposePrimaryPayFlag\": true,\r\n"
					+ "	\"HoldAllNewPurchasingDocumentsFlag\": false,\r\n" + "	\"PurchasingHoldReason\": \"\",\r\n"
					+ "	\"RequiredAcknowledgment\": \"Document and Schedule\"\r\n"
					+ "}\r\n", required = true) @RequestBody Object supplier,
			@Parameter(description = "e.g: 300000003169026", required = true) @PathVariable("SupplierSiteId") String SupplierSiteId) {
		return supplierSiteService.updateSupplierSite(SupplierId, SupplierSiteId, supplier);
	}

	// Get List of suppliers contacts
	@GetMapping("/suppliers/{SupplierId}/child/contacts")
	public ResponseEntity<Object> getListSupplierContact(
			@Parameter(description = "e.g: 300000003091951", required = true) @PathVariable("SupplierId") String SupplierId) {
		return supplierContactService.getListSupplierContact(SupplierId);
	}

	// Get suppliers contacts by supplier number
	@GetMapping("/suppliers/{SupplierId}/child/contacts/{SupplierContactId}")
	public ResponseEntity<Object> getSupplierContactBySupplierNumber(
			@Parameter(description = "e.g: 300000003091951", required = true) @PathVariable("SupplierId") String SupplierId,
			@Parameter(description = "e.g : 300000003169065") @PathVariable("SupplierContactId") String SupplierContactId) {
		return supplierContactService.getSupplierContactById(SupplierId, SupplierContactId);

	}

	// Create supplier contacts
	@PostMapping("/suppliers/{SupplierId}/child/contacts")
	public ResponseEntity<Object> createSupplierContact(
			@Parameter(description = "e.g: 300000003091951", required = true) @PathVariable("SupplierId") String SupplierId,
			@Parameter(description = "e.g:\r\n\n" + "{\r\n" + "  \"Salutation\": \"Ms.\",\r\n"
					+ "  \"FirstName\": \"sai\",\r\n" + "  \"LastName\": \"surya\",\r\n"
					+ "  \"AdministrativeContactFlag\": true,\r\n" + "  \"MobileCountryCode\": \"91\",\r\n"
					+ "  \"MobileAreaCode\": \"650\",\r\n" + "  \"MobileNumber\": \"7036152235\"\r\n"
					+ "}") @RequestBody Object supplier) {
		return supplierContactService.createSupplierContact(SupplierId, supplier);
	}

	// Update supplier contacts
	@PatchMapping("/suppliers/{SupplierId}/child/contacts/{SupplierContactId}")
	public ResponseEntity<Object> updateSupplierContact(
			@Parameter(description = "e.g: 300000003091951", required = true) @PathVariable("SupplierId") String SupplierId,
			@Parameter(description = "e.g:\r\n\n" + "{\r\n" + "  \"Salutation\": \"Ms.\",\r\n"
					+ "  \"FirstName\": \"Jill\",\r\n" + "  \"LastName\": \"Smith\",\r\n"
					+ "  \"AdministrativeContactFlag\": true,\r\n" + "  \"MobileCountryCode\": \"1\",\r\n"
					+ "  \"MobileAreaCode\": \"650\",\r\n" + "  \"MobileNumber\": \"555-2237\"\r\n"
					+ "}") @RequestBody Object supplier,
			@Parameter(description = "e.g : 300000003169065") @PathVariable("SupplierContactId") String SupplierContactId) {
		return supplierContactService.updateSupplierContact(SupplierId, SupplierContactId, supplier);
	}

	// Get List of suppliers Address
	@GetMapping("/suppliers/{SupplierId}/child/addresses")
	public ResponseEntity<Object> getListSuppliersAddress(
			@Parameter(description = "e.g : 300000003091951") @PathVariable("SupplierId") String SupplierId) {
		return supplierAddressService.getListSupplierAddress(SupplierId);

	}

	// Get suppliers Address by Id
	@GetMapping("/suppliers/{SupplierId}/child/addresses/{SupplierAddressId}")
	public ResponseEntity<Object> getSupplierAddressById(
			@Parameter(description = "e.g: 300000003091951") @PathVariable("SupplierId") String SupplierId,
			@Parameter(description = "e.g: 300000042823316") @PathVariable("SupplierAddressId") String SupplierAddressId) {

		return supplierAddressService.getSupplierAddressById(SupplierId, SupplierAddressId);

	}

	// Create supplier Address
	@PostMapping("/suppliers/{SupplierId}/child/addresses")
	public ResponseEntity<Object> createSupplierAddress(
			@Parameter(description = "e.g:\r\n\n" + "	{\r\n" + "		   \"AddressName\": \"Headquarter Tower3\",\r\n"
					+ "		    \"Country\": \"United States\",\r\n"
					+ "		    \"AddressLine1\": \"Example Road 19990\",\r\n"
					+ "		    \"City\": \"Redwood City\",\r\n" + "		    \"State\": \"CA\",\r\n"
					+ "		    \"PostalCode\": \"94065\",\r\n" + "		    \"AddressPurposeOrderingFlag\": true,\r\n"
					+ "		    \"AddressPurposeRemitToFlag\": true,\r\n"
					+ "		    \"AddressPurposeRFQOrBiddingFlag\": false  \r\n"
					+ "		}\r\n", required = true) @RequestBody Object supplier,
			@Parameter(description = "e.g : 300000003091951") @PathVariable("SupplierId") String SupplierId) {
		return supplierAddressService.createSupplierAddress(supplier, SupplierId);
	}

	// Update supplier Address
	@PatchMapping("/suppliers/{SupplierId}/child/addresses/{SupplierAddressId}")
	public ResponseEntity<Object> updateSupplierAddress(
			@Parameter(description = "e.g:\r\n\n" + "{\r\n" + "    \"AddressName\": \"Headquaters five\",\r\n"
					+ "    \"AddressLine2\": \"Suite 1298830\",\r\n" + "    \"AddressPurposeRemitToFlag\": false\r\n"
					+ "}\r\n") @RequestBody Object supplier,
			@Parameter(description = "e.g: 300000003091951") @PathVariable("SupplierId") String SupplierId,
			@Parameter(description = "e.g: 300000042823316") @PathVariable("SupplierAddressId") String SupplierAddressId) {
		return supplierAddressService.updateSupplierAddress(supplier, SupplierId, SupplierAddressId);
	}

}
