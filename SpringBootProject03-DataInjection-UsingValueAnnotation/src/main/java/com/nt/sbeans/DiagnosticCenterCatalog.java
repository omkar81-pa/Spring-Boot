package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("dcc")
@Data
public class DiagnosticCenterCatalog {

	@Value("${dc.xrayPrice}")
	private Double xrayPrice;

	@Value("${dc.ctscanPrice}")
	private Double ctscanPrice;

	@Value("${dc.mriScanPrice}")
	private Double mriScanPrice;

	@Value("${dc.ecgPrice}")
	private Double ecgPrice;
}
