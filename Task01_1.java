// Дана строка sql-запроса "select * from students where ". 
// Сформируйте часть WHERE этого запроса, используя StringBuilder. 
// Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"} 
// select * from students where 'name=Ivanov' and 'country=Russia' and...

public class Task01_1 {

    public static void main(String[] args) throws Exception {
        System.out.println(SQL("{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}"));
    }

    static StringBuilder SQL (String str){
        StringBuilder stringBuilder = new StringBuilder("select * from students where ");
        str = str.replace("{", "");
        str = str.replace("}", "");
        str = str.replaceAll("\"", "");
        String [] arr = str.split(",");
        for (int i = 0; i< arr.length; i++){
            String [] newArr = arr[i].split(":");

            if (newArr[1].equals("null") == false){
                if (i!=0) stringBuilder.append (" and "+ newArr[0] + " = '"+ newArr[1] + "'");
                else stringBuilder.append(newArr[0] + " = '"+ newArr[1] + "'");
            }
        }
        return stringBuilder;
    }
}
