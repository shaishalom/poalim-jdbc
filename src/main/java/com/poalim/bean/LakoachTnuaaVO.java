package com.poalim.bean;

public class LakoachTnuaaVO {

	private Long id;
	private String name;
	private Double amount;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	private String esek;
	private String ccno;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEsek() {
		return esek;
	}

	public void setEsek(String esek) {
		this.esek = esek;
	}

	public String getCcno() {
		return ccno;
	}

	public void setCcno(String ccno) {
		this.ccno = ccno;
	}

	public LakoachTnuaaVO(Long id, String name, Double amount, String esek, String ccno) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.esek = esek;
		this.ccno = ccno;
	}

}
