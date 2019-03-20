package ua.lviv.lgs.domain;

public class Accounting {
	private int id;
	private int user_id;
	private int operation_id;
	private double sum;
	
	public Accounting(int id, int user_id, int operation_id, double sum) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.operation_id = operation_id;
		this.sum = sum;
	}
	
	public Accounting(int user_id, int operation_id, double sum) {
		super();
		this.user_id = user_id;
		this.operation_id = operation_id;
		this.sum = sum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getOperation_id() {
		return operation_id;
	}

	public void setOperation_id(int operation_id) {
		this.operation_id = operation_id;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + operation_id;
		long temp;
		temp = Double.doubleToLongBits(sum);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + user_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accounting other = (Accounting) obj;
		if (id != other.id)
			return false;
		if (operation_id != other.operation_id)
			return false;
		if (Double.doubleToLongBits(sum) != Double.doubleToLongBits(other.sum))
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}
	
	
	
}
