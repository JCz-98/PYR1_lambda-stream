//
//Universidad San Francisco de Quito
//
// Authors: Cazco Jonathan
//			Naunay Erick
//
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Estudiante
{
	//atributos
	private String codigo;
	private String nombre;
	private String apellido;
	private String f_nac;
	private String[] cursos;
	private int credit;

	private int dia, mes, ano;

	//comtructor
	public Estudiante(String cd, String n, String a, String fna, String[] cur, int cred)
	{
		setCodigo(cd);
		setNombre(n);
		setApellido(a);
		setF_nac(fna);
		this.cursos = cur.clone();
		setCredit(cred);
	}

	@Override
    public String toString()
	{
        return String.format
        		(codigo + "\t" + nombre + "\t" + apellido + "\t"+ f_nac + "\t"+ Arrays.toString(cursos) + "\t" + credit);
    }

	public void crs_reverse() //metodo especial para orden_2 que ordena cursos al reverso
	{
		List<String> c_order = new ArrayList<String>();

		c_order = Arrays.asList(cursos.clone());
		Collections.reverse(c_order);

    System.out.println(codigo + "\t" + nombre + "\t" + apellido + "\t"+ f_nac + "\t"+ c_order.toString() + "\t" + credit);


	}

	//getter and setters
	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getF_nac() {
		return f_nac;
	}

	//set fecha birthday separa cada dato en sus variables correspondientes
	public void setF_nac(String f_nac) {
		String fecha[] = f_nac.split("/");

		setDia(Integer.parseInt(fecha[0]));
		setMes(Integer.parseInt(fecha[1]));
		setAno(Integer.parseInt(fecha[2]));

		this.f_nac = f_nac;
	}


	public String[] getCursos() {
		return cursos;
	}


	public void setCursos(String[] cursos) {
		this.cursos = cursos;
	}


	public int getCredit() {
		return credit;
	}


	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

}
