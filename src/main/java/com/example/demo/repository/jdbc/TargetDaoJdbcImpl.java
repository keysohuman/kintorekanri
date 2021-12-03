package com.example.demo.repository.jdbc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.KintoreTarget;
import com.example.demo.repository.TargetDao;

@Repository
public class TargetDaoJdbcImpl implements TargetDao {


	@Autowired
	JdbcTemplate jdbc;


	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date day = new Date();
	String today = sdf.format(day);



	@Override
	public int insertOne1(Date kigen,int ude) throws DataAccessException {


		List<Map<String, Object>> serchList  = jdbc.queryForList("select * from target where event='腕立て'");


		if(serchList.size()==0) {

			int TargetNumber = jdbc.update("INSERT INTO target(event, count, term, rdate) VALUES (?,?,?,?)"
					,"腕立て"
					,ude
					,kigen
					,today);


			return TargetNumber;

		}else {

			int TargetNumber = jdbc.update("UPDATE target SET count=? ,term=?, rdate=? WHERE event='腕立て'"
					,ude
					,kigen
					,today);


			return TargetNumber;
		}


	}


	@Override
	public int insertOne2(Date kigen,int hara) throws DataAccessException {




		List<Map<String, Object>> serchList  = jdbc.queryForList("select * from target where event='腕立て'");


		if(serchList.size()==0) {

			int TargetNumber = jdbc.update("INSERT INTO target(event, count, term, rdate) VALUES (?,?,?,?)"
					,"腹筋"
					,hara
					,kigen
					,today);


			return TargetNumber;

		}else {

			int TargetNumber = jdbc.update("UPDATE target SET count=? ,term=?, rdate=? WHERE event='腹筋'"
					,hara
					,kigen
					,today);


			return TargetNumber;
		}
	}


	@Override
	public int insertOne3(Date kigen,int asi) throws DataAccessException {


		List<Map<String, Object>> serchList  = jdbc.queryForList("select * from target where event='腕立て'");


		if(serchList.size()==0) {

			int TargetNumber = jdbc.update("INSERT INTO target(event, count, term, rdate) VALUES (?,?,?,?)"
					,"スクワット"
					,asi
					,kigen
					,today);


			return TargetNumber;

		}else {

			int TargetNumber = jdbc.update("UPDATE target SET count=? ,term=?, rdate=? WHERE event='スクワット'"
					,asi
					,kigen
					,today);


			return TargetNumber;
		}

	}

	@Override
	public KintoreTarget selectUde() throws DataAccessException {


		Map<String, Object> map = jdbc.queryForMap("SELECT event, count, term FROM target WHERE event='腕立て'");

			KintoreTarget target = new KintoreTarget();

			target.setEvent((String)map.get("event"));
			target.setCount((Integer)map.get("count"));
			target.setTerm((Date)map.get("term"));



		return target;
	}

	@Override
	public KintoreTarget selectHara() throws DataAccessException {


		Map<String, Object> map = jdbc.queryForMap("SELECT event, count, term FROM target WHERE event='腹筋'");

			KintoreTarget target2 = new KintoreTarget();

			target2.setEvent((String)map.get("event"));
			target2.setCount((Integer)map.get("count"));
			target2.setTerm((Date)map.get("term"));



		return target2;
	}

	@Override
	public KintoreTarget selectAsi() throws DataAccessException {

		Map<String, Object> map = jdbc.queryForMap("SELECT event, count, term FROM target WHERE event='スクワット'");


			KintoreTarget target3 = new KintoreTarget();

			target3.setEvent((String)map.get("event"));
			target3.setCount((Integer)map.get("count"));
			target3.setTerm((Date)map.get("term"));



		return target3;
	}

}
