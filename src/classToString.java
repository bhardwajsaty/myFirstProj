import java.util.ArrayList;

public class classToString {

    public static void main(String[] args) {
        subject sb = new subject(4,"Satyam");
        System.out.println(sb);

        ArrayList st = new ArrayList();
        st.add(sb.id);
        st.add(sb.sname);
        System.out.println(st);
        System.out.println(st.get(0));
        System.out.println(st.get(1));


        ArrayList<subject> sc = new ArrayList<>();
        sc.add(new subject(5,"shivam"));
       // System.out.println(sc);
       // System.out.println(sc.get(0));
       // System.out.println(sc.get(1));





    }

    public static  class subject{
        int id;
        String sname;
        public subject(int id , String sname){
            this.id=id;
            this.sname=sname;

        }
       public String toString(){
           // ArrayList<>
            return id+", "+sname;
        }

    }
}
