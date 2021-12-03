package com.example.demo.repository;

import java.util.Date;

import org.springframework.dao.DataAccessException;

import com.example.demo.model.KintoreTarget;

public interface TargetDao {

	public int insertOne1(Date kigen,int ude) throws DataAccessException;

	public int insertOne2(Date kigen,int hara) throws DataAccessException;

	public int insertOne3(Date kigen,int asi) throws DataAccessException;

	public KintoreTarget selectUde() throws DataAccessException;

	public KintoreTarget selectHara() throws DataAccessException;

	public KintoreTarget selectAsi() throws DataAccessException;

}
