import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Performance;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Properties;

public class Main {

    private static LocalDate parseDate(String date) {
        return date != null ? LocalDate.parse(date) : null;
    }
    private static LocalTime parseTime(String time) {
        return time != null ? LocalTime.parse(time) : null;
    }

    private static LocalDateTime parseDateTime(String date) {
        String pattern = "yyyy-MM-dd HH:mm:ss.SSS";
        return date != null ? LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern)) : null;
    }

    public static void main(String[] args) throws SQLException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Properties props = new Properties();
        props.put("user", user");
        props.put("password", "password");
        props.put("db", "db_name");
        props.put("schema", "schema_name");
        props.put("warehouse", "warehouse_name");
        Connection conn = DriverManager.getConnection("jdbc:snowflake://xk71904.us-east-2.aws.snowflakecomputing.com/?CLIENT_RESULT_COLUMN_CASE_INSENSITIVE=true",
                props);
        PreparedStatement ps = conn.prepareStatement("select * from VIEW_PERFORMANCE_TOP10");
        ResultSet results = ps.executeQuery();
        Performance record = createRecord(Performance.class, results);
        System.out.println(gson.toJson(record).toString());
    }


    public static <T> T createRecord(Class columnClass, ResultSet data) {
        T record = null;
        try {
            record = (T) columnClass.getDeclaredConstructor().newInstance();

            Field[] fields = columnClass.getDeclaredFields();
            for (Field field : fields) {
                Annotation serializedName = Arrays.stream(columnClass
                                .getDeclaredField(field.getName())
                                .getDeclaredAnnotations())
                        .filter(a -> a.annotationType().getSimpleName().equalsIgnoreCase("SerializedName"))
                        .findFirst().orElse(null);

                String columnName = serializedName.annotationType().getDeclaredMethod("value").invoke(serializedName).toString();
                Method method = Arrays.stream(record.getClass().getDeclaredMethods()).filter(m -> m.getName().equalsIgnoreCase("set" + field.getName())).findFirst().orElseThrow();
                switch (field.getType().getSimpleName().toLowerCase()) {
                    case "string" -> method.invoke(record, data.getString(columnName));
                    case "boolean" -> method.invoke(record, data.getBoolean(columnName));
                    case "byte" -> method.invoke(record, data.getByte(columnName));
                    case "int", "integer" -> method.invoke(record, data.getInt(columnName));
                    case "short" -> method.invoke(record, data.getShort(columnName));
                    case "long" -> method.invoke(record, data.getLong(columnName));
                    case "float" -> method.invoke(record, data.getFloat(columnName));
                    case "double" -> method.invoke(record, data.getDouble(columnName));
                    case "bigdecimal" -> method.invoke(record, data.getBigDecimal(columnName));
                    case "localtime" -> method.invoke(record, parseTime(data.getString(columnName)));
                    case "localdate" -> method.invoke(record, parseDate(data.getString(columnName)));
                    case "localdatetime" -> method.invoke(record, parseDateTime(data.getString(columnName)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return record;
    }
}
