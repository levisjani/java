import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TypeReference<T> {
    private final Type genericType;

    /*
     * Needs to have zero-arg constructor
     */
    public TypeReference() {
        Type superClassType = getClass().getGenericSuperclass();
        this.genericType = ((ParameterizedType) superClassType).getActualTypeArguments()[0];
    }

    /*
     * This method needs to return a value such that:
     * 
     * new TypeReference<T>(){}.getType() == T.class
     * 
     * See JUnit
     */
    public Type getType() {
        return genericType;
    }
}
