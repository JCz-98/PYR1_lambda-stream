//
//Universidad San Francisco de Quito
//
// Authors: Cazco Jonathan
//			Naunay Erick
//
import java.util.List;

public class LS_main 
{
	public static void main(String [ ] args) throws Exception
	{	
		
		//obtener data del fichero
		List<Estudiante> mainIndex = Stud_parse.createList();
		
		System.out.printf("%nLista de estudiantes tras lectura: %n");
		mainIndex.forEach(stud -> System.out.println(stud));
		
		//reporte datos
		GOstreams.goStreams(mainIndex);

	}
	
}
	
