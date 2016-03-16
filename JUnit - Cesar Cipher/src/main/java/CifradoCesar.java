public class CifradoCesar {
    private String cadena;

    public CifradoCesar(String cadena) {
        this.cadena = cadena;
    }

    public static void main(String[] args) {
        CifradoCesar cc = new CifradoCesar("Todo lo que se preguntaba eran las mismas respuestas que buscamos el resto de nosotros. De donde vengo? A donde voy? Cuanto tiempo tengo? Todo lo que pude hacer fue sentarme y ver como moria.");
        System.out.println(cc.cifrarCadena());
        System.out.println(cc.descifrarCadena());
    }

    public String cifrarCadena() {
        return traducirCadena("cifrar");
    }

    public String descifrarCadena() {
        return traducirCadena("descifrar");
    }

    private String traducirCadena(String operacion) {
        String cadenaCifrada = "";
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.toLowerCase().charAt(i);
            if (caracter >= 97 && caracter <= 122) {
                if (operacion.equals("cifrar")) {
                    if (caracter >= 'x') {
                        caracter = (char) ('a' + ('z' - caracter));
                    } else {
                        caracter += 3;
                    }
                    cadenaCifrada += (char) (caracter);
                } else {
                    if (caracter <= 'c') {
                        caracter = (char) ('z' - (caracter - 'a'));
                    } else {
                        caracter -= 3;
                    }
                    cadenaCifrada += (char) (caracter);
                }

            } else {
                cadenaCifrada += caracter;
            }
        }

        cadena = cadenaCifrada;
        return cadena;
    }

} 