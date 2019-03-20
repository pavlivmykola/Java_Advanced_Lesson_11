package ua.lviv.lgs.domain;

import java.sql.Date;

public class Subscriptions {
	private int id;
	private int user_id;
	private int jornal_id;
	private Date start;
	private Date end;
	
	public Subscriptions(int id, int user_id, int jornal_id, Date start, Date end) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.jornal_id = jornal_id;
		this.start = start;
		this.end = end;
	}
	
	public Subscriptions(int user_id, int jornal_id, Date start, Date end) {
		super();
		this.user_id = user_id;
		this.jornal_id = jornal_id;
		this.start = start;
		this.end = end;
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

	public int getJornal_id() {
		return jornal_id;
	}

	public void setJornal_id(int jornal_id) {
		this.jornal_id = jornal_id;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + id;
		result = prime * result + jornal_id;
		result = prime * result + ((start == null) ? 0 : start.hashCode());
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
		Subscriptions other = (Subscriptions) obj;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (id != other.id)
			return false;
		if (jornal_id != other.jornal_id)
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}
	

}
