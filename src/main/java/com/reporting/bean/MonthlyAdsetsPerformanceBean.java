package com.reporting.bean;
import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;
@Table(value = "facebook_monthly_adsets_account_performance")
public class MonthlyAdsetsPerformanceBean {
	@PrimaryKeyColumn(name = "client_stamp", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	@Column
	private String client_stamp;
	@PrimaryKeyColumn(name = "unique_ctr", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
	@Column
	private String unique_ctr;
	@Column
	private String reporting_starts;
	@Column
	private String reporting_ends;
	@Column
	private String account_name;
	@Column
	private String account_id;
	@Column
	private String reach;
	@Column
	private String amount_spent;
	@Column
	private String link_clicks;
	@Column
	private String frequency;
	@Column
	private String impressions;
	@Column
	private String clicks;
	@Column
	private String CPC;
	@Column
	private String CTR;
	@Column
	private String adset_id;
	@Column
	private String adset_name;
	public MonthlyAdsetsPerformanceBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MonthlyAdsetsPerformanceBean(String client_stamp, String reporting_starts, String reporting_ends,
			String account_name, String account_id, String reach, String amount_spent, String link_clicks,
			String frequency, String impressions, String clicks, String cPC, String cTR, String adset_id,
			String adset_name,String unique_ctr) {
		super();
		this.client_stamp = client_stamp;
		this.reporting_starts = reporting_starts;
		this.reporting_ends = reporting_ends;
		this.account_name = account_name;
		this.account_id = account_id;
		this.reach = reach;
		this.amount_spent = amount_spent;
		this.link_clicks = link_clicks;
		this.frequency = frequency;
		this.impressions = impressions;
		this.clicks = clicks;
		CPC = cPC;
		CTR = cTR;
		this.adset_id = adset_id;
		this.adset_name = adset_name;
		this.unique_ctr=unique_ctr;
	}
	public String getClient_stamp() {
		return client_stamp;
	}
	public void setClient_stamp(String client_stamp) {
		this.client_stamp = client_stamp;
	}
	public String getUnique_ctr() {
		return unique_ctr;
	}
	public void setUnique_ctr(String unique_ctr) {
		this.unique_ctr = unique_ctr;
	}
	public String getReporting_starts() {
		return reporting_starts;
	}
	public void setReporting_starts(String reporting_starts) {
		this.reporting_starts = reporting_starts;
	}
	public String getReporting_ends() {
		return reporting_ends;
	}
	public void setReporting_ends(String reporting_ends) {
		this.reporting_ends = reporting_ends;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getReach() {
		return reach;
	}
	public void setReach(String reach) {
		this.reach = reach;
	}
	public String getAmount_spent() {
		return amount_spent;
	}
	public void setAmount_spent(String amount_spent) {
		this.amount_spent = amount_spent;
	}
	public String getLink_clicks() {
		return link_clicks;
	}
	public void setLink_clicks(String link_clicks) {
		this.link_clicks = link_clicks;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getImpressions() {
		return impressions;
	}
	public void setImpressions(String impressions) {
		this.impressions = impressions;
	}
	public String getClicks() {
		return clicks;
	}
	public void setClicks(String clicks) {
		this.clicks = clicks;
	}
	public String getCPC() {
		return CPC;
	}
	public void setCPC(String cPC) {
		CPC = cPC;
	}
	public String getCTR() {
		return CTR;
	}
	public void setCTR(String cTR) {
		CTR = cTR;
	}
	public String getAdset_id() {
		return adset_id;
	}
	public void setAdset_id(String adset_id) {
		this.adset_id = adset_id;
	}
	public String getAdset_name() {
		return adset_name;
	}
	public void setAdset_name(String adset_name) {
		this.adset_name = adset_name;
	}
	
}
