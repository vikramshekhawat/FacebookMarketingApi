package com.reporting.FacebookAds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.reporting.Enviornment.EnvironmentClass;
import com.reporting.bean.AccountPerformanceBean;
import com.reporting.bean.MonthlyAdAccountPerformanceBean;
import com.reporting.bean.WeeklyAdAccountPerformanceBean;
import com.reporting.dao.CassandraDao;
import com.reporting.daoImpl.AllClientInforNeededDaoImpl;
import com.reporting.daoImpl.CassandraCRUDImpl;

public class App {

	public static void main(String[] args) {
		AbstractApplicationContext context = null;
		CassandraCRUDImpl daos = null;

		try {
			context = new ClassPathXmlApplicationContext("spring.xml");

			context.registerShutdownHook();

			AllClientInforNeededDaoImpl information = context.getBean("dao", AllClientInforNeededDaoImpl.class);
			EnvironmentClass env = context.getBean("envBean", EnvironmentClass.class);
			daos = context.getBean("daoCassendra", CassandraCRUDImpl.class);
			//CassandraDao daoObject=new CassandraCRUDImpl();
			List<Map<String, Object>> value = information.getAllClientInfo();
			//List<AccountPerformanceBean> dailyAccountValues = new ArrayList<AccountPerformanceBean>();
//List<WeeklyAdAccountPerformanceBean> weeklyAdAccount=new ArrayList<WeeklyAdAccountPerformanceBean>();
//List<MonthlyAdAccountPerformanceBean> monthlyAdAccount=new ArrayList<MonthlyAdAccountPerformanceBean>();
			if (value.size() > 0) {

				String accessToken = (String) value.get(0).get(env.getDataFromPropertyFile("access_token_column"));
				for (int i = 0; i < value.size(); i++) {
					String account_id = (String) value.get(i).get(env.getDataFromPropertyFile("account_id_column"));
					String client_stamp = (String) value.get(i).get(env.getDataFromPropertyFile("client_stamp_column"));

//					URL url = new URL("https://graph.facebook.com/v2.10/act_" + account_id
//							+ "/insights?fields=cpc,ctr,account_id,account_name,clicks,date_start,date_stop,impressions,"
//							+ "frequency,inline_link_clicks,spend,social_reach,website_ctr,website_purchase_roas&&level=account&date_preset=yesterday"
//							+ "&access_token=" + accessToken);
//
//					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//					conn.setRequestMethod("GET");
//					conn.setRequestProperty("Accept", "application/json");
//
//					if (conn.getResponseCode() != 200) {
//						throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
//					}
//					BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
//
//					String output = "", full = "";
//					JSONObject result1;
//					while ((output = br.readLine()) != null) {
//						System.out.println(output);
//						full += output;
//						JSONObject JObject = new JSONObject(output);
//						JSONArray result = JObject.getJSONArray("data");
//						result1 = result.getJSONObject(0);
//
//						AccountPerformanceBean addAdAccountData = new AccountPerformanceBean(
//								result1.getString("date_start"), result1.getString("date_stop"),
//								result1.getString("account_name"), result1.getString("account_id"),
//								result1.getString("social_reach"), result1.getString("spend"),
//								result1.getString("inline_link_clicks"), result1.getString("frequency"),
//								result1.getString("impressions"), result1.getString("clicks"), result1.getString("cpc"),
//								result1.getString("ctr"), client_stamp);
//						dailyAccountValues.add(addAdAccountData);

			//	}
					
					// ad Account for weekly
				daos.writeAccountDataToCassandraDaily(accessToken, account_id, client_stamp);
				daos.writeAccountDataToCassandraWeekly(accessToken, account_id, client_stamp);
				daos.writeAccountDataToCassandraMonthly(accessToken, account_id, client_stamp);
					
//					URL Weekly_url = new URL("https://graph.facebook.com/v2.10/act_" + account_id
//							+ "/insights?fields=cpc,ctr,account_id,account_name,clicks,date_start,date_stop,impressions,"
//							+ "frequency,inline_link_clicks,spend,social_reach,website_ctr,website_purchase_roas&level=account&date_preset=last_week_mon_sun"
//							+ "&access_token=" + accessToken);
//
//					HttpURLConnection weekly_conn = (HttpURLConnection) Weekly_url.openConnection();
//					weekly_conn.setRequestMethod("GET");
//					weekly_conn.setRequestProperty("Accept", "application/json");
//
//					if (weekly_conn.getResponseCode() != 200) {
//						throw new RuntimeException("Failed : HTTP error code : " + weekly_conn.getResponseCode());
//					}
//					BufferedReader Weekly_br = new BufferedReader(new InputStreamReader((weekly_conn.getInputStream())));
//
//					String weeklyOutput = "", data = "";
//					JSONObject weekly_result;
//					while ((weeklyOutput = Weekly_br.readLine()) != null) {
//						System.out.println(weeklyOutput);
//						data += weeklyOutput;
//						JSONObject WeeklyJObject = new JSONObject(weeklyOutput);
//						JSONArray Weeklyresult = WeeklyJObject.getJSONArray("data");
//						weekly_result = Weeklyresult.getJSONObject(0);
//					
//						WeeklyAdAccountPerformanceBean addWeekly=new WeeklyAdAccountPerformanceBean(
//								weekly_result.getString("date_start"), weekly_result.getString("date_stop"),
//								weekly_result.getString("account_name"), weekly_result.getString("account_id"),
//								weekly_result.getString("social_reach"), weekly_result.getString("spend"),
//								weekly_result.getString("inline_link_clicks"), weekly_result.getString("frequency"),
//								weekly_result.getString("impressions"), weekly_result.getString("clicks"), weekly_result.getString("cpc"),
//								weekly_result.getString("ctr"), client_stamp);
//						weeklyAdAccount.add(addWeekly);
//					}
//				
//				
				
				
				//monthly ad account
//					URL Monthly_url = new URL("https://graph.facebook.com/v2.10/act_" + account_id
//							+ "/insights?fields=cpc,ctr,account_id,account_name,clicks,date_start,date_stop,impressions,"
//							+ "frequency,inline_link_clicks,spend,social_reach,website_ctr,website_purchase_roas&level=account&date_preset=last_month"
//							+ "&access_token=" + accessToken);
//
//					HttpURLConnection monthly_conn = (HttpURLConnection) Monthly_url.openConnection();
//					monthly_conn.setRequestMethod("GET");
//					monthly_conn.setRequestProperty("Accept", "application/json");
//
//					if (monthly_conn.getResponseCode() != 200) {
//						throw new RuntimeException("Failed : HTTP error code : " + monthly_conn.getResponseCode());
//					}
//					BufferedReader monthly_br = new BufferedReader(new InputStreamReader((monthly_conn.getInputStream())));
//
//					String monthlyOutput = "", monthlydata = "";
//					JSONObject monthly_result;
//					while ((monthlyOutput = monthly_br.readLine()) != null) {
//						System.out.println(monthlyOutput);
//						data += monthlyOutput;
//						JSONObject MonthlyJObject = new JSONObject(monthlyOutput);
//						JSONArray Monthlyresult = MonthlyJObject.getJSONArray("data");
//						monthly_result = Monthlyresult.getJSONObject(0);
//					
//						MonthlyAdAccountPerformanceBean addMonthly=new MonthlyAdAccountPerformanceBean(
//								monthly_result.getString("date_start"), monthly_result.getString("date_stop"),
//								monthly_result.getString("account_name"), monthly_result.getString("account_id"),
//								monthly_result.getString("social_reach"), monthly_result.getString("spend"),
//								monthly_result.getString("inline_link_clicks"), monthly_result.getString("frequency"),
//								monthly_result.getString("impressions"), monthly_result.getString("clicks"), monthly_result.getString("cpc"),
//								monthly_result.getString("ctr"), client_stamp);
//						monthlyAdAccount.add(addMonthly);
//					}
//					
				// Daily campaign data
//					URL Daily_Campaign_url = new URL("https://graph.facebook.com/v2.10/act_" + account_id
//							+ "/insights?fields=cpc,ctr,account_id,account_name,clicks,date_start,date_stop,impressions,"
//							+ "frequency,inline_link_clicks,spend,social_reach,website_ctr,website_purchase_roas&level=account&date_preset=last_month"
//							+ "&access_token=" + accessToken);
//
//					HttpURLConnection dailyCamp_conn = (HttpURLConnection) Daily_Campaign_url.openConnection();
//					monthly_conn.setRequestMethod("GET");
//					monthly_conn.setRequestProperty("Accept", "application/json");
//
//					if (monthly_conn.getResponseCode() != 200) {
//						throw new RuntimeException("Failed : HTTP error code : " + monthly_conn.getResponseCode());
//					}
//					BufferedReader monthly_br = new BufferedReader(new InputStreamReader((monthly_conn.getInputStream())));
//
//					String monthlyOutput = "", monthlydata = "";
//					JSONObject monthly_result;
//					while ((monthlyOutput = monthly_br.readLine()) != null) {
//						System.out.println(monthlyOutput);
//						data += monthlyOutput;
//						JSONObject MonthlyJObject = new JSONObject(monthlyOutput);
//						JSONArray Monthlyresult = MonthlyJObject.getJSONArray("data");
//						monthly_result = Monthlyresult.getJSONObject(0);
//					
//						MonthlyAdAccountPerformanceBean addMonthly=new MonthlyAdAccountPerformanceBean(
//								monthly_result.getString("date_start"), monthly_result.getString("date_stop"),
//								monthly_result.getString("account_name"), monthly_result.getString("account_id"),
//								monthly_result.getString("social_reach"), monthly_result.getString("spend"),
//								monthly_result.getString("inline_link_clicks"), monthly_result.getString("frequency"),
//								monthly_result.getString("impressions"), monthly_result.getString("clicks"), monthly_result.getString("cpc"),
//								monthly_result.getString("ctr"), client_stamp);
//						monthlyAdAccount.add(addMonthly);
//					}
//					
					
					
					
					

			}}
			daos.getConection();
			

				daos.dataAddToCassandra();
			

				
			
			
			
				
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}

	}
}
