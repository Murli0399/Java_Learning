package com.masai;

import java.util.HashMap;
import java.util.Map;

public final class CompanyNameCode {

	static final Map<String, String> CompanyNameCode;

	static {
		CompanyNameCode = new HashMap<>();
		CompanyNameCode.put("EKP", "Ekoplay");
		CompanyNameCode.put("EXP", "Explore");
		CompanyNameCode.put("FSK", "Funskool");
		CompanyNameCode.put("NKT", "Natkhat");
		CompanyNameCode.put("SLD", "Sunlord");
		CompanyNameCode.put("TZN", "ToyZone");
	}

}
