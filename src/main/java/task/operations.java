package task;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Stateless
@Entity

public class operations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int ID;
	int Number1;
	int Number2;
	String op;
	
	public int getNumber1() {
		return Number1;
	}
	public void setNumber1(int number1) {
		Number1 = number1;
	}
	public int getNumber2() {
		return Number2;
	}
	public void setNumber2(int number2) {
		Number2 = number2;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
}
