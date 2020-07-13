package com.vvv.demo.service;

import java.util.List;

import com.vvv.demo.model.DataModel;
import com.vvv.demo.model.exception.DataNotFoundException;

public interface IDataModelService {

	List<DataModel> findAll();

	DataModel findOne(Integer Id) throws DataNotFoundException;

	void insert(DataModel dataModel);

	void delete(Integer id) throws DataNotFoundException;
}
