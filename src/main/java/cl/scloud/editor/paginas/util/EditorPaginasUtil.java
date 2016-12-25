package cl.scloud.editor.paginas.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EditorPaginasUtil {

	public static void persistirEdicionPagina(final File nuevoArchivo, final String contenidoPagina) throws IOException {
		OutputStream outStr = new FileOutputStream(nuevoArchivo);
		outStr.write(contenidoPagina.getBytes());
		outStr.close();
	}
}
