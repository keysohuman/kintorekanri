package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.KintoreTarget;
import com.example.demo.model.TargetForm;
import com.example.demo.repository.TargetDao;

@Service
public class TargetService {

	@Autowired
	TargetDao tdao;


	public void insert(TargetForm targetform) {

		int ude = targetform.getUde();
		int hara = targetform.getHara();
		int asi = targetform.getAsi();
		Date kigen = targetform.getKigen();

		System.out.println(kigen);


		if(ude>0) {
			tdao.insertOne1(kigen, ude);
		}

		if(hara>0) {
			tdao.insertOne2(kigen, hara);
		}

		if(asi>0) {
			tdao.insertOne3(kigen, asi);
		}
	}

	public KintoreTarget selectUde(){

		return tdao.selectUde();
	}

	public KintoreTarget selectHara(){

		return tdao.selectHara();
	}

	public KintoreTarget selectAsi(){

		return tdao.selectAsi();
	}

}
