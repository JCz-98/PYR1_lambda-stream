//
//Universidad San Francisco de Quito
//
// Authors: Cazco Jonathan
//			Naunay Erick
//
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GOstreams
{

	public static void goStreams(List<Estudiante> ST)
	{
		order_1(ST);
		order_2(ST);
		order_3(ST);
		order_4(ST);
		order_5(ST);
		order_6(ST);

	}

	public static void order_1(List<Estudiante> studs)
	{
		//ordenado por codigo
		Function<Estudiante, String> byCode = Estudiante::getCodigo;

		System.out.printf("%nORDEN 1 (Codigo)%n");
		studs.stream().sorted(Comparator.comparing(byCode)).forEach(System.out::println);
	}

	public static void order_2(List<Estudiante> studs)
	{
		//ordenado por apellido
		Function<Estudiante, String> byLN = Estudiante::getApellido;

		System.out.printf("%nORDEN 2 (Apellido)%n");
		studs.stream().sorted(Comparator.comparing(byLN)).forEach(estud -> estud.crs_reverse());
	}

	public static void order_3(List<Estudiante> studs)
	{
		//agrupamiento por numero de creditos
		System.out.printf("%nORDEN 3 (Creditos)%n");
		Map<Integer, List<Estudiante>> porCred =
				studs.stream()
				.collect(Collectors.groupingBy(Estudiante::getCredit));

		porCred.forEach
		(
				(creditos, stud_per_cred) ->
				{
					System.out.println("Creditos: " + creditos);
					stud_per_cred.forEach(stud -> System.out.printf("\t%s%n", stud));
				}
		); //referencia Java How to program pg.756

	}

	public static void order_4(List<Estudiante> studs) {

		System.out.printf("%nORDEN 4 (Mismo año de nacimiento)%n");

		//agrupamiento por año de nacimiento
		Map<Integer, List<Estudiante>> porAno =
				studs.stream().collect(Collectors.groupingBy(Estudiante::getAno));

		//iteracion del mapa para impresion
		porAno.forEach(

				(ano, lista_stud) ->{
					System.out.println("Año de nacimiento: " + ano);
					lista_stud.forEach(stud -> System.out.printf("\t%s%n", stud));
				});

	}

	public static void order_5(List<Estudiante> studs) {

		//Predicador creado para filtar por numero de cursos CMP dos o mas
		Predicate<Estudiante> twoOrMoreCmpCourses = e -> {
					int counter = 0;

					//iterador de todos los cursos por estudiante
					for(String curso: e.getCursos()) {

						//validador de cursos CMP, cuenta el numero de CMP
						if (curso.startsWith("CMP")) {
							counter++;

							//si encontro 2 como minimo
							if (counter == 2)
								return true;
						}
					}

					return false;
				};


		System.out.printf("%nORDEN 5 (2 o mas CMP y orden codigo)%n");

		//stream filtado por el numero de cursos cmp, luego ordena por codigo e imprime toda la lista de cursos
		studs.stream().filter(twoOrMoreCmpCourses)
			.sorted(Comparator.comparing(Estudiante::getCodigo))
			.forEach(System.out::println);

	}

	public static void order_6(List<Estudiante> studs) {

		//Predicador creado para filtar por numero de cursos CMP zero
		Predicate<Estudiante> zeroCmpCourses = e -> {

					//iterador de todos los cursos por estudiante
					for(String curso: e.getCursos()) {

						//validador de cursos CMP, si encuentra alguno return false
						if (curso.startsWith("CMP"))
							return false;

					}

					return true;
			};


		System.out.printf("%nORDEN 6 (NO CMP y orden apellido)%n");

		//stream filtado por el numero de cursos cmp, luego ordena por codigo e imprime toda la lista de cursos
		studs.stream().filter(zeroCmpCourses)
			.sorted(Comparator.comparing(Estudiante::getApellido))
			.forEach(System.out::println);

	}

}
