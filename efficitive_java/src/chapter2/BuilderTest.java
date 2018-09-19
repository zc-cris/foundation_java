package chapter2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName BuilderTest
 * @Description test Builder design mode to replace kinds of constructor
 * @Author zc-cris
 * @Version 1.0
 **/
public class BuilderTest {
    public static void main(String[] args) {

        // get the outer class instance by the inner builder class instance
        Man cris = new Man.ManBuilder(25, "cris").house(new House("北京三环")).wife(new Wife("日本媳妇儿")).build();
        System.out.println("cris = " + cris);

        // get the builder instance to create kinds of outer class instance conveniently
        Builder<Man> builder = new Man.ManBuilder(24,"james");
        Man man = ((Man.ManBuilder) builder).wife(new Wife("韩国妞儿")).job("IT 精英").build();
        System.out.println("man = " + man);

    }
}

class Man {
    /**
     * required params
     **/
    private final Integer age;
    private final String name;
    /**
     * optional params
     **/
    private final String job;
    private final House house;
    private final Wife wife;

    /**
     * @Author zc-cris
     * @Description the inner builder class to create outer instance conveniently
     * @Param
     * @return
     **/
    public static class ManBuilder implements Builder<Man> {
        /**
         * required params
         **/
        private final Integer age;
        private final String name;
        /**
         * optional params - initialized to default values
         **/
        private String job = "无业游民";
        private House house;
        private Wife wife;

        public ManBuilder(Integer age, String name) {
            this.age = age;
            this.name = name;
        }

        public ManBuilder job(String job) {
            this.job = job;
            return this;
        }

        public ManBuilder house(House house) {
            this.house = house;
            return this;
        }

        public ManBuilder wife(Wife wife) {
            this.wife = wife;
            return this;
        }

        @Override
        public Man build() {
            return new Man(this);
        }

    }

    private Man(ManBuilder manBuilder) {
        this.age = manBuilder.age;
        this.name = manBuilder.name;
        this.job = manBuilder.job;
        this.house = manBuilder.house;
        this.wife = manBuilder.wife;
    }

    @Override
    public String toString() {
        return "Man{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", house=" + house +
                ", wife=" + wife +
                '}';
    }
}
/**
 * @Author zc-cris
 * @Description definite builder interface to accept the inner class ManBuilder
 * @Param
 * @return
 **/
interface Builder<T>{
    T build();
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
class House {
    private String name;
}
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
class Wife {
    private String name;
}
