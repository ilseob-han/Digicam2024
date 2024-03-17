
public class SalaryDaily extends SalaryWorkInfo {

	private double dailySalary;
	private double nightSalary;
	private double holydaySalary;	
	private double dailyTotal;
	private String nameYyyyMm;
	private String yyyyMm;
	private String yyyy;

	
	
	public String getNameYyyyMm() {
		return nameYyyyMm;
	}

	public void setNameYyyyMm(String nameYyyyMm) {
		this.nameYyyyMm = nameYyyyMm;
	}

	public double getDailyTotal() {
		return dailyTotal;
	}

	public void setDailyTotal(double dailyTotal) {
		this.dailyTotal = dailyTotal;
	}

	public String getYyyyMm() {
		return yyyyMm;
	}

	public void setYyyyMm(String yyyyMm) {
		this.yyyyMm = yyyyMm;
	}

	public String getYyyy() {
		return yyyy;
	}

	public void setYyyy(String yyyy) {
		this.yyyy = yyyy;
	}

	public double getDailySalary() {
		return dailySalary;
	}

	public void setDailySalary(double dailySalary) {
		this.dailySalary = dailySalary;
	}

	public double getNightSalary() {
		return nightSalary;
	}

	public void setNightSalary(double nightSalary) {
		this.nightSalary = nightSalary;
	}

	public double getHolydaySalary() {
		return holydaySalary;
	}

	public void setHolydaySalary(double holydaySalary) {
		this.holydaySalary = holydaySalary;

	}
}