package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("menup")
@Data
public class MenuItemPrices {
	
	@Value("${menue.dosarate}")
	private Float dosaPrice;
	
	@Value("${menue.idlyrate}")
	private Float idlyPrice;
	
	@Value("${menue.poharate}")
	private Float poharate;
	
	@Value("${menue.vprate}")
	private Float vadaPavPrice;
	
}
