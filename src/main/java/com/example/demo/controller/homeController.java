package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.method;
import com.example.demo.model.KintoreRecord;
import com.example.demo.model.KintoreTarget;
import com.example.demo.service.RecordService;
import com.example.demo.service.TargetService;

@Controller
public class homeController {

	@Autowired
	RecordService recordservice;

	@Autowired
	TargetService targetservice;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	Date day = new Date();
	String today = sdf.format(day);

	@GetMapping("/home")
	public String getHome(Model model) {

		List<KintoreRecord> recordList = recordservice.selectAll();

		model.addAttribute("recordList", recordList);

		int udeCount = recordservice.selectUde();

		model.addAttribute("udecount", udeCount);

		int haraCount = recordservice.selectHara();

		model.addAttribute("haracount", haraCount);

		int asiCount = recordservice.selectAsi();

		model.addAttribute("asicount", asiCount);




		KintoreTarget target1 = targetservice.selectUde();

		int targetdiff1 =target1.getCount() -udeCount;

		model.addAttribute("udeTarget", targetdiff1);


		Date day = target1.getTerm();

		int term = method.dateDiff(today, day);

		String str1 ="期間終了";

		if(term>=0) {

		str1 = term + "日";

		}


		model.addAttribute("term1",str1);

		KintoreTarget target2 = targetservice.selectHara();

		int targetdiff2 =target2.getCount() -haraCount;

		model.addAttribute("haraTarget", targetdiff2);

		Date day2 = target2.getTerm();

		int term2 = method.dateDiff(today, day2);

		String str2 ="期間終了";

		if(term>=0) {

		str2 = term2 + "日";

		}

		model.addAttribute("term2",str2);

		KintoreTarget target3 = targetservice.selectAsi();

		int targetdiff3 =target3.getCount() -asiCount;

		model.addAttribute("asiTarget", targetdiff3);

		Date day3 = target3.getTerm();

		int term3 = method.dateDiff(today, day3);

		String str3 ="期間終了";

		if(term>=0) {

		str3 = term3 + "日";

		}

		model.addAttribute("term3",str3);


		int udeAc = (int) Math.floor(target1.getCount() / udeCount);

		model.addAttribute("udeAc",udeAc);

		return "home";
	}

}
