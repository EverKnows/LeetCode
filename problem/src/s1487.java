import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jianmiao.xu
 * @date 2021/5/7
 */
public class s1487 {
    public String[] getFolderNames(String[] names) {

        String[] result = new String[names.length];
        Map<String, Integer> map = new HashMap<>();

        int count = 0;
        for (String name : names) {
            if (map.containsKey(name)) {

                Integer mark = map.get(name);
                int tempCount = mark + 1;
                String newName = name.concat("(" + tempCount + ")");

                while(map.containsKey(newName)) {
                    newName = name.concat("(" + ++tempCount + ")");
                }
                map.put(name, tempCount);
                map.put(newName, 1);
                result[count++] = newName;

                continue;
            }
            map.put(name, 0);
            result[count++] = name;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] names = {"gta","gta(1)","gta","avalon"};

        System.out.println(Arrays.toString(new s1487().getFolderNames(names)));
    }
}