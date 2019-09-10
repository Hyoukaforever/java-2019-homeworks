import javax.swing.event.ListDataListener;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class GroudGroup {
    private GourdBaby []babies=new GourdBaby[7];
    void sayidx(){
        for(int i=0;i<7;i++){
            babies[i].sayidx();
        }
    }
    void saycolor(){
        for(int i=0;i<7;i++){
            babies[i].saycolor();
        }
    }
    void generate(){
        String [] colors={"赤","橙","黄","绿","青","蓝","紫"};
        String [] names={"老大","老二","老三","老四","老五","老六","老七"};
        Integer [] orignal={0,1,2,3,4,5,6};
        List temp= Arrays.asList(orignal);
        Collections.shuffle(temp);
        Integer [] idx =(Integer[]) temp.toArray(new Integer[temp.size()]);
        for(int i=0;i<7;i++){
            babies[i]=new GourdBaby(idx[i],names[idx[i]],colors[idx[i]]);
        }
    }
    void popsort(){
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                if(babies[i].idx<babies[j].idx){
                    babies[j].report(j,i);
                    babies[i].report(i,j);
                    GourdBaby temp=babies[j];
                    babies[j]=babies[i];
                    babies[i]=temp;
                }
            }
        }
    }
    void mergesort(int i,int j){
        if (j-i<1){
            return;
        }
        if (j-i==1){
            if(babies[i].idx>babies[j].idx){
                babies[j].report(j,i);
                babies[i].report(i,j);
                GourdBaby temp=babies[j];
                babies[j]=babies[i];
                babies[i]=temp;
            }
            return;
        }
        else{
            mergesort(i,(j+i)/2);
            mergesort((j+i)/2+1,j);
            GourdBaby[] temp=new GourdBaby[7];
            int n=i;
            int m=(j+i)/2+1;
            for(int k=i;k<j+1;k++) {
                if (n > (j + i) / 2) {
                    babies[m].report(m, k);
                    temp[k] = babies[m];
                    m += 1;
                } else if (m > j) {
                    babies[n].report(n, k);
                    temp[k] = babies[n];
                    n += 1;
                } else if (babies[n].idx < babies[m].idx) {
                    babies[n].report(n, k);
                    temp[k] = babies[n];
                    n += 1;
                } else {
                    babies[m].report(m, k);
                    temp[k] = babies[m];
                    m += 1;
                }
            }
            for(int k=i;k<j+1;k++){
                babies[k]=temp[k];
            }
            return;
        }
    }

}
