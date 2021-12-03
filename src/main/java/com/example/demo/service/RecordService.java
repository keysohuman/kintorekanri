package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.KintoreRecord;
import com.example.demo.model.RecordForm;
import com.example.demo.repository.RecordDao;

@Service
public class RecordService {

	@Autowired
	RecordDao rdao;


	public void insert(RecordForm recordform) {

		int ude = recordform.getUde();
		int hara = recordform.getHara();
		int asi = recordform.getAsi();

		if(ude>0) {
		 rdao.insertRecord1(ude);

		}



		if(hara>0) {
		 rdao.insertRecord2(hara);

		}

		if(asi>0) {


		 rdao.insertRecord3(asi);

		}
	}

	public List<KintoreRecord> selectAll(){

		return rdao.selectAll();
	}

	public int selectUde(){

		return rdao.selectUde();
	}

public int selectHara(){

		return rdao.selectHara();
	}

public int selectAsi(){

	return rdao.selectAsi();
}

}
