package resources.vo;

import java.util.Calendar;

public class VeiculoVO {

	private int id;
	private Calendar anoFabricao;
	private Calendar anoModelo;
	private Integer cdFabricanteVeiculo;
	private String motor;
	private String cor;
	private String placa;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getAnoFabricao() {
		return anoFabricao;
	}

	public void setAnoFabricao(Calendar anoFabricao) {
		this.anoFabricao = anoFabricao;
	}

	public Calendar getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Calendar anoModelo) {
		this.anoModelo = anoModelo;
	}

	public Integer getCdFabricanteVeiculo() {
		return cdFabricanteVeiculo;
	}

	public void setCdFabricanteVeiculo(Integer cdFabricanteVeiculo) {
		this.cdFabricanteVeiculo = cdFabricanteVeiculo;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
}
