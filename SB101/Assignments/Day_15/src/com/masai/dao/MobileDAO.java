package com.masai.dao;

import java.util.List;

import com.masai.dto.Mobile;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrong;

public interface MobileDAO {

	public void addMobile(Mobile mob) throws SomethingWentWrong;

	public void updateMobile(Mobile mob) throws SomethingWentWrong;

	public void deleteMobile(String model) throws SomethingWentWrong;

	public List<Mobile> viewMobile() throws SomethingWentWrong, NoRecordFoundException;

	public List<Mobile> searchByPriceRange(int a, int b) throws SomethingWentWrong, NoRecordFoundException;

	public List<Mobile> searchByModel(String model) throws SomethingWentWrong, NoRecordFoundException;

}
