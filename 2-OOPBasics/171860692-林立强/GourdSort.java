import java.sql.Array;
import java.util.ArrayList;
import java.util.*;
public class GourdSort {
    public static void main(String[] args){
        GroudGroup group=new GroudGroup();
        group.generate();
        group.popsort();
        group.sayname();
        group.mergesort(0,6);
        group.saycolor();
    }
}

