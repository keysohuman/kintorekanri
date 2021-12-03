package com.example.demo.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.model.KintoreRecord;

public interface RecordDao {


	public int insertRecord1(int ude) throws DataAccessException;

	public int insertRecord2(int hara) throws DataAccessException;

	public int insertRecord3(int asi) throws DataAccessException;


	public List<KintoreRecord> selectAll() throws DataAccessException;

	public int selectUde() throws DataAccessException;

	public int selectHara() throws DataAccessException;

	public int selectAsi() throws DataAccessException;

}
