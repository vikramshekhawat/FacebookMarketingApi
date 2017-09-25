package com.reporting.bean;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;
@Table(value = "facebook_daily_campaign_account_performance")
public class DailyCampaignPerformanceBean {
	@PrimaryKeyColumn(name = "client_stamp", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	@Column
	private String client_stamp;
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
	private String campaign_id;
	@Column
	private String campaign_name;
	public DailyCampaignPerformanceBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DailyCampaignPerformanceBean(String client_stamp, String reporting_starts, String reporting_ends,
			String account_name, String account_id, String reach, String amount_spent, String link_clicks,
			String frequency, String impressions, String clicks, String CPC, String CTR, String campaign_id,
			String campaign_name) {
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
		this.CPC = CPC;
		this.CTR = CTR;
		this.campaign_id = campaign_id;
		this.campaign_name = campaign_name;
	}
	
	
	

}
