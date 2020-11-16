package com.sgte.response;

import com.sgte.sce.models.Turma;

public class ResponseInsertTurma <T> {
	
	private long su;
	
	private Turma turma;

	public long getSu() {
		return su;
	}

	public void setSu(long su) {
		this.su = su;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	@Override
	public String toString() {
		return "ResponseInsertTurma [su=" + su + ", turma=" + turma + "]";
	}
	

}
