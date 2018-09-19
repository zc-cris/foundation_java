package day24;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class AreaManager {
    private HashMap<Province, HashSet<City>> map;

    public static void main(String[] args) {
        AreaManager areaManager = new AreaManager();
        HashSet<City> city = areaManager.findCity(2);
        System.out.println("city = " + city);
    }

    public AreaManager() {
        map = new HashMap<Province, HashSet<City>>();

        HashSet<City> bj = new HashSet<City>();
        bj.add(new City(1, "北京市", 1));
        map.put(new Province(1, "北京市"), bj);

        HashSet<City> hn = new HashSet<City>();
        hn.add(new City(1, "海口市", 2));
        hn.add(new City(2, "三亚市", 2));
        map.put(new Province(2, "海南省"), hn);

        HashSet<City> zj = new HashSet<City>();
        zj.add(new City(1, "绍兴市", 3));
        zj.add(new City(2, "温州市", 3));
        zj.add(new City(3, "湖州市", 3));
        zj.add(new City(4, "嘉兴市", 3));
        zj.add(new City(5, "台州市", 3));
        zj.add(new City(6, "金华市", 3));
        zj.add(new City(7, "舟山市", 3));
        zj.add(new City(8, "衢州市", 3));
        zj.add(new City(9, "丽水市", 3));
        map.put(new Province(3, "浙江省"), zj);
    }

    public HashSet<City> findCity(int pid) {
        Set<Province> provinces = map.keySet();
        for (Province province : provinces) {
            if (province.getId() == pid) {
                return map.get(province);
            }
        }
        return null;

//        final Set<City>[] set = new Set[1];
//        map.forEach((k, v) -> {
//            if (k.getId() == pid) {
//                set[0] = v;
//            }
//        });
//        return (HashSet<City>) set[0];
    }
}

