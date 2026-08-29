package com.curso.v0;

public class CalculoComplejo implements ICalculoComplejo {

	@Override
	public double ejecutaCalculoComplejo(byte b, char ch, short sh, int i, long l, float f) {

		double resultado = 0;

		resultado += Math.pow(b, 2);
		resultado += ch; // usa el valor numérico Unicode del char
		resultado += Math.sqrt(Math.abs(sh));
		resultado += Math.log(Math.abs(i) + 1);
		resultado += Math.sin(l);
		resultado += Math.cos(f);

		resultado *= (b + sh + 1);

		resultado /= (Math.abs(f) + 1);

		resultado += ((double) i * l) / (Math.abs(ch) + 1);

		return resultado;

	}
}