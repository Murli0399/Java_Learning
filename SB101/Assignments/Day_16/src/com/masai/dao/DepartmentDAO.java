package com.masai.dao;

import java.util.List;

import com.masai.dto.DepartmentDTO;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrong;

public interface DepartmentDAO {
	public void addDepartment(DepartmentDTO depDto) throws SomethingWentWrong;
	public void deleteDepartment(int id) throws SomethingWentWrong;
	public List<DepartmentDTO> viewDepartment() throws SomethingWentWrong, NoRecordFoundException;
}
