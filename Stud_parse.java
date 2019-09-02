//
//Universidad San Francisco de Quito
//
// Authors: Cazco Jonathan
//			Naunay Erick
//
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Stud_parse
{
	public static List<Estudiante> createList() throws IOException
	{

		String filePath = "U1.txt";

		List<String> book1 = new ArrayList<>();

		//lectura de archivo
		Stream<String> l_stream = Files.lines(Paths.get(filePath));

		l_stream.forEach(line -> book1.add(line));
		l_stream.close();

		List<String[]> book2 = new ArrayList<>();

		//separacion por palabras de cada linea para uso en atributos
		for(String line : book1)
		{
			book2.add(line.split(","));//delimitador "," para distintos campos (csv)
		}


		List<Estudiante> book3 = new ArrayList<>(); //lista final para creacion de objeto

		for(String [] words : book2)
		{
			int last = words.length - 1;
			String [] crc = Arrays.copyOfRange(words, 4, last); //extractor de cursos

			crc = Arrays.stream(crc).sorted().toArray(String[]::new); //order alfabetico por default

			Estudiante inStud = new Estudiante
					(
					words[0],
					words[1],
					words[2],
					words[3],
					crc,
					Integer.parseInt(words[last])    //creacion de objeto Estudiante
					);

			book3.add(inStud); //añadir a lista de estudiantes

			//System.out.println("(ADD)Size of stud list so far:" + book3.size());

		}

		return book3;
	}

}
