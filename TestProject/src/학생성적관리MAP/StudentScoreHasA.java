package 학생성적관리MAP;
import Name;
import Subject;

public class StudentScoreHasA {
	private Name name;
	private Name stuNo;
	private Subject kor;
	private Subject eng;
	private Subject mat;
	private int total;
	private float avg;

	
	public StudentScoreHasA() {
		name = new Name();
		stuNo = new Name();
		kor = new Subject();
		eng = new Subject();
		mat = new Subject();
		
	}

	
	
	public Name getStuNo() {
		return getStuNo();
	}



	public void setStuNo(int stuNo) {
		this.stuNo.setStuNo(stuNo);
	}



	public void setName1(String name) {
		this.name.setName2(name);
	}
	
	public void setKor(int kor) {
		this.kor.setSubject(kor);
	}
	
	public void setEng(int eng) {
		this.eng.setSubject(eng);
	}
	
	public void setMat(int mat) {
		this.mat.setSubject(mat);
	}

	public String getName() {
        return name.getName();
    }
    
    public int getKor() {
        return kor.getSubject(); 
    }
    
    public int getEng() {
        return eng.getSubject(); 
    }
    
    public int getMat() {
        return mat.getSubject();
    }

    // 합계 계산
    public int getTotal() {
        total = kor.getSubject() + eng.getSubject() + mat.getSubject();
        return total;
    }
    
 // 평균 계산
    public float getAvg() {
        avg = (float) total / 3;
        return avg;
    }
	
}
