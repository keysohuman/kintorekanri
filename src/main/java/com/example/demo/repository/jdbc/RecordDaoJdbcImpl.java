package com.example.demo.repository.jdbc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.KintoreRecord;
import com.example.demo.repository.RecordDao;

@Repository
public class RecordDaoJdbcImpl implements RecordDao {

	@Autowired
	JdbcTemplate jdbc;


	@Override
	public int insertRecord1(int ude) throws DataAccessException{

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy,MM,dd");
		Date day = new Date();
		String today = sdf.format(day);

		List<Map<String, Object>> serchList  = jdbc.queryForList("select * from record where event='腕立て' AND day=?"
				, today);
		System.out.println("serchList:" + serchList.size() + today);


		if(serchList.size()==0) {
		int recordNumber = jdbc.update("INSERT INTO record(event, count, day) VALUES(?,?,?)"
				, "腕立て"
				, ude
				, today
				);
		return recordNumber;
		}else {

		int recordNumber = jdbc.update("UPDATE record SET count=? WHERE event='腕立て' AND day=?"
				, ude
				, today);

		return recordNumber;

		}
	}


	@Override
	public int insertRecord2(int hara) throws DataAccessException{

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy,MM,dd");
		Date day = new Date();
		String today = sdf.format(day);


		List<Map<String, Object>> serchList  = jdbc.queryForList("select * from record where event='腹筋' AND day=?"
				, today);


		if(serchList.size()==0) {
		int recordNumber = jdbc.update("INSERT INTO record(event, count, day) VALUES(?,?,?)"
				, "腹筋"
				, hara
				, today
				);
		return recordNumber;
		}else {

		int recordNumber = jdbc.update("UPDATE record SET count=? WHERE event='腹筋' AND day=?"
				, hara
				, today);

		return recordNumber;

		}
	}


	@Override
	public int insertRecord3(int asi) throws DataAccessException{

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy,MM,dd");
		Date day = new Date();
		String today = sdf.format(day);



		List<Map<String, Object>> serchList  = jdbc.queryForList("select * from record where event='スクワット' AND day=?"
				, today);


		if(serchList.size()==0) {
		int recordNumber = jdbc.update("INSERT INTO record(event, count, day) VALUES(?,?,?)"
				, "スクワット"
				, asi
				, today
				);
		return recordNumber;
		}else {

		int recordNumber = jdbc.update("UPDATE record SET count=? WHERE event='スクワット' AND day=?"
				, asi
				, today);

		return recordNumber;

		}
	}

	@Override
	public List<KintoreRecord> selectAll() throws DataAccessException{


		List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM record");

		List<KintoreRecord> recordList = new ArrayList<>();


		for (Map<String, Object> map:getList) {

			KintoreRecord record = new KintoreRecord();

			record.setEvent((String)map.get("event"));
			record.setCount((Integer)map.get("count"));
			record.setDay((Date)map.get("day"));

			recordList.add(record);
		}

		return recordList;
	}

	@Override
	public int selectUde() throws DataAccessException{

		List<Map<String, Object>> udeList = jdbc.queryForList("SELECT count FROM record WHERE event='腕立て'");

		//List<KintoreRecord> countList = new ArrayList<>();
		int udeCount = 0;


		for (Map<String, Object> map:udeList) {

			udeCount = udeCount +(Integer)map.get("count");
		}

		return udeCount;
	}

	@Override
	public int selectHara() throws DataAccessException{

		List<Map<String, Object>> udeList = jdbc.queryForList("SELECT count FROM record WHERE event='腹筋'");

		int haraCount = 0;


		for (Map<String, Object> map:udeList) {

			haraCount = haraCount + (Integer)map.get("count");
		}

		return haraCount;
	}


	@Override
	public int selectAsi() throws DataAccessException{

		List<Map<String, Object>> udeList = jdbc.queryForList("SELECT count FROM record WHERE event='スクワット'");

		int asiCount = 0;


		for (Map<String, Object> map:udeList) {

			asiCount = asiCount + (Integer)map.get("count");
		}

		return asiCount;
	}

}
