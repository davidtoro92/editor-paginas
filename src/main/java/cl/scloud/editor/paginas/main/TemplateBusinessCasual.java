package cl.scloud.editor.paginas.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cl.scloud.editor.paginas.enums.OpcionesMenuNavegacionEnum;

public class TemplateBusinessCasual {

	private static final String contexto = "/Users/David/Trabajo/Templates-Bootstrap/startbootstrap-business-casual-gh-pages/";
	private final Log LOGGER = LogFactory.getLog(TemplateBusinessCasual.class);

	public static void main(String[] args) {
		final TemplateBusinessCasual bussCas = new TemplateBusinessCasual();

		ArrayList<String> paginas = new ArrayList<String>();
		paginas.add("index.html");
		paginas.add("about.html");
		paginas.add("blog.html");
		paginas.add("contact.html");

		bussCas.generarNuevaPagina(paginas);
	}

	private void generarNuevaPagina(final ArrayList<String> paginas) {

		final Scanner sc = new Scanner(System.in);
		try {
			for (String pagina : paginas) {
				
				LOGGER.debug("Editando la pagina " + pagina);
				
				File input = new File(contexto + pagina);
				Document doc = Jsoup.parse(input, "UTF-8");
				
				this.editarTitulosTemplate(sc, doc);
				Map<String, String> opcionesMenuStr = this.solicitarOpcionesMenu(sc);
				this.editarMenuesTemplate(sc, doc, opcionesMenuStr);
				
				LOGGER.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				LOGGER.debug(doc.toString());
				LOGGER.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				
				/*escribir archivo con FileInputStream :D*/
			}

		} catch (IOException e) {
			LOGGER.error("Problemas al editar la pagina. Detalles del problema: " + e.getMessage());
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
	
	private Map<String, String> solicitarOpcionesMenu(final Scanner sc) {
		
		System.out.print("Ingresa el nuevo nombre para el menu HOME: ");
		String home = sc.nextLine();
		System.out.print("Ingresa el nuevo nombre para el menu ABOUT: ");
		String about = sc.nextLine();
		System.out.print("Ingresa el nuevo nombre para el menu BLOG: ");
		String blog = sc.nextLine();
		System.out.print("Ingresa el nuevo nombre para el menu CONTACT: ");
		String contact = sc.nextLine();
		
		Map<String, String> opcionesMenuStr = new HashMap<>();
		
		opcionesMenuStr.put("HOME", home);
		opcionesMenuStr.put("ABOUT", about);
		opcionesMenuStr.put("BLOG", blog);
		opcionesMenuStr.put("CONTACT", contact);
		
		return opcionesMenuStr;
	}

	private void editarTitulosTemplate(final Scanner sc, Document doc) {
		//titulo-pagina

	}

	private void editarMenuesTemplate(final Scanner sc, Document doc, final Map<String, String> opcionesMenuStr) throws IOException {
		
		Element opcionesMenu = doc.getElementById("listado-opciones-menu");
		Elements links = opcionesMenu.getElementsByTag("a");
		
		for (Element link : links) {
			switch (OpcionesMenuNavegacionEnum.valueOf(link.text().toUpperCase())) {
			case HOME:
				link.text(opcionesMenuStr.get("HOME"));
				break;
			case ABOUT:
				link.text(opcionesMenuStr.get("ABOUT"));
				break;
			case BLOG:
				link.text(opcionesMenuStr.get("BLOG"));
				break;
			case CONTACT:
				link.text(opcionesMenuStr.get("CONTACT"));
				break;
			default:
				LOGGER.error("error");
				break;
			}
			
		}

	}

}
