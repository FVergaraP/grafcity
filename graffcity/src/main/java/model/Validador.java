package model;

public class Validador {
	
	public Validador(){
	}

	public boolean isUsernameOrPasswordValid(String $cadena) {
        char[] cadena = $cadena.toLowerCase().toCharArray();
 
        //Compruebo la longitud
        if (cadena.length <= 6) {
            return false;
        }
        for (int i = 0; i < cadena.length; i++) {
            //Compruebo que no existan caracteres especiales (solamento los que podrian ser usados para una inyeccion SQL o perjudicar en la consulta);
            if (cadena[i] == ' '
                    || cadena[i] == '='
                    || cadena[i] == '?'
                    || cadena[i] == '+'
                    || cadena[i] == '*'
                    || cadena[i] == '-'
                    || cadena[i] == '%'
                    || cadena[i] == '/'
                    || cadena[i] == '.'
                    || cadena[i] == ','
                    || cadena[i] == ';'
                    || cadena[i] == '!'
                    || cadena[i] == '<'
                    || cadena[i] == '>'
                    || cadena[i] == ':') {
                return false;
            }
 
        }
        return true;
    }
}
