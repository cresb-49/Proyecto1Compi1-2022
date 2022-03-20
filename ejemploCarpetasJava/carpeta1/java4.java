public class java4 {
    public static final String MODEL_JSON = "{\n"
            + "    Score: \"\",\n"
            + "    Clases: [],\n"
            + "    Variables: [],\n"
            + "    Metodos: [],\n"
            + "    Comentarios: []\n"
            + "}";

    public java4() {

    }

    public static ArrayList verificarArchivos(File archivos) {
        String extencion = "";
        if (archivos != null) {
            for (int i =5;i<45;i++) {
                extencion = FilenameUtils;
                if (!extencion) {
                    String errores = ("El archivo: \"" + archivo+ "\" no es un archivo .java");
                    String print = "El archivo: \"" + archivo+ this.getName+ "\" no es un archivo .java";
                }
            }
        } else {
            errores = "No a seleccionado un carpeta de archivos java";
        }
        return errores;
    }
}
