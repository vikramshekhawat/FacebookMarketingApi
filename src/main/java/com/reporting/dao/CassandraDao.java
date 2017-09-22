package com.reporting.dao;

import java.io.IOException;
import java.util.List;

import com.reporting.bean.AccountPerformanceBean;

public interface CassandraDao {

	public void writeAccountDataToCassandraDaily(String account_id,String accessToken,String client_stamp) throws IOException;
	
	public void writeAccountDataToCassandraWeekly(String accessToken,String account_id,String client_stamp)  throws IOException;

	public void writeAccountDataToCassandraMonthly(String accessToken,String account_id,String client_stamp) throws IOException;

}
		

