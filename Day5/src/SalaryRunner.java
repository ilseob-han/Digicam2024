import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SalaryRunner {

	public static int numReturn() {
		Scanner sc = new Scanner(System.in);
		int tempNo = sc.nextInt();
		return tempNo;
	}

	public static Float floatReturn() {
		Scanner sc = new Scanner(System.in);
		float tempNo = sc.nextFloat();
		return tempNo;
	}

	public static String stringReturn() {
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}

	public static int randomReturn(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("최소값은 최대값보다 작아야 합니다.");
		}

		return (int) (Math.random() * (max - min + 1)) + min;
	}

	public static void main(String[] args) {
		int SumNoEmp = 0;
		int stop, baseSalary;
		int date, empNo;
		String name;
		System.out.println("급여 시스템을 시작합니다.");

		SalaryInfoTable[][][] table = new SalaryInfoTable[30][5][5];
		SalaryDaily[] day = new SalaryDaily[20000];
		SalaryMonthly[] month = new SalaryMonthly[20000];
		SalaryYearly[] year = new SalaryYearly[20000];

		do {

			// do while 시작

			System.out.println("기준일을 입력하세요(YYYYMMDD)");
			date = numReturn(); // numReturn(); // 기준일
			System.out.println("해당일 근무 직원수를 입력하세요");
			empNo = numReturn(); // numReturn(); // 직원 수

			// for 구문 직원 정보 입력
			System.out.println("(" + date + ")" + "해당일 근무 직원 정보를 불러옵니다.");
			System.out.println("************************");
			for (int i = SumNoEmp; i < SumNoEmp + empNo; i++) {

				day[i] = new SalaryDaily(); // 객체생성
				month[i] = new SalaryMonthly();
				year[i] = new SalaryYearly();

				day[i].setSumNoEmp(SumNoEmp + empNo);
				day[i].setWorkDate(randomReturn(20240101, 20241231));
				day[i].setPinNo(0);
				day[i].setName("직원" + i);
				day[i].setJoindate("2023-01-01");
				day[i].setWorkYear(randomReturn(1, 4)); // 1~4까지 랜덤 값 입력
				day[i].setEmptype(randomReturn(1, 4)); // 1~4까지 랜덤 값 입력
				day[i].setAnniversary("2023-01-01");
				day[i].setMatebirth("2023-01-01");
				day[i].setParentbirth("2023-01-01");
				day[i].setGrade(randomReturn(1, 4)); // 1~4까지 랜덤 값 입력
				day[i].setSalaryday(date);
				day[i].setSalarybank("국민");
				day[i].setSalaryaccount("27121******2548");
				day[i].setWiDate(date);
				day[i].setWiPin(0);
				day[i].setDayworktime(randomReturn(1, 8)); // 1~8까지 랜덤 값 입력;
				day[i].setNightworktime(randomReturn(1, 4)); // 1~4까지 랜덤 값 입력;
				day[i].setHoildyworktime(randomReturn(1, 4)); // 1~8까지 랜덤 값 입력;
				day[i].setYyyyMm(Integer.toString(date).substring(0, 6));
				day[i].setYyyy(Integer.toString(date).substring(0, 4));

			}

			// for 구문 직원 정보 입력 종료

			// 직원정보 출력 for 문시작

			// 직원 정보 수정시작

			System.out.println("해당일 직원 정보를 수정하겠습니까?(예:1/ 아니오:2)");

			stop = numReturn();

			if (stop == 1) {
				System.out.println("직원이름을 입력하세요.");
				name = stringReturn();
				for (int i = SumNoEmp; i < SumNoEmp + empNo; i++) {
					if (day[i].getName().equals(name)) {

						System.out.println(i);
						System.out.println("변경 후 입사일 입력");
						day[i].setJoindate(stringReturn());
						System.out.println("변경 후 직원 형태 입력");
						day[i].setEmptype(randomReturn(1, 4)); // 1~4까지 랜덤 값 입력
						System.out.println("변경 후 성과등급 입력");
						day[i].setGrade(numReturn());
						System.out.println("변경 후 정규 근무시간 입력");
						day[i].setDayworktime(numReturn());
						System.out.println("변경 후 야근 근무시간 입력");
						day[i].setNightworktime(numReturn());
						System.out.println("변경 후 주말 근무시간 입력");
						day[i].setHoildyworktime(numReturn());

					}
				}
			}
			// 직원 정보 수정종료

			
			// for 구문 시급 정보 입력 시작

			System.out.println("해당일 시급 정보를 작성합니다.");
			System.out.println("해당일 기본시급을 입력해주세요.");

			baseSalary = numReturn(); // // 기본 시급입력

			for (int i = 0; i < 30; i++) { // i는 연차
				for (int j = 0; j < 5; j++) { // j는 평가등급
					for (int k = 0; k < 5; k++) // k는 직급
					{
						double multiplier = (1 + (i * 0.2)) * (1 + (j * 0.2)) * (1 + (k * 0.2));
						table[i][j][k] = new SalaryInfoTable(); // 객체생성

						table[i][j][k].setSalaryDayWork(multiplier * baseSalary);
						table[i][j][k].setSalaryNightWork(multiplier * baseSalary * 1.5);
						table[i][j][k].setSalaryHolidayWork(multiplier * baseSalary * 1.8);

					}
				}

			}
			// for 구문 시급 정보 입력 종료

			// 기본시급 정보 조회 if 문 시작
			System.out.println("해당일 시급 정보를 조회하겠습니까?(예:1/ 아니오:2)");
			stop = numReturn(); // numReturn(); // 기본 시급입력
			if (stop == 1) {

				for (int i = 0; i < 5; i++) { // i는 연차
					for (int j = 0; j < 5; j++) { // j는 평가등급
						for (int k = 0; k < 5; k++) // k는 직급
						{
							System.out.println((i + 1) + "년차/" + (j + 1) + "평가등급/" + (k + 1) + "직급(정규시급) :"
									+ table[i][j][k].getSalaryDayWork());
							System.out.println((i + 1) + "년차/" + (j + 1) + "평가등급/" + (k + 1) + "직급(야근시급) :"
									+ table[i][j][k].getSalaryNightWork());
							System.out.println((i + 1) + "년차/" + (j + 1) + "평가등급/" + (k + 1) + "직급(주말시급) :"
									+ table[i][j][k].getSalaryHolidayWork());
							System.out.println("************************");
						}
					}

				}
			}

			// 기본시급 정보 조회 if 문 종료

			// 일일급여 데이터 생성 시작
			System.out.println("입력한 데이터를 바탕으로 일일 급여 데이터를 생성하시겠습니까?(예:1/ 아니오:2)");
			stop = numReturn(); // numReturn(); // 기본 시급입력
			if (stop == 1) {

				for (int x = SumNoEmp; x < SumNoEmp + empNo; x++) {

					int i = day[x].getWorkYear() - 1; // 1~30년까지
					int j = day[x].getEmptype() - 1; // 1~5등급까지
					int k = day[x].getGrade() - 1; // 1~5등급까지

					day[x].setDailySalary(day[x].getDayworktime() * table[i][j][k].getSalaryDayWork()); // 기본시급*근무시간
					day[x].setNightSalary(day[x].getNightworktime() * table[i][j][k].getSalaryNightWork()); // 야근시급*근무시간
					day[x].setHolydaySalary(day[x].getHoildyworktime() * table[i][j][k].getSalaryHolidayWork()); // 주말시급*근무시간
					day[x].setDailyTotal(day[x].getDailySalary() + day[x].getNightSalary() + day[x].getHolydaySalary()); // 주말시급*근무시간

					System.out.println("근무일자 " + day[x].getWorkDate());
					System.out.println("직원이름 " + day[x].getName());
					System.out.println("연차 " + day[x].getWorkYear());
					System.out.println("직원형태 " + day[x].getEmptype());
					System.out.println("평가등급 " + day[x].getGrade());
					System.out.println("정규근무시간 " + day[x].getDayworktime());
					System.out.println("야근근무시간 " + day[x].getNightworktime());
					System.out.println("주말근무시간 " + day[x].getHoildyworktime());
					System.out.println("일일기본급여 " + day[x].getDailySalary());
					System.out.println("일일야근급여 " + day[x].getNightSalary());
					System.out.println("주말근무급여 " + day[x].getHolydaySalary());
					System.out.println("합계일일급여 " + day[x].getDailyTotal());

				}
			}
			// 일일급여 데이터 생성 종료
			
			// 직원 정보 검색

						System.out.println("직원정보를 검색하시겠습니까?(예:1/ 아니오:2)");

						stop = numReturn();

						if (stop == 1) {
							System.out.println("직원이름을 입력하세요.");
							name = stringReturn();
							for (int i = SumNoEmp; i < SumNoEmp + empNo; i++) {
								if (day[i].getName().equals(name)) {

//									System.out.println("당일근무직원수 " + day[i].getSumNoEmp());
									System.out.println("근무일자 " + day[i].getWorkDate());
//									System.out.println("직원번호 " + day[i].getPinNo());
									System.out.println("직원이름 " + day[i].getName());
//									System.out.println("근무시작일 " + day[i].getJoindate());
									System.out.println("연차 " + day[i].getWorkYear());
									System.out.println("직원형태 " + day[i].getEmptype());
//									System.out.println("결혼기념일 " + day[i].getAnniversary());
//									System.out.println("배우자생일 " + day[i].getMatebirth());
//									System.out.println("부모생일 " + day[i].getParentbirth());
									System.out.println("평가등급 " + day[i].getGrade());
									System.out.println("근무일자 " + day[i].getSalaryday());
									System.out.println("급여계좌은행 " + day[i].getSalarybank());
									System.out.println("계좌번호 " + day[i].getSalaryaccount());
//									System.out.println("근무일자 " + day[i].getWiDate());
//									System.out.println("직원번호 " + day[i].getWiPin());
									System.out.println("정규근무시간 " + day[i].getDayworktime());
									System.out.println("야근근무시간 " + day[i].getNightworktime());
									System.out.println("주말근무시간 " + day[i].getHoildyworktime());
									System.out.println("일일기본급여 " + day[i].getDailySalary());
									System.out.println("일일야근급여 " + day[i].getNightSalary());
									System.out.println("주말근무급여 " + day[i].getHolydaySalary());
									System.out.println("기준연월 " + day[i].getYyyyMm());
									System.out.println("기준연 " + day[i].getYyyy());
									System.out.println("************************");

								}
							}
						}
						// 직원 정보 검색 종료

			// 직원정보 출력

			System.out.println("해당일 전체 직원 정보를 출력하시겠습니까?(예:1/ 아니오:2)");

			stop = numReturn(); //
			if (stop == 1) {
				for (int i = SumNoEmp; i < SumNoEmp + empNo; i++) {

//					System.out.println("당일근무직원수 " + day[i].getSumNoEmp());
					System.out.println("근무일자 " + day[i].getWorkDate());
//					System.out.println("직원번호 " + day[i].getPinNo());
					System.out.println("직원이름 " + day[i].getName());
//					System.out.println("근무시작일 " + day[i].getJoindate());
					System.out.println("연차 " + day[i].getWorkYear());
					System.out.println("직원형태 " + day[i].getEmptype());
//					System.out.println("결혼기념일 " + day[i].getAnniversary());
//					System.out.println("배우자생일 " + day[i].getMatebirth());
//					System.out.println("부모생일 " + day[i].getParentbirth());
					System.out.println("평가등급 " + day[i].getGrade());
					System.out.println("근무일자 " + day[i].getSalaryday());
					System.out.println("급여계좌은행 " + day[i].getSalarybank());
					System.out.println("계좌번호 " + day[i].getSalaryaccount());
//					System.out.println("근무일자 " + day[i].getWiDate());
//					System.out.println("직원번호 " + day[i].getWiPin());
					System.out.println("정규근무시간 " + day[i].getDayworktime());
					System.out.println("야근근무시간 " + day[i].getNightworktime());
					System.out.println("주말근무시간 " + day[i].getHoildyworktime());
					System.out.println("일일기본급여 " + day[i].getDailySalary());
					System.out.println("일일야근급여 " + day[i].getNightSalary());
					System.out.println("주말근무급여 " + day[i].getHolydaySalary());
					System.out.println("기준연월 " + day[i].getYyyyMm());
					System.out.println("기준연 " + day[i].getYyyy());
					System.out.println("************************");

				}
			}

			// 직원정보 출력 종료

			SumNoEmp = SumNoEmp + empNo;
			stop = numReturn();
		} while (stop != 6);
	}
}
