package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("pInfo")
@Data
public class PatientInfo {

	@Value("10001")
	private Integer pid;

	@Value("${pi.name}")
	private String pname;

	@Value("${pi.mobileNo}")
	private Long mobileNo;

	@Value("${pi.addrs}")
	private String paddrs;

	// Corrected SpEL reference
	@Value("#{dcc.xrayPrice + dcc.ctscanPrice + dcc.ecgPrice + dcc.mriScanPrice}")
	private Double billamount;

	@Value("#{dcc.ecgPrice <= 0}")
	private Boolean ecgFree;

	@Value("${os.name}")
	private String osName;

	@Value("${Path}")
	private String pathData;

	@Override
	public String toString() {
		return "PatientInfo [pid=" + pid + ", pname=" + pname + ", mobileNo=" + mobileNo + ", paddrs=" + paddrs
				+ ", billamount=" + billamount + ", ecgFree=" + ecgFree + ", osName=" + osName + ", pathData="
				+ pathData + "]";
	}
}
