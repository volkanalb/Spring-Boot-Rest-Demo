package com.vvv.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vvv.demo.model.DataModel;
import com.vvv.demo.model.exception.DataNotFoundException;

@Service
public class DataModelService implements IDataModelService {

	private Map<Integer, DataModel> modelRepo = new HashMap<Integer, DataModel>();

	@Override
	public List<DataModel> findAll() {
		return modelRepo.values().stream().collect(Collectors.toList());
	}

	@Override
	public DataModel findOne(Integer id) throws DataNotFoundException {
		if (modelRepo.containsKey(id))
			return modelRepo.get(id);
		throw new DataNotFoundException(id);
	}

	@Override
	public void insert(DataModel dataModel) {
		modelRepo.put(dataModel.getId(), dataModel);

	}

	@Override
	public void delete(Integer id) throws DataNotFoundException {
		if (modelRepo.containsKey(id))
			modelRepo.remove(id);
		else
			throw new DataNotFoundException(id);

	}

}
