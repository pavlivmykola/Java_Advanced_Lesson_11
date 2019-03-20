package ua.lviv.lgs.domain;

public class Jornals {
	private int id;
	private String name;
	private int reit;
	private double price;
	private String description;
	
	
	public Jornals(int id, String name, int reit, double price, String description) {
		super();
		this.id = id;
		this.name = name;
		this.reit=reit;
		this.price=price;
		this.description = description;
	}

	public Jornals(String name, int reit, double price, String description) {
		super();
		this.name = name;
		this.reit=reit;
		this.price=price;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public int getReit() {
		return reit;
	}

	public void setReit(int reit) {
		this.reit = reit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Jornals [id=" + id + ", name=" + name + ", reit=" + reit + ", price=" + price + ", description="
				+ description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + reit;
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
		Jornals other = (Jornals) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (reit != other.reit)
			return false;
		return true;
	}

	
	
	
	
}
