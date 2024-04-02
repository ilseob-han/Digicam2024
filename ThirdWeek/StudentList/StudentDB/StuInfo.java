package StudentDB;

public class StuInfo {

	private int data;
	
	private String name;
	private int stuNo;
	private int kor;
	private int eng;
	private int mat;
	private int total;
	private double avg;

	StuInfo next;
	
	public StuInfo( ) {
		name = null;
		stuNo = 0;
		kor = 0;
		eng = 0;
		mat = 0;
		total = 0;
		avg = 0;
		data =0;
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStuNo() {
		return stuNo;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

    public int getTotal() {
        return kor + eng + mat;
    }

	public void setTotal() {
		this.total = kor + eng + mat;
	}

    public double getAvg() {
        avg = (double) (kor + eng + mat) / 3;
        return avg;
        
    }

	public void setAvg(float avg) {
		this.avg = avg;
	}

	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
}

//5, 1, 2, 3, 4,
// 1: 5 6 1 2 3 4
// 0: 5 6 1 2 3 4
// 2: 5, 1, 6, 2, 3, 4, 