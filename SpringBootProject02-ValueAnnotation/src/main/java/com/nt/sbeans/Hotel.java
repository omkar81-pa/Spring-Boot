package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("hotel")
public class Hotel {

	@Value("12345")
	private Integer hotelId;

	@Value("${hotel.name}")
	private String hotelName;

	@Value("${hotel.addrs}")
	private String hotelAddrs;

	@Value("${hotel.contactno}")
	private String mobileNo;

	@Value("${customer.name}")
	private String custName;

	@Value("#{menup.idlyPrice + menup.dosaPrice}")
	private Float billAmount;

	@Value("${os.name}")
	private String osName;

	@Value("${user.name}")
	private String windowsUser;

	@Value("${Path}")
	private String pathData;

	@Override
	public String toString() {
		return "Hotal [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelAddrs=" + hotelAddrs + ", mobileNo="
				+ mobileNo + ", custName=" + custName + ", billAmount=" + billAmount + ", osName=" + osName
				+ ", windowsUser=" + windowsUser + ", pathData=" + pathData + "]";
	}
}
