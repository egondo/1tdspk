import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Util {

    private static String getAtributoJson(Method met) {
        String aux = met.getName().replaceAll("get", "").toLowerCase();
        return "\"" + aux + "\"";
    }

    private static String getValorJson(Method met, Object obj) throws Exception {
        Class c = met.getReturnType();
        if (c.getName().contains("String"))
            return "\"" + met.invoke(obj).toString() + "\"";
        else
            return met.invoke(obj).toString();
    }

    public static String toJson(Object objeto) {

        StringBuffer sb = new StringBuffer("{\n");

        Class classe = objeto.getClass();

        Method[] metodos = classe.getDeclaredMethods();
        for(Method m : metodos) {
            //System.out.println(m.getName());
            if (m.getName().startsWith("get")) {
                try {
                    Object valor = m.invoke(objeto);
                    //System.out.println(m.getName() + " -> " + valor);
                    String aux = getAtributoJson(m) +  ": " + getValorJson(m, objeto);
                    sb.append("\t");
                    sb.append(aux);
                    sb.append(",\n");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        sb.append("\t\"objeto\": \"");
        sb.append(classe.getName());
        sb.append("\"");
        sb.append("\n}");
        return sb.toString();
    }

}
