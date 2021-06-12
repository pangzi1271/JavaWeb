import java.lang.reflect.Field;

public class ReflectUtil {

    public static String jsonObj(Object obj) {
        Class classFile = null;
        Field[] fieldArray = null;

        //由于要对字符串进行频繁的操作，所以使用StringBuffer类的对象
        StringBuffer str = new StringBuffer("{");
        //1.获得当前对象隶属的class文件
        classFile = obj.getClass();
        //2.获得【class文件】所有【属性】
        fieldArray = classFile.getDeclaredFields();
        //3.获得当前对象所有属性的值
        try {
            for (int i = 0; i < fieldArray.length; i++) {
                Field field = fieldArray[i];
                //确保私有访问权限属性可以在class文件外部使用
                field.setAccessible(true);

                //获得属性名称
                String fieldName = field.getName();
                Object value = null;
                value = field.get(obj);
                //4.将获得属性及其值拼接为JSON格式字符串
                str.append("\"");
                str.append(fieldName);
                str.append("\":");
                str.append("\"");
                str.append(value);
                str.append("\"");
                if (i < fieldArray.length - 1) {
                    str.append(",");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        str.append("}");
        return str.toString();
    }
}
