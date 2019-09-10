class GourdBaby {
    int idx;
    String name;
    String color;
    void report(int pos1,int pos2){
        System.out.printf("%s: %d -> %d\n",name,pos1,pos2);
    }
    void sayname(){System.out.print(name);}
    void saycolor(){System.out.print(color);}
    GourdBaby(int idx,String name,String color){
        this.idx=idx;
        this.name=name;
        this.color=color;
    }
}
