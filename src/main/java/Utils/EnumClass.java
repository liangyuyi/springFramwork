package Utils;

/**
 * 枚举类
 * Created by liangyuyi on 2017/7/5.
 */
public enum EnumClass {
    A("优秀"),
    B("良好"),
    C("及格"),
    D("不及格");

    private String description;
    private EnumClass(String description){//构造函数，私有
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public static void main(String[] args) {
        for(EnumClass enumClass: EnumClass.values()){//  遍历枚举的元素
            System.out.println(enumClass.getDescription());
        }
    }
}
