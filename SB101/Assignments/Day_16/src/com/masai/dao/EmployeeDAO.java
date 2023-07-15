package com.masai.dao;

import java.util.List;

import com.masai.dto.EmployeeDTO;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrong;

public interface EmployeeDAO {

	public void addEmployee(EmployeeDTO empDto) throws SomethingWentWrong;

	public List<EmployeeDTO> viewEmployeeAccount() throws SomethingWentWrong , NoRecordFoundException;

}
