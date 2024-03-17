
public class SalaryYearly extends SalaryWorkInfo {
	
	private double monthlySalary;
	private double monthlyNightSalary;
	private double monthlyHolydaySalary;
	private double totalMonthlySalary;

	private String yyyy;
	

	public double getTotalMonthlySalary() {
		return totalMonthlySalary;
	}
	public void setTotalMonthlySalary(double totalMonthlySalary) {
		this.totalMonthlySalary = totalMonthlySalary;
	}
	public double getMonthlySalary() {
		return monthlySalary;
	}
	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	public double getMonthlyNightSalary() {
		return monthlyNightSalary;
	}
	public void setMonthlyNightSalary(double monthlyNightSalary) {
		this.monthlyNightSalary = monthlyNightSalary;
	}
	public double getMonthlyHolydaySalary() {
		return monthlyHolydaySalary;
	}
	public void setMonthlyHolydaySalary(double monthlyHolydaySalary) {
		this.monthlyHolydaySalary = monthlyHolydaySalary;
	}
	public String getYyyy() {
		return yyyy;
	}
	public void setYyyy(String yyyy) {
		this.yyyy = yyyy;
	}
	
}
